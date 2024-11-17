import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class Assento {
    private int idAssento;
    private TipoAssento tipoAssento;
    public ArrayList<Assento> assentos;
    
    public void setIdAssento(int idAssento) {
        this.idAssento = idAssento;
    }
    
    public void setTipoAssento(TipoAssento tipoAssento) {
        this.tipoAssento = tipoAssento;
    }
    
    public int getIdAssento() {
        return idAssento;
    }

    public TipoAssento getTipoAssento() {
        return tipoAssento;
    }
    
    public Assento(int idAssento, TipoAssento tipoAssento) {
        this.idAssento = idAssento;
        this.tipoAssento = tipoAssento;
        this.assentos = new ArrayList<>();
    }

    public boolean cadastrar(Assento assento) throws IOException {
        FileWriter fw = new FileWriter("assento.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(assento.idAssento + ";" + assento.tipoAssento + ";" + assento.assentos);
        bw.newLine();
        bw.close();
        return true;
    }

    public boolean editar(Assento assento) {
        return true;
    }

    public Assento consultar(Assento assento) {
        return assento;
    }

    public ArrayList<Assento> listar(Assento assento) {
        return assentos;
    }
    
    
}
