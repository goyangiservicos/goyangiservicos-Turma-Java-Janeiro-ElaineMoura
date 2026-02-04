<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.FuncionarioInterno" %>
<%@ page import="model.FuncionarioTerceirizado" %>

<%
Object usuario = session.getAttribute("usuarioLogado");

if (usuario == null) {
    response.sendRedirect("login.jsp");
    return;
}

String nomeUsuario = "";
String cpfUsuario = "";

if (usuario instanceof FuncionarioInterno) {
    FuncionarioInterno fi = (FuncionarioInterno) usuario;
    nomeUsuario = fi.getNome();
    cpfUsuario = fi.getCpf();
} else if (usuario instanceof FuncionarioTerceirizado) {
    FuncionarioTerceirizado ft = (FuncionarioTerceirizado) usuario;
    nomeUsuario = ft.getNome();
    cpfUsuario = ft.getCpf();
}
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Home</title>

<style>
body {
    margin: 0;
    font-family: Arial, Helvetica, sans-serif;
    background: linear-gradient(135deg, #081a3a, #0b2d5c);
    color: #ffffff;
}

.container {
    max-width: 900px;
    margin: 60px auto;
    background-color: #0e2a52;
    padding: 40px;
    border-radius: 12px;
    box-shadow: 0 10px 25px rgba(0,0,0,0.4);
}

h2 {
    text-align: center;
    margin-bottom: 10px;
}

h3 {
    text-align: center;
    margin-bottom: 30px;
    color: #dbe6ff;
}

.menu {
    display: flex;
    flex-direction: column;
    gap: 18px;
    margin-top: 30px;
}

.menu a {
    display: block;
    padding: 14px;
    background-color: #1f4fd8;
    color: #ffffff;
    text-decoration: none;
    text-align: center;
    font-weight: bold;
    border-radius: 8px;
    transition: background-color 0.3s ease;
}

.menu a:hover {
    background-color: #163bb0;
}

.logout {
    margin-top: 40px;
    text-align: center;
}

.logout a {
    color: #ff6b6b;
    font-weight: bold;
    text-decoration: none;
}

.logout a:hover {
    text-decoration: underline;
}
</style>
</head>

<body>

<div class="container">

    <h2>Bem-vindo, <%= nomeUsuario %></h2>
    <h3>CPF: <%= cpfUsuario %></h3>

    <div class="menu">
        <a href="<%= request.getContextPath() %>/FuncionarioInternoController">
            Gerenciar Funcionários Internos
        </a>

        <a href="<%= request.getContextPath() %>/FuncionarioTerceirizadoController">
            Gerenciar Funcionários Terceirizados
        </a>
    </div>

    <div class="logout">
        <a href="<%= request.getContextPath() %>/LoginController">
            Sair do sistema
        </a>
    </div>

</div>

</body>
</html>