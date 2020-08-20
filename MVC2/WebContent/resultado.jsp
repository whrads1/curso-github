<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>    
<!DOCTYPE html>
<html>
<!--  Tirar esse trecho
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head> -->
<body>
    <!-- Imprimir o resultado do controler -->
    <h1>Seleção de Cervejas</h1>
    <p>
    <%
       List marcas = (List) request.getAttribute("marcas");
       //Iterator é um padrão para percorrer listas
       Iterator it = marcas.iterator();
       while (it.hasNext()) {
    	   out.println("<br>Experimente: " + it.next());
       }
    %>
</body>
</html>