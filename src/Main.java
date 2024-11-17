import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
//        Scanner scan = new Scanner(System.in);
//        File arquivo = new File("arquivoTeste.txt");
//
//        try {
//            if(!arquivo.exists()){
//                System.out.println("arquivo criado com sucesso");
//                arquivo.createNewFile();
//
//            }
//        } catch (Exception e) {
//            System.out.println("Nao foi possivel criar o arquivo");
//        }
//
//        scan.close();

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
                                System.out.println("Cadastrado com sucesso!");
                                break;

                            case 2:
                                System.out.println("Cadastrado com sucesso!");
                                break;

                            case 3:
                                Genero comedia = new Genero(1, "comedia","ativo");
                                System.out.print("Digite o id do filme: ");
                                int filmeId = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Digite o título do filme: ");
                                String filmeTitulo = scanner.nextLine();
                                System.out.print("Digite a classificação do filme (ex: 1-18): ");
                                int filmeClassificacao = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Digite o status do filme (ativo/inativo): ");
                                String filmeStatus = scanner.nextLine();
                                Filme filme = new Filme(filmeId, filmeTitulo, filmeClassificacao, comedia, filmeStatus);
                                filme.cadastrar(filme);
                                System.out.println("Cadastrado com sucesso!");
                                break;
                            case 4:

                                System.out.println("Cadastrado com sucesso!");
                                break;
                            case 5:
                                System.out.println("Cadastrado com sucesso!");
                                break;
                            case 6:

                                System.out.println("Cadastrado com sucesso!");
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
                            case 3:
                                Genero genero = new Genero(1, "comedia","ativo");
                                genero.subgenero.add(genero);
                                System.out.print("Digite o id do filme: ");
                                int filmeId = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Digite o título do filme: ");
                                String filmeTitulo = scanner.nextLine();
                                System.out.print("Digite a classificação do filme (ex: 1-18): ");
                                int filmeClassificacao = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Digite o status do filme (ativo/inativo): ");
                                String filmeStatus = scanner.nextLine();
                                Filme filme = new Filme(filmeId, filmeTitulo, filmeClassificacao, genero, filmeStatus);
                                filme.editar(filme, filmeId);
                            case 5:
                            case 6:
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
                            case 4:
                            case 5:
                            case 6:
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
                            case 3:
                            case 4:
                            case 5:
                            case 6:
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
