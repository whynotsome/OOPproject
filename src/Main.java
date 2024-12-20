import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        boolean isMenuRodando = true;

        while (isMenuRodando) {
            System.out.println("-------------------------");
            System.out.println("Cadastrar - 1");
            System.out.println("Editar    - 2");
            System.out.println("Consultar - 3");
            System.out.println("Listar    - 4");
            System.out.println("Sair      - 0");
            System.out.println("-------------------------");
            System.out.println("Escolha uma Opcao: ");

            int opcaoEscolhida = scanner.nextInt();

            switch (opcaoEscolhida) {
                case 1:
                    boolean isCadastrarRodando = true;
                    while (isCadastrarRodando) {
                        System.out.println("Assento:     - 1 ");
                        System.out.println("Ator:        - 2 ");
                        System.out.println("Filme:       - 3 ");
                        System.out.println("FilmeAtor:   - 4");
                        System.out.println("Funcionario: - 5 ");
                        System.out.println("Genero:      - 6 ");
                        System.out.println("Ingresso:    - 7 ");
                        System.out.println("Sala:        - 9 ");
                        System.out.println("SalaAssento: - 10 ");
                        System.out.println("Sessao:      - 11 ");
                        System.out.println("TipoAssento: - 12 ");
                        System.out.println("Voltar: -    - 13 ");
                        System.out.println("Sair         - 0");
                        System.out.println("O que vai cadastrar?");
                        int subOpcao = scanner.nextInt();
                        switch (subOpcao) {
                            case 1:
                                System.out.println("Digite o id do assento: ");
                                int assentoId = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Digite o id do sala: ");
                                int salaId = scanner.nextInt();
                                scanner.nextLine();

                                System.out.println("Cadastrado com sucesso!");
                                break;

                            case 2:
                                scanner.nextLine();
                                System.out.println("Digite o cpf do ator: ");
                                String atorCpf = scanner.nextLine();
                                System.out.println("Digite o nome do ator: ");
                                String atorNome = scanner.nextLine();
                                System.out.println("Digite o email do ator: ");
                                String atorEmail = scanner.nextLine();
                                System.out.println("Digite o registro do ator: ");
                                int atorRegistro = scanner.nextInt();
                                scanner.nextLine();
                                Ator ator = new Ator(atorCpf, atorNome, atorEmail, atorRegistro);
                                ator.cadastrar();
                                System.out.println("Cadastrado com sucesso!");
                                break;
                                case 3:
                                    scanner.nextLine();
                                    System.out.print("Digite o título do filme: ");
                                    String filmeTitulo = scanner.nextLine();
                                    System.out.print("Digite a classificação do filme (ex: 1-18): ");
                                    int filmeClassificacao = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.print("Digite o genero do filme: ");
                                    String generoFilme = scanner.nextLine();
                                    System.out.print("Digite o status do filme (ativo/inativo): ");
                                    String filmeStatus = scanner.nextLine();
                                    Genero genero = new Genero(0, generoFilme,"A");
                                    if (genero.consultar() == null) {
                                        genero.cadastrar();


                                        Filme filme = new Filme(0, filmeTitulo, filmeClassificacao, genero, filmeStatus);
                                        filme.cadastrar();
                                    } else {
                                        System.out.println("Genero ja cadastrado");
                                    }

                                    break;
                            case 4:

                                System.out.println("Cadastrado com sucesso!");
                                break;
                            case 5:
                                System.out.println("Cadastrado com sucesso!");
                                break;
                            case 6:
                                System.out.println("Digite a descricao do genero:");
                                String generoDescricao = scanner.nextLine();
                                System.out.println("Digite o status do genero: ");
                                String generoStatus = scanner.nextLine();
                                Genero generoGenero = new Genero(0 , generoDescricao, generoStatus);
                                if (generoGenero.cadastrar()) System.out.println("Cadastrado com sucesso!");
                                System.out.println("Erro ao cadastrar");
                                break;
                            case 7:

                                System.out.println("Cadastrado com sucesso!");
                                break;
                            case 8:
                                System.out.println("Cadastrado com sucesso!");
                                break;
                            case 9:
                                System.out.println("Cadastrado com sucesso!");
                                break;
                            case 10:
                                System.out.println("Cadastrado com sucesso!");
                                break;
                            case 11:
                                System.out.println("Cadastrado com sucesso!");
                                break;
                            case 12:
                                System.out.println("Cadastrado com sucesso!");
                                break;
                            case 13:
                                System.out.println("Voltando ao Menu Principal");
                                isCadastrarRodando = false;
                                break;
                            case 0:
                                System.out.println("Parando o programa");
                                isCadastrarRodando = false;
                                isMenuRodando = false;
                                break;
                            default:
                                System.out.println("Opcao Invalida no submenu.");
                        }
                    }
                    break;

                case 2:
                    boolean isEditarRodando = true;
                    while (isEditarRodando) {
                        System.out.println("Assento:     - 1 ");
                        System.out.println("Ator:        - 2 ");
                        System.out.println("Filme:       - 3 ");
                        System.out.println("FilmeAtor:   - 4");
                        System.out.println("Funcionario: - 5 ");
                        System.out.println("Genero:      - 6 ");
                        System.out.println("Ingresso:    - 7 ");
                        System.out.println("Sala:        - 9 ");
                        System.out.println("SalaAssento: - 10 ");
                        System.out.println("Sessao:      - 11 ");
                        System.out.println("TipoAssento: - 12 ");
                        System.out.println("Voltar: -    - 13 ");
                        System.out.println("Sair         - 0");
                        System.out.println("O que vai editar?: ");
                        int subOpcao = scanner.nextInt();
                        switch (subOpcao) {
                            case 1:
                            case 2:
                                System.out.println("Digite o registro do ator que voce quer alterar: ");
                                int atorId = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Digite o novo cpf do ator: ");
                                String atorCpf = scanner.nextLine();
                                System.out.println("Digite o novo nome do ator: ");
                                String atorNome = scanner.nextLine();
                                System.out.println("Digite o novo email do ator: ");
                                String atorEmail = scanner.nextLine();
                                Ator ator = new Ator(atorCpf, atorNome, atorEmail, atorId);
                                ator.editar();
                                System.out.println("Editado com sucesso!");
                                break;
                            case 3:
                                System.out.print("Digite o id do filme que voce quer alterar: ");
                                int filmeId = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Digite o título do filme: ");
                                String filmeTitulo = scanner.nextLine();
                                System.out.print("Digite a classificação do filme (ex: 1-18): ");
                                int filmeClassificacao = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Digite o status do filme (ativo/inativo): ");
                                String filmeStatus = scanner.nextLine();
                                System.out.print("Digite o id do genero do filme: ");
                                int generoFilme = scanner.nextInt();
                                scanner.nextLine();
                                Genero genero = new Genero();
                                Filme filme = new Filme(filmeId, filmeTitulo, filmeClassificacao, genero.consultar(), filmeStatus);
                                filme.editar();
                                System.out.println("Editado com sucesso!");
                                System.out.println("Crie um novo Genero.");
                                System.out.println("Digite o id do genero: ");
                                int generoFilmeId = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Digite a descricao do genero:");
                                String generoFilmeDescricao = scanner.nextLine();
                                System.out.println("Digite o status do genero: ");
                                String generoFilmeStatus = scanner.nextLine();
                                Genero novoGenero = new Genero(generoFilmeId, generoFilmeDescricao, generoFilmeStatus);
                                novoGenero.cadastrar();
                                System.out.println("Cadastrado com sucesso!");
                                break;
                            case 5:
                            case 6:
                                System.out.println("Digite o id do genero que voce quer alterar: ");
                                int generoIdVelho = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Digite o novo id do genero: ");
                                int generoIdNovo = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Digite a descricao do genero: ");
                                String generoDescricao = scanner.nextLine();
                                System.out.print("Digite o status do genero: ");
                                String generoStatus = scanner.nextLine();
                                Genero generoEditado = new Genero(generoIdNovo, generoDescricao, generoStatus);
                                generoEditado.editar();
                                System.out.println("Editado com sucesso!");
                                break;
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                                System.out.println("Voltando ao Menu Principal");
                                isEditarRodando = false;
                                break;
                            case 0:
                                System.out.println("Parando o programa");
                                isMenuRodando = false;
                                isEditarRodando = false;
                                break;
                            default:
                                System.out.println("Opcao Invalida no submenu.");
                        }
                    }
                    break;

                case 3:
                    boolean isConsultarRodando = true;

                    while (isConsultarRodando) {
                        System.out.println("Assento:     - 1 ");
                        System.out.println("Ator:        - 2 ");
                        System.out.println("Filme:       - 3 ");
                        System.out.println("FilmeAtor:   - 4");
                        System.out.println("Funcionario: - 5 ");
                        System.out.println("Genero:      - 6 ");
                        System.out.println("Ingresso:    - 7 ");
                        System.out.println("Sala:        - 9 ");
                        System.out.println("SalaAssento: - 10 ");
                        System.out.println("Sessao:      - 11 ");
                        System.out.println("TipoAssento: - 12 ");
                        System.out.println("Voltar: -    - 13 ");
                        System.out.println("Sair         - 0");
                        System.out.println("O que vai consultar?: ");
                        int subOpcao = scanner.nextInt();
                        switch (subOpcao) {
                            case 1:
                            case 2:
                            case 3:
                                System.out.println("Qual filme você quer consultar? Insira o ID:");
                                int filmeParaBuscar = scanner.nextInt();
                                scanner.nextLine();
                                Filme filme = new Filme();
                                    Filme resultado = filme.consultar();
                                    if (resultado != null) {
                                        System.out.println("Filme consultado:");
                                        System.out.println("Título: " + resultado.getTitulo());
                                        System.out.println("-------------------------");
                                    } else {
                                        System.out.println("Nenhum filme encontrado com o ID informado.");
                                    }
                                break;
                            case 4:
                            case 5:
                            case 6:
                                System.out.println("Qual genero você quer consultar? Insira o ID:");
                                int generoParaBuscar = scanner.nextInt();
                                scanner.nextLine();
                                Genero genero = new Genero();
                                Genero resultadoGenero = genero.consultar();
                                if (resultadoGenero != null) {
                                    System.out.println("Genero consultado:");
                                    System.out.println("Descricao: " + resultadoGenero.getDescricao());
                                    System.out.println("-------------------------");
                                } else {
                                    System.out.println("Nenhum filme encontrado com o ID informado.");
                                }
                                break;
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                                System.out.println("Voltando ao Menu Principal");
                                isConsultarRodando = false;
                                break;
                            case 0:
                                System.out.println("Parando o programa");
                                isMenuRodando = false;
                                isConsultarRodando = false;
                                break;
                            default:
                                System.out.println("Opcao Invalida no submenu.");
                        }
                    }
                    break;

                case 4:
                    boolean isListarRodando = true;

                    while (isListarRodando) {
                        System.out.println("Assento:     - 1 ");
                        System.out.println("Ator:        - 2 ");
                        System.out.println("Filme:       - 3 ");
                        System.out.println("FilmeAtor:   - 4");
                        System.out.println("Funcionario: - 5 ");
                        System.out.println("Genero:      - 6 ");
                        System.out.println("Ingresso:    - 7 ");
                        System.out.println("Sala:        - 9 ");
                        System.out.println("SalaAssento: - 10 ");
                        System.out.println("Sessao:      - 11 ");
                        System.out.println("TipoAssento: - 12 ");
                        System.out.println("Voltar: -    - 13 ");
                        System.out.println("Sair         - 0");
                        System.out.println("O que vai listar?: ");
                        int subOpcao = scanner.nextInt();
                        switch (subOpcao) {
                            case 1:
                            case 2:
                                // Ator ator = new Ator();
//                              // ator.listar();
                                break;
                            case 3:
                                Filme filme = new Filme();
                                filme.listar();
                                break;
                            case 4:
                            case 5:
                            case 6:
                                Genero genero = new Genero();
                                genero.listar();
                                break;
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                                System.out.println("Voltando ao Menu Principal");
                                isListarRodando = false;
                                break;
                            case 0:
                                System.out.println("Parando o programa");
                                isMenuRodando = false;
                                isListarRodando = false;
                                break;
                            default:
                                System.out.println("Opcao Invalida no submenu.");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Parando o programa");
                    isMenuRodando = false;
                    break;
                default:
                    System.out.println("Opcao invalida colega, tenta de novo");
            }
        }
        scanner.close();
    }
}

