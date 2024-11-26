import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Ingresso {
    private int idIngresso;
    private double valorPago;
    private SalaAssento salaAssento;
    private Sessao sessao;
    public ArrayList<Ingresso> ingressos;
    
    public void setIdIngresso(int idIngresso) {
        this.idIngresso = idIngresso;
    }
    
    public void setSalaAssento(SalaAssento salaAssento) {
        this.salaAssento = salaAssento;
    }
    
    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
    
    public int getIdIngresso() {
        return idIngresso;
    }
    
    public SalaAssento getSalaAssento() {
        return salaAssento;
    }
    
    public Sessao getSessao() {
        return sessao;
    }
    
    public double getValorPago() {
        return valorPago;
    }

    public Ingresso() {
        this.ingressos = new ArrayList<>();
    }
    
    public Ingresso(int idIngresso, double valorPago, SalaAssento salaAssento, Sessao sessao) {
        this.idIngresso = idIngresso;
        this.valorPago = valorPago;
        this.salaAssento = salaAssento;
        this.sessao = sessao;
        this.ingressos = new ArrayList<>();
    }

    public boolean cadastrar() throws IOException {
        FileWriter fw = new FileWriter("ingresso.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(this.idIngresso + ";" + this.valorPago + ";" + this.salaAssento + ";" + this.sessao + ";");
        bw.newLine();
        bw.close();
        return true;
    }

    public boolean editar(int id) throws IOException {
        File arquivo = new File("ingresso.txt");
        List<String> linhas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                if (Integer.parseInt(dados[0]) == id) {
                    linha = this.idIngresso + ";" + this.valorPago + ";" + this.salaAssento + ";" + this.sessao + ";";
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

    public Ingresso consultar(int id) throws IOException {
        try (
                FileReader fr = new FileReader("ingresso.txt");
                BufferedReader reader = new BufferedReader(fr)
        ) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (id == Integer.parseInt(dados[0])) {
                    return new Ingresso(Integer.parseInt(dados[0]), Double.parseDouble(dados[1]), this.salaAssento, this.sessao);
                }
            }
            System.out.println("Ingresso não encontrado.");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public ArrayList<Ingresso> listar() throws IOException{
        try (
                FileReader fr = new FileReader("ingresso.txt");
                BufferedReader reader = new BufferedReader(fr)) {
            String linha;
            while((linha = reader.readLine()) != null){
                String[] dados = linha.split(";");
                Ingresso ingresso = new Ingresso(Integer.parseInt(dados[0]), Double.parseDouble(dados[1]), this.salaAssento, this.sessao);
                ingressos.add(ingresso);
            }

            System.out.println("Ingresso listados:");
            for (Ingresso ingressoLista : ingressos) {
                System.out.println(ingressoLista.idIngresso);
            }
            System.out.println("-------------------------");

            return this.ingressos;
        } catch (IOException e) {
            e.printStackTrace();
            return this.ingressos;
        }
    }

}
