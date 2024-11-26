import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class SalaAssento {
    private int idSalaAssento;
    private Assento assento;
    private Sala sala;
    public ArrayList<SalaAssento> salaAssentos;
    
    public void setAssento(Assento assento) {
        this.assento = assento;
    }
    
    public void setIdSalaAssento(int idSalaAssento) {
        this.idSalaAssento = idSalaAssento;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    public Assento getAssento() {
        return assento;
    }
    
    public int getIdSalaAssento() {
        return idSalaAssento;
    }
    
    public Sala getSala() {
        return sala;
    }

    public SalaAssento(){
        this.salaAssentos = new ArrayList<>();
    }
    
    public SalaAssento(int idSalaAssento, Assento assento, Sala sala) {
        this.idSalaAssento = idSalaAssento;
        this.assento = assento;
        this.sala = sala;
        this.salaAssentos = new ArrayList<>();
    }

    public boolean cadastrar() throws IOException {
        FileWriter fw = new FileWriter("salaassento.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(this.idSalaAssento + ";" + this.assento + ";" + this.sala + ";");
        bw.newLine();
        bw.close();
        return true;
    }

    public boolean editar(int id) throws IOException {
        File arquivo = new File("salaassento.txt");
        List<String> linhas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                if (Integer.parseInt(dados[0]) == id) {
                    linha = this.idSalaAssento + ";" + this.assento + ";" + this.sala + ";";
                    encontrado = true;
                }
                linhas.add(linha);
            }
        }
        if (encontrado) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
                for (String linha : linhas) {
                    bw.write(linha);
                    bw.newLine();
                }
            }
        }
        return encontrado;
    }

    public SalaAssento consultar(int id) throws IOException {
        try (
                FileReader fr = new FileReader("sala.txt");
                BufferedReader reader = new BufferedReader(fr)
        ) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (id == Integer.parseInt(dados[0])) {
                    return new SalaAssento(Integer.parseInt(dados[0]), this.assento, this.sala);
                }
            }
            System.out.println("SalaAssento não encontrada.");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public ArrayList<SalaAssento> listar() throws IOException{
        try (
                FileReader fr = new FileReader("salaassento.txt");
                BufferedReader reader = new BufferedReader(fr)) {
            String linha;
            while((linha = reader.readLine()) != null){
                String[] dados = linha.split(";");
                SalaAssento salaAssento = new SalaAssento(Integer.parseInt(dados[0]), this.assento, this.sala);
                salaAssentos.add(salaAssento);
            }

            System.out.println("SalaAssentos listadas:");
            for (SalaAssento salaAssentoLista : salaAssentos) {
                System.out.println(salaAssentoLista.idSalaAssento);
            }
            System.out.println("-------------------------");

            return this.salaAssentos;
        } catch (IOException e) {
            e.printStackTrace();
            return this.salaAssentos;
        }
    }

}
