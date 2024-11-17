import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Genero {
    private int id;
    private String descricao;
    private String status;
    public ArrayList<Genero> subgenero;

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

    public boolean cadastrar(Genero genero) throws IOException {
        FileWriter fw = new FileWriter("genero.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(this.id + ";" + this.descricao + ";A");
        return true;
    }

    public boolean editar(Genero genero) {
        return true;
    }

    public Genero consultar(Genero genero) {
        return genero;
    }

    public ArrayList<Genero> listar(Genero genero) {
        return subgenero;
    }
    
    
}
