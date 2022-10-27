<%-- 
    Document   : editar
    Created on : 27-oct-2022, 5:46:28
    Author     : Maver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <div> <h1> EDITAR ALUMNO</h1> </div>
        <div>
            <form action="index.jsp" >
                <form action="index.jsp">
                <p>Codigo:</p>
                <input type="text" name="txtcodigo" value="${estudiante.getCodigo()}" >
                <p>Nombre:</p>
                <input type="text" name="txtnombre" value="${estudiante.getNombre()}" >
                <p>Primera nota</p>
                <input type="text" name="txtnotaA" value="${estudiante.getNotaA()}">
                <p>Segunda nota</p>
                <input type="text" name="txtnotaB" value="${estudiante.getNotaB()}">
                <p>Tercera nota</p>
                <input type="text" name="txtnotaC" value="${estudiante.getNotaC()}" >
                <p>Asistencia</p>
                <input type="text" name="txtAsistencia" value="${estudiante.getAsistencia()}" >
                <p></p>

                <button type="submit" name="accio" value="editar" >Guardar</button>
            </form>
            </form>
        </div>
    </center>
    </body>
</html>
