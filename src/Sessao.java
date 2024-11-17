import java.util.ArrayList;



public class Sessao {
    private int idSessao;
    private int dataHoraessao;
    private Filme filme;
    private Sala sala;
    private Funcionario funcionario;
    private String status;
    public ArrayList<Sessao> sessoes;
    
    public void setDataHoraessao(int dataHoraessao) {
        this.dataHoraessao = dataHoraessao;
    }
    
    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }
    
    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public int getIdSessao() {
        return idSessao;
    }
    
    public int getDataHoraessao() {
        return dataHoraessao;
    }
    
    public Filme getFilme() {
        return filme;
    }
    
    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    public Sala getSala() {
        return sala;
    }
    
    public String getStatus() {
        return status;
    }
    
    public Sessao(int idSessao, int dataHoraessao, Filme filme, Sala sala, Funcionario funcionario, String status) {
        this.idSessao = idSessao;
        this.dataHoraessao = dataHoraessao;
        this.filme = filme;
        this.sala = sala;
        this.funcionario = funcionario;
        this.status = status;
        this.sessoes = new ArrayList<>();
    }

    
}
