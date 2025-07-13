package br.com.unicesumar.biblioteca.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LivroDAO {

    public static final List<Livro> acervo = new CopyOnWriteArrayList<Livro>();
    private static LivroDAO instance;

    static {
        acervo.add(new Livro("Engenharia de Software", "Ian Sommerville", 2019, "978-8543024927"));
        acervo.add(new Livro("Java: Como Programar", "Paul Deitel", 2016, "978-8543004790"));
        acervo.add(new Livro("Código Limpo", "Robert C. Martin", 2009, "978-8576082675"));
    }

    private LivroDAO() {}

    public static synchronized LivroDAO getInstance() {
        if (instance == null) {
            instance = new LivroDAO();
        }
        return instance;
    }

    public List<Livro> geTodosLivros() {
        return Collections.unmodifiableList(acervo);
    }

    public void adicionarLivro(Livro livro) {
        acervo.add(livro);
    }

    public void excluirLivro(String isbn) {
        acervo.removeIf(livro -> {
            return livro.getIsbn().equals(isbn);
        });
    }

    public boolean livroExiste(String isbn) {
        return acervo.stream().anyMatch(livro -> livro.getIsbn().equals(isbn));
    }

}
