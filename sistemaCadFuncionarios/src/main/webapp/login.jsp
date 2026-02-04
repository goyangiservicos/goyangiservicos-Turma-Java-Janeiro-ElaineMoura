<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Login</title>

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

.login-container {
    background-color: #0e2a52;
    padding: 40px 45px;
    border-radius: 12px;
    width: 100%;
    max-width: 380px;
    box-shadow: 0 10px 30px rgba(0,0,0,0.45);
    text-align: center;
}

.login-container h2 {
    margin-bottom: 25px;
    font-size: 22px;
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
    font-size: 15px;
}

button:hover {
    background-color: #163bb0;
}
</style>
</head>

<body>

<div class="login-container">
    <h2>Login do Sistema</h2>

    <form method="post"
          action="<%= request.getContextPath() %>/LoginController">

        <label>CPF</label>
        <input type="text" name="cpf" required>

        <label>Senha</label>
        <input type="password" name="senha" required>

        <button type="submit">Entrar</button>
    </form>
</div>

</body>
</html>