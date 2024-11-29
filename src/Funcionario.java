import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Funcionario extends Pessoa {
    private int matricula;
    private Date horarioTrabalho;
    
    public ArrayList<Funcionario> funcionarios;
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    public void setHorarioTrabalho(Date horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;
    }
    
    public int getMatricula() {
        return matricula;
    }
    
    public Date getHorarioTrabalho() {
        return horarioTrabalho;
    }

    public int getMaxId() throws IOException {
        return this.listar().size();
    }
    
    public Funcionario(String cpf, String nome, String email,int matricula,Date horarioTrabalho) {
        super(cpf, nome, email);
        this.horarioTrabalho = horarioTrabalho;
        this.matricula = matricula;
        this.funcionarios = new ArrayList<>();
    }

    public boolean cadastrar() throws IOException {
        FileWriter fw = new FileWriter("funcionario.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(this.getCpf() + ";" + this.getNome() + ";" + this.getEmail() + ";" + this.matricula + ";" + this.horarioTrabalho + ";");
        bw.newLine();
        bw.close();
        return true;
    }

    public boolean editar() throws IOException {
        File arquivo = new File("funcionario.txt");
        List<String> linhas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                if (Integer.parseInt(dados[3]) == this.matricula) {
                    linha = this.getCpf() + ";" + this.getNome() + ";" + this.getEmail() + ";" + this.matricula + ";" + this.horarioTrabalho + ";";
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

    public Funcionario consultar() throws IOException {
        try (
                FileReader fr = new FileReader("funcionario.txt");
                BufferedReader reader = new BufferedReader(fr)
        ) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (this.matricula == Integer.parseInt(dados[3])) {
                    return new Funcionario(dados[0], dados[1], dados[2], this.matricula, this.horarioTrabalho);
                }
            }
            System.out.println("Funcionario não encontrado.");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public ArrayList<Funcionario> listar() throws IOException{
        try (
                FileReader fr = new FileReader("funcionario.txt");
                BufferedReader reader = new BufferedReader(fr)) {
            String linha;
            while((linha = reader.readLine()) != null){
                String[] dados = linha.split(";");
                Funcionario funcionario = new Funcionario(dados[0], dados[1], dados[2], this.matricula, this.horarioTrabalho);
                funcionarios.add(funcionario);
            }

            System.out.println("Funcionario listados:");
            for (Funcionario funcionarioLista : funcionarios) {
                System.out.println(funcionarioLista.getNome());
            }
            System.out.println("-------------------------");

            return this.funcionarios;
        } catch (IOException e) {
            e.printStackTrace();
            return this.funcionarios;
        }
    }
    
}
