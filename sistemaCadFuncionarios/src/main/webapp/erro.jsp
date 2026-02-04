<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Erro de Login</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, Helvetica, sans-serif;
        background: linear-gradient(135deg, #081a3a, #0b2d5c);
        height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
        color: #ffffff;
    }

    .error-container {
        background-color: #0e2a52;
        padding: 40px 50px;
        border-radius: 12px;
        width: 100%;
        max-width: 420px;
        box-shadow: 0 12px 30px rgba(0, 0, 0, 0.45);
        text-align: center;
    }

    .error-icon {
        font-size: 46px;
        margin-bottom: 18px;
    }

    .error-container h2 {
        margin: 0 0 15px 0;
        font-size: 24px;
        color: #ff6b6b;
    }

    .error-container p {
        font-size: 16px;
        margin-bottom: 28px;
        color: #dbe6ff;
        line-height: 1.5;
    }

    .error-container a {
        display: inline-block;
        padding: 12px 28px;
        background-color: #1f4fd8;
        color: #ffffff;
        text-decoration: none;
        font-weight: bold;
        border-radius: 6px;
        transition: background-color 0.3s ease;
    }

    .error-container a:hover {
        background-color: #163bb0;
    }
</style>
</head>

<body>

    <div class="error-container">
        <div class="error-icon">🔒</div>
        <h2>Usuário ou senha inválidos</h2>
        <p>
            Não foi possível realizar o login.<br>
            Verifique suas credenciais e tente novamente.
        </p>
        <a href="login.jsp">Voltar para o login</a>
    </div>

</body>
</html>