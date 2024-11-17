import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ator extends Pessoa{
    private int registro;
    public ArrayList<Ator> atores;
    
    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public int getRegistro() {
        return registro;
    }

    public Ator(String cpf, String nome, String email, int registro) {
        super(cpf, nome, email);
        this.registro = registro;
        this.atores = new ArrayList<>();

    }

    public boolean cadastrar(Ator  ator) throws IOException {
        FileWriter fw = new FileWriter("ator.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(ator.registro  + ";" + ator.atores);
        bw.newLine();
        bw.close();
        return true;
    }

    public boolean editar(Ator  ator) {
        return true;
    }

    public Ator  consultar(Ator  ator) {
        return ator;
    }

    public ArrayList<Ator > listar(Ator  ator) {
        return atores;
    }

    

}
