import java.util.ArrayList;



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
    
    public TipoAssento(int idTipoAssento, String descricao, String status) {
        this.idTipoAssento = idTipoAssento;
        this.descricao = descricao;
        this.status = status;
        this.tipoAssentos = new ArrayList<>();
    }
    
    
}
