package traba;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        Usuario cliente = null; // Initialize the 'cliente' variable with null

        int opcao = 0;
        while (opcao != 5) {
            System.out.println("----- MENU -----");
            System.out.println("1. Cadastrar Funcionario");
            System.out.println("2. Cadastrar Livro");
            System.out.println("3. Cadastrar Cliente e Emprestar Livro");
            System.out.println("4. Devolver Livro");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opçao: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do funcionario: ");
                    String nomeFuncionario = scanner.nextLine();
                    System.out.print("Digite o CPF do funcionario: ");
                    String cpfFuncionario = scanner.nextLine();
                    System.out.print("Digite o telefone do funcionario: ");
                    String telefoneFuncionario = scanner.nextLine();
                    Usuario funcionario = new Usuario(nomeFuncionario, cpfFuncionario, telefoneFuncionario);
                    funcionario.cadastrar();
                    break;
                case 2:
                    System.out.print("Digite o título do livro: ");
                    String tituloLivro = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autorLivro = scanner.nextLine();
                    System.out.print("Digite a editora do livro: ");
                    String editoraLivro = scanner.nextLine();
                    System.out.print("Digite a quantidade em estoque do livro: ");
                    int qtdEstoqueLivro = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do teclado
                    Livro livro = new Livro(tituloLivro, autorLivro, editoraLivro, qtdEstoqueLivro);
                    biblioteca.cadastrar(livro);
                    break;
                case 3:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    String cpfCliente = scanner.nextLine();
                    System.out.print("Digite o telefone do cliente: ");
                    String telefoneCliente = scanner.nextLine();
                    cliente = new Usuario(nomeCliente, cpfCliente, telefoneCliente);
                    cliente.cadastrar();

                    System.out.print("Digite o titulo do livro a ser emprestado: ");
                    String tituloLivroEmprestimo = scanner.nextLine();
                    Livro livroEmprestimo = null;
                    for (Livro l : biblioteca.getLivros()) {
                        if (l.getTitulo().equalsIgnoreCase(tituloLivroEmprestimo)) {
                            livroEmprestimo = l;
                            break;
                        }
                    }
                    if (livroEmprestimo != null) {
                        biblioteca.emprestar(livroEmprestimo, cliente);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o titulo do livro a ser devolvido: ");
                    String tituloLivroDevolucao = scanner.nextLine();
                    Livro livroDevolucao = null;
                    for (Livro l : biblioteca.getLivros()) {
                        if (l.getTitulo().equalsIgnoreCase(tituloLivroDevolucao)) {
                            livroDevolucao = l;
                            break;
                        }
                    }
                    if (livroDevolucao != null) {
                        biblioteca.devolver(livroDevolucao, cliente);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção invalida.");
                    break;
            }
        }

        scanner.close();
    }
}