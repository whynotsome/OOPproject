import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Filme {
    private int idFilme;
    private String titulo;
    private int classificacao;
    private Genero genero;
    private String status;
    public ArrayList<Filme> filmes;

    public Filme(){}

    public Filme(int idFilme, String titulo, int classificacao, Genero genero, String status) {
        this.idFilme = idFilme;
        this.titulo = titulo;
        this.classificacao = classificacao;
        this.genero = genero;
        this.status = status;
        this.filmes = new ArrayList<>();
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public Genero getGenero() {
        return genero;
    }

    public int getIdFilme() {
        return idFilme;
    }

    public String getStatus() {
        return status;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getMaxId() throws IOException {
        return this.listar().size();
    }

    public boolean cadastrar() throws IOException {
        try (
                FileWriter fw = new FileWriter("filme.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                ) {
            if(consultar() == null) {
                int id = this.getMaxId()+1;
                bw.write(id + ";" + this.titulo + ";" + this.classificacao + ";" + this.genero.getDescricao() + ";" + this.status + ";");
                bw.newLine();
                filmes.add(this);
                bw.close();
                System.out.println("Dados de Filme Cadastrados!");
                return true;
            } else {
                System.out.println("Filme já cadastrado");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

    }

    public boolean editar() throws IOException {
        File arquivo = new File("filme.txt");
        List<String> linhas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                if (Integer.parseInt(dados[0]) == this.idFilme) {
                    linha = this.idFilme + ";" + this.titulo + ";" + this.classificacao + ";" + this.genero.getDescricao() + ";" + this.status;
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

    public Filme consultar() throws IOException {
        try (
                FileReader fr = new FileReader("filme.txt");
                BufferedReader reader = new BufferedReader(fr)
        ) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (this.idFilme == Integer.parseInt(dados[0])) {
                    return new Filme(Integer.parseInt(dados[0]), dados[1], Integer.parseInt(dados[2]), genero, dados[4]);
                }
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public ArrayList<Filme> listar() {
        try (
                FileReader fr = new FileReader("filme.txt");
                BufferedReader reader = new BufferedReader(fr)) {
                String linha;
            while((linha = reader.readLine()) != null){
               String[] dados = linha.split(";");
                   Filme filme = new Filme(Integer.parseInt(dados[0]), dados[1], Integer.parseInt(dados[2]), genero, dados[4]);
                   filmes.add(filme);
            }

            System.out.println("Filmes listados:");
            for (Filme filme : filmes) {
                System.out.println(filme.getTitulo());
            }
            System.out.println("-------------------------");

            return this.filmes;
        } catch (IOException e) {
            e.printStackTrace();
            return this.filmes;
        }
    }
}