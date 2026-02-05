<%@ page import="java.util.List"%>
<%@ page import="model.FuncionarioInterno"%>
<%@ page import="model.FuncionarioTerceirizado" %>
<%@ page import="model.Cargo"%>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
Object usuario = session.getAttribute("usuarioLogado");

if (usuario == null) {
    response.sendRedirect("login.jsp");
    return;
}

FuncionarioInterno funcionarioAtualizar =
    (FuncionarioInterno) request.getAttribute("funcionarioAtualizar");

boolean editando = (funcionarioAtualizar != null);
String acaoForm = editando ? "atualizar" : "salvar";
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Funcionário Interno</title>

<style>
body {
    margin: 0;
    font-family: Arial, Helvetica, sans-serif;
    background: linear-gradient(135deg, #081a3a, #0b2d5c);
    color: #ffffff;
}

.container {
    max-width: 900px;
    margin: 40px auto;
    background-color: #0e2a52;
    padding: 30px;
    border-radius: 12px;
    box-shadow: 0 10px 25px rgba(0,0,0,0.4);
}

h2, h3 {
    text-align: center;
    margin-bottom: 20px;
}

.form-grid {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 18px 20px; 
}

.form-group {
    display: flex;
    flex-direction: column;
    gap: 6px; 
}

.form-full {
    grid-column: 1 / 3;
}

label {
    font-weight: bold;
    font-size: 14px;
}

input, select {
    padding: 9px;
    border-radius: 6px;
    border: none;
}

.buttons {
    display: flex;
    justify-content: center;
    gap: 16px;
    margin-top: 25px;
}

button, .btn-voltar {
    padding: 10px 26px;
    background-color: #1f4fd8;
    color: #fff;
    border: none;
    border-radius: 6px;
    font-weight: bold;
    cursor: pointer;
    text-decoration: none;
}

button:hover, .btn-voltar:hover {
    background-color: #163bb0;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 35px;
}

th, td {
    padding: 10px;
    border-bottom: 1px solid #2c4a7a;
    text-align: center;
}

.actions {
    display: flex;
    justify-content: center;
    gap: 10px;
}
</style>
</head>

<body>

<div class="container">

<%
String nomeUsuario = "";

if (usuario instanceof FuncionarioInterno) {
    nomeUsuario = ((FuncionarioInterno) usuario).getNome();
} else if (usuario instanceof FuncionarioTerceirizado) {
    nomeUsuario = ((FuncionarioTerceirizado) usuario).getNome();
}
%>

Bem-vindo, <%= nomeUsuario %>
<h3>Cadastro de Funcionário Interno</h3>

<form method="post"
      action="<%= request.getContextPath() %>/FuncionarioInternoController">

    <input type="hidden" name="acao" value="<%= acaoForm %>">

    <div class="form-grid">

        <div class="form-group">
            <label>CPF</label>
            <input type="text" name="cpf"
                   value="<%= editando ? funcionarioAtualizar.getCpf() : "" %>"
                   <%= editando ? "readonly" : "" %> required>
        </div>

        <div class="form-group">
            <label>Matrícula</label>
            <input type="text" name="matricula"
                   value="<%= editando ? funcionarioAtualizar.getMatricula() : "" %>"
                   required>
        </div>

        <div class="form-group form-full">
            <label>Nome</label>
            <input type="text" name="nome"
                   value="<%= editando ? funcionarioAtualizar.getNome() : "" %>"
                   required>
        </div>

        <div class="form-group">
            <label>Data de nascimento</label>
            <input type="date" name="dataNascimento"
                   value="<%= editando ? funcionarioAtualizar.getDataNascimento() : "" %>"
                   required>
        </div>

        <div class="form-group">
            <label>Cargo</label>
            <select name="cargo" required>
                <%
                for (Cargo c : Cargo.values()) {
                    boolean selected =
                        editando && c.equals(funcionarioAtualizar.getCargo());
                %>
                <option value="<%= c.name() %>"
                    <%= selected ? "selected" : "" %>>
                    <%= c.name() %>
                </option>
                <%
                }
                %>
            </select>
        </div>

        <div class="form-group">
            <label>Salário</label>
            <input type="number" step="0.01" name="salario"
                   value="<%= editando ? funcionarioAtualizar.getSalario() : "" %>"
                   required>
        </div>

    </div>

    <div class="buttons">
        <button type="submit">
            <%= editando ? "Atualizar" : "Salvar" %>
        </button>

        <a class="btn-voltar"
           href="<%= request.getContextPath() %>/home.jsp">
           Voltar
        </a>
    </div>
</form>

<h3>Lista de Funcionários</h3>
<%
NumberFormat moedaBR = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
%>
<table>
    <tr>
        <th>CPF</th>
        <th>Nome</th>
        <th>Matrícula</th>
        <th>Cargo</th>
        <th>Salário</th>
        <th>PLR</th>
        <th>Ações</th>
    </tr>

<%
List<FuncionarioInterno> lista =
    (List<FuncionarioInterno>) request.getAttribute("listaFuncionarioInterno");

if (lista != null) {
    for (FuncionarioInterno f : lista) {
%>
    <tr>
        <td><%= f.getCpf() %></td>
        <td><%= f.getNome() %></td>
        <td><%= f.getMatricula() %></td>
        <td><%= f.getCargo() %></td>
		<td><%= moedaBR.format(f.getSalario()) %></td>
		<td><%= moedaBR.format(f.getPlr()) %></td>
        <td class="actions">

            <form method="get"
                  action="<%= request.getContextPath() %>/FuncionarioInternoController">
                <input type="hidden" name="acao" value="buscar">
                <input type="hidden" name="cpf" value="<%= f.getCpf() %>">
                <button type="submit">Editar</button>
            </form>

            <form method="get"
                  action="<%= request.getContextPath() %>/FuncionarioInternoController">
                <input type="hidden" name="acao" value="deletar">
                <input type="hidden" name="cpf" value="<%= f.getCpf() %>">
                <button type="submit"
                        onclick="return confirm('Deseja deletar este funcionário?')">
                    Deletar
                </button>
            </form>

        </td>
    </tr>
<%
    }
}
%>

</table>

</div>

</body>
</html>