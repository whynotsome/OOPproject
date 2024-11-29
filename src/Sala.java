import java.io.*;
import java.util.ArrayList;
import java.util.List;


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

    public int getMaxId() throws IOException {
        return this.listar().size();
    }
    
    public Sala(int idSala, int capacidadeSala, String descricao, String status) {
        this.idSala = idSala;
        this.capacidadeSala = capacidadeSala;
        this.descricao = descricao;
        this.status = status;
        this.salas = new ArrayList<>();
    }

    public boolean cadastrar() throws IOException {
        FileWriter fw = new FileWriter("sala.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(this.idSala + ";" + this.capacidadeSala + ";" + this.descricao + ";" + this.status + ";");
        bw.newLine();
        bw.close();
        return true;
    }

    public boolean editar() throws IOException {
        File arquivo = new File("sala.txt");
        List<String> linhas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                if (Integer.parseInt(dados[0]) == this.idSala) {
                    linha = this.idSala + ";" + this.capacidadeSala + ";" + this.descricao + ";" + this.status + ";";
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

    public Sala consultar() throws IOException {
        try (
                FileReader fr = new FileReader("sala.txt");
                BufferedReader reader = new BufferedReader(fr)
        ) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (this.idSala == Integer.parseInt(dados[0])) {
                    return new Sala(Integer.parseInt(dados[0]), Integer.parseInt(dados[1]), dados[2], dados[3]);
                }
            }
            System.out.println("Sala não encontrado.");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public ArrayList<Sala> listar() throws IOException{
        try (
                FileReader fr = new FileReader("sala.txt");
                BufferedReader reader = new BufferedReader(fr)) {
            String linha;
            while((linha = reader.readLine()) != null){
                String[] dados = linha.split(";");
                Sala sala = new  Sala(Integer.parseInt(dados[0]), Integer.parseInt(dados[1]), dados[2], dados[3]);
                salas.add(sala);
            }

            System.out.println("Salas listadas:");
            for (Sala salasLista : salas) {
                System.out.println(salasLista.idSala);
            }
            System.out.println("-------------------------");

            return this.salas;
        } catch (IOException e) {
            e.printStackTrace();
            return this.salas;
        }
    }
    

    
}
