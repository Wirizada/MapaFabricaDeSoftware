<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, br.com.unicesumar.biblioteca.model.Livro" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Acervo de Livros - Biblioteca Unicesumar</title>
    <style type="text/css">
        body { font-family: Arial, sans-serif; }
        .container { width: 80%; margin: auto; }
        h1 { text-align: center; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .acao-link { color: #dc3545; text-decoration: none; }
        .nav-link { display: inline-block; margin-top: 20px; }
    </style>
</head>
<body>
<div class="container">
    <h1>Acervo de Livros Cadastrados</h1>

    <table>
        <thead>
        <tr>
            <th>Título</th>
            <th>Autor</th>
            <th>Ano de Publicação</th>
            <th>ISBN</th>
            <th>Ação</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="livro" items="${listaDeLivros}">
            <tr>
                <td><c:out value="${livro.titulo}" /></td>
                <td><c:out value="${livro.autor}" /></td>
                <td><c:out value="${livro.anoPublicacao}" /></td>
                <td><c:out value="${livro.isbn}" /></td>
                <td>
                    <a href="livroServlet?acao=excluir&amp;isbn=${livro.isbn}"
                        onclick="return confirm(&quot;Tem certeza que deseja excluir o livro: ${livro.titulo}?&quot;);"
                        class="acao-link">
                        Excluir
                    </a>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empty listaDeLivros}">
            <tr>
                <td colspan="5" style="text-align:center;">Nenhum livro cadastrado.</td>
            </tr>
        </c:if>
        </tbody>
    </table>

    <a href="cadastrarLivro.xhtml" class="nav-link">Cadastrar Novo Livro</a>
</div>
</body>
</html>