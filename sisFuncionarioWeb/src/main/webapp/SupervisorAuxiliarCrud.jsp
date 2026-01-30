<%@ page import="java.util.List" %>
<%@ page import="model.SupervisorAuxiliar" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Supervisor Auxiliar</title>
</head>
<body>
	<h2>CRUD - de Supervisor Auxiliar</h2>
	<form method="post"
		action="<%=request.getContextPath()%>/SupervisorAuxiliarController">
		<label>Digite o CPF:</label><br> <input type="text" name="cpf"
			required="required"> <br> <label>Digite nome:</label><br>
		<input type="text" name="nome" required="required"> <br>
		<label>Digite o patio:</label><br> <input type="text"
			name="patio" required="required"> <br> <br>
		<button type="submit">Enviar</button>
	</form>
	
	
	
	<h3>LISTA DE SUPERVISOR AUXILIAR</h3>

<table border="1" cellpadding="5">
    <tr>
        <th>CPF</th>
        <th>NOME</th>
        <th>PATIO</th>
          <th>ACOES</th>
    </tr>

    <%
        List<SupervisorAuxiliar> lista = (List<SupervisorAuxiliar>) request.getAttribute("listarSupervisorAuxiliar");
        if (lista != null) {
            for (SupervisorAuxiliar supervisorAuxiliar : lista) {
    %>
                <tr>
                    <td><%= supervisorAuxiliar.getCpf() %></td>
                    <td><%= supervisorAuxiliar.getNome() %></td>
                    <td><%= supervisorAuxiliar.getPatio()%></td>
               <td>
                    <form method="get" action= "<%=request.getContextPath()%>/SupervisorAuxiliarController" style="display:inline;">
                    <input type="hidden" name="acao" value ="deletar"> 
                    <input type="hidden" name="cpf" value ="<%=supervisorAuxiliar.getCpf() %>"> 
                    <button type="submit" onclick="return confirm('Tem certeza que deseja deletar?')">
                    deletar
                    </button>
                    </form></td>
                </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>

