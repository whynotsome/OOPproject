import java.io.*;
import java.util.ArrayList;
import java.util.List;


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

    public int getMaxId() throws IOException {
        return this.listar().size();
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

    public boolean cadastrar() throws IOException {
        FileWriter fw = new FileWriter("sessao.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(this.idSessao + ";" + this.dataHoraessao + ";" + this.filme + ";" + this.sala + ";" + this.funcionario + ";" + this.status + ";");
        bw.newLine();
        bw.close();
        return true;
    }

    public boolean editar() throws IOException {
        File arquivo = new File("sessao.txt");
        List<String> linhas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                if (Integer.parseInt(dados[0]) == this.idSessao) {
                    linha = this.idSessao + ";" + this.dataHoraessao + ";" + this.filme + ";" + this.sala + ";" + this.funcionario + ";" + this.status + ";";
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

    public Sessao consultar() throws IOException {
        try (
                FileReader fr = new FileReader("sala.txt");
                BufferedReader reader = new BufferedReader(fr)
        ) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (this.idSessao == Integer.parseInt(dados[0])) {
                    return new Sessao(Integer.parseInt(dados[0]), Integer.parseInt(dados[1]), this.filme, this.sala, this.funcionario, this.status);
                }
            }
            System.out.println("Sessao não encontrada.");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public ArrayList<Sessao> listar() throws IOException {
        try (
                FileReader fr = new FileReader("sessao.txt");
                BufferedReader reader = new BufferedReader(fr)) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                Sessao salaAssento = new Sessao(Integer.parseInt(dados[0]), Integer.parseInt(dados[1]), this.filme, this.sala, this.funcionario, this.status);
                sessoes.add(salaAssento);
            }

            System.out.println("SalaAssentos listadas:");
            for (Sessao sessoesLista : sessoes) {
                System.out.println(sessoesLista.idSessao);
            }
            System.out.println("-------------------------");

            return this.sessoes;
        } catch (IOException e) {
            e.printStackTrace();
            return this.sessoes;
        }

    }

}
