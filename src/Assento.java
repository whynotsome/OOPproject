import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Assento {
    private int idAssento;
    private TipoAssento tipoAssento;
    public ArrayList<Assento> assentos;
    
    public void setIdAssento(int idAssento) {
        this.idAssento = idAssento;
    }
    
    public void setTipoAssento(TipoAssento tipoAssento) {
        this.tipoAssento = tipoAssento;
    }
    
    public int getIdAssento() {
        return idAssento;
    }

    public TipoAssento getTipoAssento() {
        return tipoAssento;
    }

    public Assento() {
        this.assentos = new ArrayList<>();
    }
    
    public Assento(int idAssento, TipoAssento tipoAssento) {
        this.idAssento = idAssento;
        this.tipoAssento = tipoAssento;
        this.assentos = new ArrayList<>();
    }

    public boolean cadastrar() throws IOException {
        FileWriter fw = new FileWriter("assento.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(this.idAssento + ";" + this.tipoAssento + ";");
        bw.newLine();
        bw.close();
        return true;
    }

    public boolean editar(int id) throws IOException {
        File arquivo = new File("assento.txt");
        List<String> linhas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                if (Integer.parseInt(dados[0]) == id) {
                    linha = this.idAssento + ";" + this.tipoAssento + ";";
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

    public Assento consultar(int id) throws IOException {
        try (
                FileReader fr = new FileReader("assento.txt");
                BufferedReader reader = new BufferedReader(fr)
        ) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (id == Integer.parseInt(dados[0])) {
                    return new Assento(Integer.parseInt(dados[0]), this.tipoAssento);
                }
            }
            System.out.println("Ator não encontrado.");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public ArrayList<Assento> listar() throws IOException{
        try (
                FileReader fr = new FileReader("assento.txt");
                BufferedReader reader = new BufferedReader(fr)) {
            String linha;
            while((linha = reader.readLine()) != null){
                String[] dados = linha.split(";");
                Assento assento = new Assento(Integer.parseInt(dados[0]), this.tipoAssento);
                assentos.add(assento);
            }

            System.out.println("Atores listados:");
            for (Assento assentoLista : assentos) {
                System.out.println(assentoLista.getIdAssento());
            }
            System.out.println("-------------------------");

            return this.assentos;
        } catch (IOException e) {
            e.printStackTrace();
            return this.assentos;
        }
    }


}
