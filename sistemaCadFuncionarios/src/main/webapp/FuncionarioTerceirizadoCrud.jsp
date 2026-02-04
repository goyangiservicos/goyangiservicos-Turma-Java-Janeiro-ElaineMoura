<%@ page import="java.util.List"%>
<%@ page import="model.FuncionarioTerceirizado"%>
<%@ page import="model.Funcao"%>
<%@ page import="model.FuncionarioInterno"%>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.util.Locale" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
Object usuario = session.getAttribute("usuarioLogado");
if (usuario == null) {
    response.sendRedirect("login.jsp");
    return;
}

FuncionarioTerceirizado funcionarioAtualizar =
    (FuncionarioTerceirizado) request.getAttribute("funcionarioAtualizar");

boolean editando = (funcionarioAtualizar != null);
String acaoForm = editando ? "atualizar" : "salvar";
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Funcionário Terceirizado</title>

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
<h3>Cadastro de Funcionário Terceirizado</h3>

<form method="post"
      action="<%= request.getContextPath() %>/FuncionarioTerceirizadoController">

    <input type="hidden" name="acao" value="<%= acaoForm %>">

    <div class="form-grid">

        <div class="form-group">
            <label>CPF</label>
            <input type="text" name="cpf"
                   value="<%= editando ? funcionarioAtualizar.getCpf() : "" %>"
                   <%= editando ? "readonly" : "" %> required>
        </div>

        <div class="form-group">
            <label>Horas trabalhadas</label>
           <input type="number" step="0.01" min="0" name="horasTrabalhadas"
                   value="<%= editando ? funcionarioAtualizar.getHorasTrabalhadas() : "" %>"
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
            <label>Função</label>
            <select name="funcao" required>
                <%
                for (Funcao f : Funcao.values()) {
                    boolean selected =
                        editando && f.equals(funcionarioAtualizar.getFuncao());
                %>
                <option value="<%= f.name() %>"
                    <%= selected ? "selected" : "" %>>
                    <%= f.name() %>
                </option>
                <%
                }
                %>
            </select>
        </div>

        <div class="form-group form-full">
            <label>Empresa</label>
            <input type="text" name="empresa"
                   value="<%= editando ? funcionarioAtualizar.getEmpresa() : "" %>"
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

<h3>Lista de Funcionários Terceirizados</h3>
<%
NumberFormat moedaBR = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
%>	
<table>
    <tr>
        <th>CPF</th>
        <th>Nome</th>
        <th>Função</th>
        <th>Empresa</th>
        <th>Horas</th>
        <th>Custo</th>
        <th>Ações</th>
    </tr>

<%
List<FuncionarioTerceirizado> lista =
    (List<FuncionarioTerceirizado>) request.getAttribute("listaFuncionarioTerceirizado");

if (lista != null) {
    for (FuncionarioTerceirizado f : lista) {
%>
    <tr>
        <td><%= f.getCpf() %></td>
        <td><%= f.getNome() %></td>
        <td><%= f.getFuncao() %></td>
        <td><%= f.getEmpresa() %></td>
        <td>
		<%= f.getHorasTrabalhadas().compareTo(BigDecimal.ZERO) < 0
    	? "0"
   		 : f.getHorasTrabalhadas() %>
		</td>
		<td><%= moedaBR.format(f.getCusto()) %></td>
        <td class="actions">

            <form method="get"
                  action="<%= request.getContextPath() %>/FuncionarioTerceirizadoController">
                <input type="hidden" name="acao" value="buscar">
                <input type="hidden" name="cpf" value="<%= f.getCpf() %>">
                <button type="submit">Editar</button>
            </form>

            <form method="get"
                  action="<%= request.getContextPath() %>/FuncionarioTerceirizadoController">
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