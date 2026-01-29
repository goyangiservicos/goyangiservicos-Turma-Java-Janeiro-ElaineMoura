<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Gerente</title>
</head>
<body>
	<h2>CRUD - de Gerente</h2>
	<form method="post"
		action="<%=request.getContextPath()%>/GerenteController">
		<label>Digite o CPF:</label><br> <input type="text" name="cpf"
			required="required"> <br> <label>Digite nome:</label><br>
		<input type="text" name="nome" required="required"> <br>
		<label>Digite a gerencia:</label><br> <input type="text"
			name="gerencia" required="required"> <br> <br>
		<button type="submit">Enviar</button>
	</form>
</body>
</html>