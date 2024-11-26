import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Genero {
    private int id;
    private String descricao;
    private String status;
    public ArrayList<Genero> subgenero;

    public Genero() {
        this.subgenero = new ArrayList<>();

    }

    public Genero(int id, String descricao, String status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
        this.subgenero = new ArrayList<>();
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public boolean cadastrar() throws IOException {
        FileWriter fw = new FileWriter("genero.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(this.id + ";" + this.descricao + ";" + this.status);
        bw.newLine();
        bw.close();
        return true;
    }

    public boolean editar(int id) throws IOException {
        File arquivo = new File("genero.txt");
        List<String> linhas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                if (Integer.parseInt(dados[0]) == id) {
                    linha = this.id + ";" + this.descricao + ";" + this.status + ";";
                    encontrado = true;
                }
                linhas.add(linha);
            }
        }
        if(encontrado) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
                for (String linha : linhas)  {
                    bw.write(linha);
                    bw.newLine();
                }
            }
        }
        return encontrado;
    }
        public Genero consultar (int id) throws IOException {
            try (
                    FileReader fr = new FileReader("genero.txt");
                    BufferedReader reader = new BufferedReader(fr)
            ) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    String[] dados = linha.split(";");
                    if (id == Integer.parseInt(dados[0])) {
                        return new Genero(Integer.parseInt(dados[0]), dados[1], dados[2]);
                    }
                }
                System.out.println("Filme não encontrado.");
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }
        }

        public ArrayList<Genero> listar(){
            try (
                    FileReader fr = new FileReader("genero.txt");
                    BufferedReader reader = new BufferedReader(fr)) {
                String linha;
                while((linha = reader.readLine()) != null){
                    String[] dados = linha.split(";");
                    Genero genero = new Genero(Integer.parseInt(dados[0]), dados[1], dados[2]);
                    subgenero.add(genero);
                }

                System.out.println("Generos listados:");
                for (Genero genero : subgenero) {
                    System.out.println(genero.getDescricao());
                }
                System.out.println("-------------------------");

                return this.subgenero;
            } catch (IOException e) {
                e.printStackTrace();
                return this.subgenero;
            }
        }


}
