import java.util.ArrayList;



public class Sala {
    private int idSala ;
    private int capacidadeSala ;
    private String descricao;
    private String status;
    public ArrayList<Sala> salas;
    
    public void setCapacidadeSala(int capacidadeSala) {
        this.capacidadeSala = capacidadeSala;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public int getCapacidadeSala() {
        return capacidadeSala;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public int getIdSala() {
        return idSala;
    }
    
    public String getStatus() {
        return status;
    }
    
    public Sala(int idSala, int capacidadeSala, String descricao, String status) {
        this.idSala = idSala;
        this.capacidadeSala = capacidadeSala;
        this.descricao = descricao;
        this.status = status;
        this.salas = new ArrayList<>();
    }
    

    
}
