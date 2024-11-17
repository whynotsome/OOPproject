import java.util.ArrayList;

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

    public FilmeAtor(int idFilmeAtor, Ator ator, Filme filme, String personagem, boolean principal) {
        this.idFilmeAtor = idFilmeAtor;
        this.ator = ator;
        this.filme = filme;
        this.personagem = personagem;
        this.principal = principal;
        this.filmeAtores = new ArrayList<>();
    }

    
}
