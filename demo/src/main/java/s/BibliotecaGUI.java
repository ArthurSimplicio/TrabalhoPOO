package s;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class BibliotecaGUI {
    private static List<Biblioteca> livros = new ArrayList<>();
    private static List<Usuario> clientes = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            String input = JOptionPane.showInputDialog(null,
                    "===== MENU =====\n" +
                            "1. Cadastrar funcionário\n" +
                            "2. Cadastrar livro\n" +
                            "3. Cadastrar cliente\n" +
                            "4. Emprestar livro a cliente\n" +
                            "5. Devolver livro\n" +
                            "0. Sair\n" +
                            "Escolha uma opção:");

            opcao = Integer.parseInt(input);

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    cadastrarLivro();
                    break;
                case 3:
                    cadastrarCliente();
                    break;
                case 4:
                    emprestarLivro();
                    break;
                case 5:
                    devolverLivro();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo do programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    break;
            }
        } while (opcao != 0);
    }

    private static void cadastrarFuncionario() {
        String nomeFuncionario = JOptionPane.showInputDialog(null, "Digite o nome do funcionário:");
        String cpfFuncionario = JOptionPane.showInputDialog(null, "Digite o CPF do funcionário:");
        String telefoneFuncionario = JOptionPane.showInputDialog(null, "Digite o telefone do funcionário:");
        Usuario funcionario = new Usuario(nomeFuncionario, cpfFuncionario, telefoneFuncionario, true);
        funcionario.cadastrar();
    }

    private static void cadastrarLivro() {
        String tituloLivro = JOptionPane.showInputDialog(null, "Digite o título do livro:");
        String autorLivro = JOptionPane.showInputDialog(null, "Digite o autor do livro:");
        String editoraLivro = JOptionPane.showInputDialog(null, "Digite a editora do livro:");
        String qtdEstoqueInput = JOptionPane.showInputDialog(null, "Digite a quantidade em estoque do livro:");
        int qtdEstoqueLivro = Integer.parseInt(qtdEstoqueInput);
        Biblioteca livro = new Biblioteca(tituloLivro, autorLivro, editoraLivro, qtdEstoqueLivro);
        livro.cadastrar();
        livros.add(livro);
    }

    private static void cadastrarCliente() {
        String nomeCliente = JOptionPane.showInputDialog(null, "Digite o nome do cliente:");
        String cpfCliente = JOptionPane.showInputDialog(null, "Digite o CPF do cliente:");
        String telefoneCliente = JOptionPane.showInputDialog(null, "Digite o telefone do cliente:");
        Usuario cliente = new Usuario(nomeCliente, cpfCliente, telefoneCliente, false);
        cliente.cadastrar();
        clientes.add(cliente);
    }

    private static void emprestarLivro() {
        String tituloEmprestar = JOptionPane.showInputDialog(null, "Digite o título do livro a ser emprestado:");
        String nomeClienteEmprestar = JOptionPane.showInputDialog(null, "Digite o nome do cliente:");

        Biblioteca livroEmprestar = encontrarLivroPorTitulo(tituloEmprestar);
        Usuario clienteEmprestar = encontrarClientePorNome(nomeClienteEmprestar);

        if (livroEmprestar != null && clienteEmprestar != null) {
            livroEmprestar.emprestar();
            JOptionPane.showMessageDialog(null, "Livro " + tituloEmprestar + " emprestado a " + nomeClienteEmprestar);
        } else {
            JOptionPane.showMessageDialog(null, "Livro ou cliente não encontrado");
        }
    }

    private static void devolverLivro() {
        String tituloDevolver = JOptionPane.showInputDialog(null, "Digite o título do livro a ser devolvido:");
        Biblioteca livroDevolver = encontrarLivroPorTitulo(tituloDevolver);
        if (livroDevolver != null) {
            livroDevolver.devolver();
        } else {
            JOptionPane.showMessageDialog(null, "Livro não encontrado");
        }
    }

    private static Biblioteca encontrarLivroPorTitulo(String titulo) {
        for (Biblioteca livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    private static Usuario encontrarClientePorNome(String nome) {
        for (Usuario cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;
    }

	public void show() {
		// TODO Auto-generated method stub
		
	}
}