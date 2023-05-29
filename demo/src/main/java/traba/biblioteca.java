package traba;

import java.util.ArrayList;
import java.util.List;

class Biblioteca {
    private List<Livro> livros;

    public Biblioteca() {
        livros = new ArrayList<>();
    }

    public void cadastrar(Livro livro) {
        livros.add(livro);
        System.out.println("Livro " + livro.getTitulo() + " cadastrado no sistema por " + livro.getAutor() +
                "; Qtd: " + livro.getQtdEstoque());
    }

    public void excluir(Livro livro) {
        livros.remove(livro);
        System.out.println("Livro " + livro.getTitulo() + " excluído do sistema");
    }

    public void emprestar(Livro livro, Usuario usuario) {
        if (livro.getQtdEstoque() > 0) {
            livro.setQtdEstoque(livro.getQtdEstoque() - 1);
            livro.setEmprestados(livro.getEmprestados() + 1);
            livro.getEmprestadosPor().add(usuario);
            System.out.println("Livro " + livro.getTitulo() + " emprestado a " + usuario.getNome() +
                    "; Qtd atual no estoque: " + livro.getQtdEstoque());
        } else {
            System.out.println("Não há exemplares disponíveis desse livro no momento.");
        }
    }

    public void devolver(Livro livro, Usuario usuario) {
        if (livro.getEmprestadosPor().contains(usuario)) {
            livro.setQtdEstoque(livro.getQtdEstoque() + 1);
            livro.setEmprestados(livro.getEmprestados() - 1);
            livro.getEmprestadosPor().remove(usuario);
            System.out.println("Livro " + livro.getTitulo() + " devolvido por " + usuario.getNome() +
                    "; Qtd atual no estoque: " + livro.getQtdEstoque());
        } else {
            System.out.println("Esse livro não está emprestado para esse usuário.");
        }
    }

    public List<Livro> getLivros() {
        return livros;
    }
}
