import java.util.ArrayList;



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
    
    public SalaAssento(int idSalaAssento, Assento assento, Sala sala) {
        this.idSalaAssento = idSalaAssento;
        this.assento = assento;
        this.sala = sala;
        this.salaAssentos = new ArrayList<>();
    }
    
    
}
