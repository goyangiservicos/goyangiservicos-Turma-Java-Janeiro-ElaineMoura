<%@ page import="java.util.List" %>
<%@ page import="model.Gerente" %>
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
	
<h3>LISTA DE ATENDENTES</h3>

<table border="1" cellpadding="5">
    <tr>
        <th>CPF</th>
        <th>NOME</th>
        <th>GERENCIA</th>
    </tr>

    <%
        List<Gerente> lista = (List<Gerente>) request.getAttribute("listarGerente");
        if (lista != null) {
            for (Gerente gerente : lista) {
    %>
                <tr>
                    <td><%= gerente.getCpf() %></td>
                    <td><%= gerente.getNome() %></td>
                    <td><%= gerente.getGerencia() %></td>
                </tr>
    <%
            }
        }
    %>
</table>
	
</body>
</html>