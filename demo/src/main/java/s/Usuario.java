package s;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Usuario {
    private String nome;
    private String cpf;
    private String telefone;
    private boolean funcionario;

    public Usuario(String nome, String cpf, String telefone, boolean funcionario) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.funcionario = funcionario;
    }

    public void cadastrar() {
        JOptionPane.showMessageDialog(null, "Cliente " + nome + " cadastrado no sistema");
    }

    public String getNome() {
        return nome;
    }
}
