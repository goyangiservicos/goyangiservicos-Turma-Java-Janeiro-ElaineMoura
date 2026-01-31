<%@ page import="java.util.List"%>
<%@ page import="model.Gerente"%>
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

	<%
	Gerente gerenteAtualizar = (Gerente) request.getAttribute("gerenteAtualizar");
	boolean editando = (gerenteAtualizar != null);
	String acaoForm = editando ? "atualizar" : "salvar";
	String cpfValue = editando ? gerenteAtualizar.getCpf() : "";
	String nomeValue = editando ? gerenteAtualizar.getNome() : "";
	String gerenciaValue = editando ? gerenteAtualizar.getGerencia() : "";
	
	%>
<form method="post"
      action="<%=request.getContextPath()%>/GerenteController">

    <input type="hidden" name="acao" value="<%= acaoForm %>">

    <label>Digite o CPF:</label><br>
    <input type="text" name="cpf" <%=editando ? "readonly" : "" %> value="<%= cpfValue %>" required="required"><br>

    <label>Digite nome:</label><br>
    <input type="text" name="nome" value="<%= nomeValue %>" required="required"><br>

    <label>Digite a gerencia:</label><br>
    <input type="text" name="gerencia" value="<%= gerenciaValue %>" required="required"><br><br>

    <button type="submit"><%= editando ? "atualizar" : "salvar" %></button>
</form>

	<h3>LISTA DE ATENDENTES</h3>

	<table border="1" cellpadding="5">
		<tr>
			<th>CPF</th>
			<th>NOME</th>
			<th>GERENCIA</th>
			<th>ACOES</th>
		</tr>

		<%
		List<Gerente> lista = (List<Gerente>) request.getAttribute("listarGerente");
		if (lista != null) {
			for (Gerente gerente : lista) {
		%>
		<tr>
			<td><%=gerente.getCpf()%></td>
			<td><%=gerente.getNome()%></td>
			<td><%=gerente.getGerencia()%></td>
			<td>
				<form method="get"
					action="<%=request.getContextPath()%>/GerenteController"
					style="display: inline;">
					<input type="hidden" name="acao" value="deletar"> <input
						type="hidden" name="cpf" value="<%=gerente.getCpf()%>">
					<button type="submit"
						onclick="return confirm('Tem certeza que deseja deletar?')">
						deletar</button>
				</form>

				<form method="get"
					action="<%=request.getContextPath()%>/GerenteController"
					style="display: inline;">
					<input type="hidden" name="acao" value="atualizar"> <input
						type="hidden" name="cpf" value="<%=gerente.getCpf()%>"> <input
						type="hidden" name="nome" value="<%=gerente.getNome()%>">
					<input type="hidden" name="gerencia"
						value="<%=gerente.getGerencia()%>">
					<button type="submit"
						onclick="return confirm('Tem certeza que deseja atualizar?')">
						atualizar</button>
				</form>
			</td>
		</tr>

		</td>
		</tr>
		<%
		}
		}
		%>
	</table>

</body>
</html>