import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ator extends Pessoa{
    private int registro;
    public ArrayList<Ator> atores;
    
    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public int getRegistro() {
        return registro;
    }

    public Ator() {
        this.atores = new ArrayList<>();
    }

    public Ator(String cpf, String nome, String email, int registro) {
        super(cpf, nome, email);
        this.registro = registro;
        this.atores = new ArrayList<>();
    }

    public boolean cadastrar() throws IOException {
        FileWriter fw = new FileWriter("ator.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(this.getCpf() + ";" + this.getNome() + ";" + this.getEmail() + ";" + this.getRegistro() + ";");
        bw.newLine();
        atores.add(this);
        bw.close();
        return true;
    }

    public boolean editar(int id) throws IOException {
        File arquivo = new File("ator.txt");
        List<String> linhas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                if (Integer.parseInt(dados[3]) == id) {
                    linha = this.getCpf() + ";" + this.getNome() + ";" + this.getEmail() + ";" + this.getRegistro() + ";";
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

    public Ator consultar(int id) throws IOException{
        try (
                FileReader fr = new FileReader("ator.txt");
                BufferedReader reader = new BufferedReader(fr)
        ) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (id == Integer.parseInt(dados[0])) {
                    return new Ator(dados[0], dados[1], dados[2], Integer.parseInt(dados[3]));
                }
            }
            System.out.println("Ator não encontrado.");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public ArrayList<Ator > listar() {
        try (
                FileReader fr = new FileReader("ator.txt");
                BufferedReader reader = new BufferedReader(fr)) {
            String linha;
            while((linha = reader.readLine()) != null){
                String[] dados = linha.split(";");
                Ator filme = new Ator(dados[0], dados[1], dados[2], Integer.parseInt(dados[3]));
                atores.add(filme);
            }

            System.out.println("Atores listados:");
            for (Ator atorLista : atores) {
                System.out.println(atorLista.getNome());
            }
            System.out.println("-------------------------");

            return this.atores;
        } catch (IOException e) {
            e.printStackTrace();
            return this.atores;
        }
    }

    

}
