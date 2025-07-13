# 📚 Sistema Web de Biblioteca

Este projeto é uma aplicação web simples para gerenciamento de livros, desenvolvida como atividade acadêmica para a Universidade Unicesumar.

O sistema permite cadastrar, listar e excluir livros de um acervo, utilizando tecnologias fundamentais do ecossistema Java para Web.

---

## ✨ Funcionalidades

- **Cadastro de Livros:** Adiciona novos livros (Título, Autor, Ano, ISBN).
- **Listagem de Acervo:** Exibe todos os livros cadastrados.
- **Exclusão de Livros:** Remove um livro da lista.

---

## 🛠️ Tecnologias Utilizadas

- **Back-End:** Java 11, Jakarta Servlets, CDI (Weld)
- **Front-End:** JSP, JSF (Mojarra), JSTL
- **Servidor:** Apache Tomcat 10.1
- **Build:** Apache Maven
- **Arquitetura:** MVC

---

## 🚀 Como Executar

1.  **Pré-requisitos:** JDK 11, Maven 3.6+ e Tomcat 10.1+.
2.  **Clone o repositório:**
    ```bash
    git clone https://github.com/Wirizada/MapaFabricaDeSoftware.git
    ```
3.  **Abra o projeto** em uma IDE Java (IntelliJ IDEA ou Eclipse).
4.  **Configure o servidor Tomcat** na IDE.
5.  **Crie uma configuração de execução** para o Tomcat, fazendo o deploy do artefato `SistemaBibliotecaWeb:war exploded` no contexto `/SistemaBibliotecaWeb`.
6.  **Execute o projeto**. A aplicação estará disponível em `http://localhost:8080/SistemaBibliotecaWeb/` (ou na porta que você configurou).

