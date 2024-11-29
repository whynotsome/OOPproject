import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class TipoAssento {
    private int idTipoAssento;
    private String descricao;
    private String status;
    public ArrayList<TipoAssento> tipoAssentos;
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void setIdTipoAssento(int idTipoAssento) {
        this.idTipoAssento = idTipoAssento;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public int getIdTipoAssento() {
        return idTipoAssento;
    }
    
    public String getStatus() {
        return status;
    }

    public int getMaxId() throws IOException {
        return this.listar().size();
    }
    
    public TipoAssento(int idTipoAssento, String descricao, String status) {
        this.idTipoAssento = idTipoAssento;
        this.descricao = descricao;
        this.status = status;
        this.tipoAssentos = new ArrayList<>();
    }

    public boolean cadastrar() throws IOException {
        FileWriter fw = new FileWriter("tipoassento.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(this.idTipoAssento + ";" + this.descricao + ";" + this.status + ";");
        bw.newLine();
        bw.close();
        return true;
    }

    public boolean editar() throws IOException {
        File arquivo = new File("tipoassento.txt");
        List<String> linhas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                if (Integer.parseInt(dados[0]) == this.idTipoAssento) {
                    linha = this.idTipoAssento + ";" + this.descricao + ";" + this.status + ";";
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

    public TipoAssento consultar() throws IOException {
        try (
                FileReader fr = new FileReader("sala.txt");
                BufferedReader reader = new BufferedReader(fr)
        ) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (idTipoAssento == Integer.parseInt(dados[0])) {
                    return new TipoAssento(Integer.parseInt(dados[0]), dados[1], dados[2]);
                }
            }
            System.out.println("TipoAssento não encontrado.");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public ArrayList<TipoAssento> listar() throws IOException {
        try (
                FileReader fr = new FileReader("tipoassento.txt");
                BufferedReader reader = new BufferedReader(fr)) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                TipoAssento tipoAssento = new TipoAssento(Integer.parseInt(dados[0]), dados[1], dados[2]);
                tipoAssentos.add(tipoAssento);
            }

            System.out.println("SalaAssentos listadas:");
            for (TipoAssento tipoAssentoLista : tipoAssentos) {
                System.out.println(tipoAssentoLista.idTipoAssento);
            }
            System.out.println("-------------------------");

            return this.tipoAssentos;
        } catch (IOException e) {
            e.printStackTrace();
            return this.tipoAssentos;
        }

    }

}
