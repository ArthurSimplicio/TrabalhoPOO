package s;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


class Biblioteca {
    private String titulo;
    private String autor;
    private String editora;
    private int qtdEstoque;

    public Biblioteca(String titulo, String autor, String editora, int qtdEstoque) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.qtdEstoque = qtdEstoque;
    }

    public void emprestar() {
        if (qtdEstoque > 0) {
            qtdEstoque--;
            JOptionPane.showMessageDialog(null, "Livro " + titulo + " emprestado");
        } else {
            JOptionPane.showMessageDialog(null, "Não há estoque disponível para o livro " + titulo);
        }
    }

    public void devolver() {
        qtdEstoque++;
        JOptionPane.showMessageDialog(null, "Livro " + titulo + " devolvido");
    }

    public void cadastrar() {
        JOptionPane.showMessageDialog(null, "Livro " + titulo + " cadastrado no sistema");
    }

    public String getTitulo() {
        return titulo;
    }
}