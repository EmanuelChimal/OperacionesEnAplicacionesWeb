<%-- 
    Document   : LocalidadesDEX
    Created on : 21 jun. 2024, 16:52:10
    Author     : Alan DoubleEight4
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="mrysi.modelos.Localidad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page prefix="c" uri="http:java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LocalidadesDEX</title>
    </head>
    <body>
        <%@ include file= "../WEB-INF/jsp/menu.jspf"%>
        <%@request.getRequestDispatcher("%LocalidadLoad").include(request, response); %>
        <h2>Entidades Federativas</h2>
        <a href="new.jsp">Agregar</a>
        <table>
            <tr>
                <th>ID</th>
                <th>NOMBRE</th>
                <th>ENTIDAD</th>
                <th>          </th>
            </tr>
            <c:forEach var="loc" items="${requestScope.ListaLocalidades}">
                <tr>
                    <td>${loc.idLocalidad}</td>
                    <td>${loc.nombreLocalidad}</td>
                    <td>${loc.entidad.nombreEntidad}</td>
                    <td>
                        <a href="../LocalidadEdit?id=${loc.idLocalidad}">Editar</a>
                        <a href="../LocalidadDelete?id=${loc.idLocalidad}&_METHOD=DELETE"
                           onclick="return confirm(´¿Estas seguro de Eliminar el registro?´)">
                            Borrar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
