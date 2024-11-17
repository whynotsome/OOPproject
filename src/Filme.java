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

    public Filme() {}

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

    public boolean cadastrar(Filme filme) throws IOException {
        FileWriter fw = new FileWriter("filme.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(filme.idFilme + ";" + filme.titulo + ";" + filme.classificacao + ";" + filme.genero.getId() + ";" + filme.status + ";");
        bw.newLine();
        bw.close();
        return true;
    }

    public boolean editar(Filme filme, int id) throws IOException {
        File arquivo = new File("filme.txt");
        List<String> linhas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                if(Integer.parseInt(dados[0]) == id) {
                    linha = filme.idFilme + ";" + filme.titulo + ";" + filme.classificacao + ";" + filme.genero + ";" + filme.status;
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

    public Filme consultar(Filme filme) {
        return filme;
    }

    public ArrayList<Filme> listar(Filme filme) {
        return filmes;
    }

}