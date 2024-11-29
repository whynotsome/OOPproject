import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilmeAtor {
    private int idFilmeAtor;
    private Ator ator;
    private Filme filme;
    private String personagem;
    private boolean principal;
    public ArrayList<FilmeAtor> filmeAtores;
    
    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public void setIdFilmeAtor(int idFilmeAtor) {
        this.idFilmeAtor = idFilmeAtor;
    }

    public void setPersonagem(String personagem) {
        this.personagem = personagem;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    public Ator getAtor() {
        return ator;
    }

    public Filme getFilme() {
        return filme;
    }

    public int getIdFilmeAtor() {
        return idFilmeAtor;
    }

    public String getPersonagem() {
        return personagem;
    }

    public boolean getPrincipal(){
        return principal;
    }

    public int getMaxId() throws IOException {
        return this.listar().size();
    }

    public FilmeAtor(int idFilmeAtor, Ator ator, Filme filme, String personagem, boolean principal) {
        this.idFilmeAtor = idFilmeAtor;
        this.ator = ator;
        this.filme = filme;
        this.personagem = personagem;
        this.principal = principal;
        this.filmeAtores = new ArrayList<>();
    }

    public boolean cadastrar() throws IOException {
        FileWriter fw = new FileWriter("filmeator.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(this.idFilmeAtor + ";" + this.ator + ";" + this.filme + ";" + this.personagem + ";" + this.principal + ";");
        bw.newLine();
        bw.close();
        return true;
    }

    public boolean editar() throws IOException {
        File arquivo = new File("filmeator.txt");
        List<String> linhas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                if (Integer.parseInt(dados[0]) == this.idFilmeAtor) {
                    linha = this.idFilmeAtor + ";" + this.ator + ";" + this.filme + ";" + this.personagem + ";" + this.principal + ";";
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

    public FilmeAtor consultar() throws IOException {
        try (
                FileReader fr = new FileReader("filmeator.txt");
                BufferedReader reader = new BufferedReader(fr)
        ) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (this.idFilmeAtor == Integer.parseInt(dados[0])) {
                    return new FilmeAtor(Integer.parseInt(dados[0]), this.ator, this.filme, dados[3], this.principal);
                }
            }
            System.out.println("FilmeAtor não encontrado.");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public ArrayList<FilmeAtor> listar() throws IOException{
        try (
                FileReader fr = new FileReader("filmeator.txt");
                BufferedReader reader = new BufferedReader(fr)) {
            String linha;
            while((linha = reader.readLine()) != null){
                String[] dados = linha.split(";");
                FilmeAtor assento = new FilmeAtor(Integer.parseInt(dados[0]), this.ator, this.filme, dados[3], this.principal);
                filmeAtores.add(assento);
            }

            System.out.println("Atores listados:");
            for (FilmeAtor filmeAtorLista : filmeAtores) {
                System.out.println(filmeAtorLista.getAtor().getNome());
            }
            System.out.println("-------------------------");

            return this.filmeAtores;
        } catch (IOException e) {
            e.printStackTrace();
            return this.filmeAtores;
        }
    }

}

