package br.com.unicesumar.biblioteca.controller;

import br.com.unicesumar.biblioteca.model.Livro;
import br.com.unicesumar.biblioteca.model.LivroDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/livroServlet")
public class LivroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");

        if("cadastrar".equals(acao)) {
            cadastrarLivro(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        if("excluir".equals(acao)) {
            excluirLivro(request, response);
        } else {
            listarLivros(request, response);
        }
    }

    private  void cadastrarLivro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String anoStr = request.getParameter("anoPublicacao");
        String isbn = request.getParameter("isbn");

        if (titulo == null || titulo.isEmpty() || autor == null || autor.isEmpty() ||
        anoStr == null || anoStr.isEmpty() || isbn == null || isbn.isEmpty()) {

            request.setAttribute("erro", "Preencha os campos obrigatorios!");
            request.getRequestDispatcher("cadastrarLivro.xhtml").forward(request, response);
            return;
        }


        try {
            int ano = Integer.parseInt(anoStr);
            LivroDAO dao = LivroDAO.getInstance();

            if(dao.livroExiste(isbn)){
                request.setAttribute("erro", "Livro já cadastrado com o ISBN informado.");
                request.getRequestDispatcher("cadastrarLivro.xhtml").forward(request, response);
                return;
            }

            Livro novoLivro = new Livro(titulo, autor, ano, isbn);
            dao.adicionarLivro(novoLivro);

            response.sendRedirect("livroServlet?acao=listar");

        } catch (NumberFormatException e) {
            request.setAttribute("erro", "Ano de publicação inválido.");
            request.getRequestDispatcher("cadastrarLivro.xhtml").forward(request, response);
        }
    }

    private void  excluirLivro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String isbn = request.getParameter("isbn");
        if (isbn != null && !isbn.isEmpty()) {
            LivroDAO dao = LivroDAO.getInstance();
            dao.excluirLivro(isbn);
        }

        response.sendRedirect("livroServlet?acao=listar");
    }

    private void listarLivros(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LivroDAO dao = LivroDAO.getInstance();
        request.setAttribute("listaDeLivros", dao.geTodosLivros());
        request.getRequestDispatcher("listarLivros.jsp").forward(request, response);
    }

}
