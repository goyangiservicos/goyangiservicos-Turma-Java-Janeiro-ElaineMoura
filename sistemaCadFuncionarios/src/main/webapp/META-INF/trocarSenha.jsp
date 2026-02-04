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
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Trocar Senha</title>

<style>
body {
    margin: 0;
    font-family: Arial, Helvetica, sans-serif;
    background: linear-gradient(135deg, #081a3a, #0b2d5c);
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    color: #ffffff;
}

.container {
    background-color: #0e2a52;
    padding: 40px 45px;
    border-radius: 12px;
    width: 100%;
    max-width: 400px;
    box-shadow: 0 10px 30px rgba(0,0,0,0.45);
    text-align: center;
}

h2 {
    margin-bottom: 25px;
}

label {
    display: block;
    text-align: left;
    font-weight: bold;
    margin-bottom: 6px;
}

input {
    width: 100%;
    padding: 10px;
    margin-bottom: 18px;
    border-radius: 6px;
    border: none;
}

button {
    width: 100%;
    padding: 12px;
    background-color: #1f4fd8;
    color: #ffffff;
    border: none;
    border-radius: 6px;
    font-weight: bold;
    cursor: pointer;
}

button:hover {
    background-color: #163bb0;
}
</style>
</head>

<body>

<div class="container">
    <h2>Definir nova senha</h2>

    <form method="post"
          action="<%= request.getContextPath() %>/TrocarSenhaController">

        <label>Nova senha</label>
        <input type="password" name="novaSenha" required>

        <label>Confirmar senha</label>
        <input type="password" name="confirmarSenha" required>

        <button type="submit">Salvar senha</button>
    </form>
</div>

</body>
</html>