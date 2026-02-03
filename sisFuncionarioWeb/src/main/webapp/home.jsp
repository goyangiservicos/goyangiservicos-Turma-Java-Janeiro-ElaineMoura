<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Gerente" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%
Gerente usuario = (Gerente)session.getAttribute("usuarioLogado");



if(usuario ==null){
	response.sendRedirect("login.jsp");
	return;
}
%>
<h2>Bem vindo, <%=usuario.getNome()%> - <%=usuario.getCpf()%></h2>
</head>
<body>

<h3>MENU</h3>
<li>
<a href="<%=request.getContextPath()%>/GerenteController">
Gerenciar Gerentes 
</a>
</li>

<li>
<a href="<%=request.getContextPath()%>/SupervisorAuxiliarController">
Gerenciar Supervisores 
</a>
</li>

<li>
<a href="<%= request.getContextPath() %>/LoginController"> Sair </a>
</li>

</body>
</html>