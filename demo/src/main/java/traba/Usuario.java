package traba;
public class Usuario {
    private String nome;
    private String cpf;
    private String telefone;

    public Usuario(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void cadastrar() {
        System.out.println("Usuário " + nome + " cadastrado no sistema");
    }

    public void excluir() {
        System.out.println("Usuário " + nome + " excluído do sistema");
    }

    public void bloquear() {
        System.out.println("Usuário " + nome + " bloqueado");
    }
}     package Trabalho;

import java.util.ArrayList;
import java.util.List;

class Usuario {
    private String nome;
    private String cpf;
    private String telefone;

    public Usuario(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void cadastrar() {
        System.out.println("Usuário " + nome + " cadastrado no sistema");
    }

    public void excluir() {
        System.out.println("Usuário " + nome + " excluído do sistema");
    }

    public void bloquear() {
        System.out.println("Usuário " + nome + " bloqueado");
    }
}

class Livro {
    private String titulo;
    private String autor;
    private String editora;
    private int qtdEstoque;
    private int emprestados;
    private List<Usuario> emprestadosPor;

    public Livro(String titulo, String autor, String editora, int qtdEstoque) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.qtdEstoque = qtdEstoque;
        this.emprestados = 0;
        this.emprestadosPor = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public int getEmprestados() {
        return emprestados;
    }

    public void setEmprestados(int emprestados) {
        this.emprestados = emprestados;
    }

    public List<Usuario> getEmprestadosPor() {
        return emprestadosPor;
    }