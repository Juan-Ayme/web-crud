<%-- 
    Document   : index
    Created on : 26-oct-2022, 8:19:03
    Author     : Maver
--%>

<%@page import="modelo.Estudiantes"%>
<%@page import="java.util.List"%>
<jsp:useBean id="control" scope="page" class="Controladores.Controles" />
<%
    List dato;
    dato=control.listarEstudiantes();

    request.setAttribute("listaEs",dato);
%>

<%-- 
    GUARDAR
--%>
<%
    String codigo=request.getParameter("txtcodigo");
    String nombre=request.getParameter("txtnombre");
    String notaA=request.getParameter("txtnotaA");
    String notaB=request.getParameter("txtnotaB");
    String notaC=request.getParameter("txtnotaC");
    String asistencia=request.getParameter("txtAsistencia");
    
    //llega de aqui y de editar
    String accio=request.getParameter("accio");
    try 
    {
        if(accio.equals("guardar"))
        {
            control.guardarEs(codigo, nombre, notaA, notaB, notaC, asistencia);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else if(accio.equals("editar"))
        {
            control.actualizarEs(codigo, nombre, notaA, notaB, notaC, asistencia);
             request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        
    } catch (Exception e) 
   {
            e.printStackTrace(System.out);
   }
%>

<%-- 
    ELIMINAR Y EDITAR
--%>

<%
    String accion=request.getParameter("accion");
    String codi=request.getParameter("id");
    try 
    {
        if(accion.equals("eliminar"))
        {
            control.eliminar(codi);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        }else if(accion.equals("editar"))
        {
            Estudiantes es=control.listarEstudiante(codi);
            
            request.setAttribute("estudiante", es);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
    } catch (Exception e) 
   {
            e.printStackTrace(System.out);
   } 
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body id="flotante">
        <style>
#flotante {
  width: 100%;
  height: 1060px;
  border: 3px solid black;
  margin: 0;
}
#flotante .red {
  float: left;
  width: 900px;
  height: 100px;
  border: 3px solid red;
  margin: 0;
}
#flotante .blue {
  float: left;
  width: 300px;
  height: 500px;
  border: 3px solid blue;
  margin: 0;
}
</style>
        <div>
            <h1>Lista de Alumnos en la Base de Datos</h1>
        </div>
         <div>
            <table border="1"class="red" >
                <thead>
                    <tr>
                        <th>CODIGO</th>
                        <th>NOMBRE</th>
                        <th>PRIMERA NOTA</th>
                        <th>SEGUNDA NOTA</th>
                        <th>TERCERA NOTA</th>
                        <th>PROMEDIO FINAL</th>
                        <th>ASISTENCIA</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="da" items="${listaEs}">
                        <tr>
                            <td>${da.getCodigo()}</td>
                            <td>${da.getNombre()}</td>
                            <td>${da.getNotaA()}</td>
                            <td>${da.getNotaB()}</td>
                            <td>${da.getNotaC()}</td>
                            <td>${da.getPromedio()}</td>
                            <td>${da.getAsistencia()}</td>
                            <td>
                                <form action="index.jsp">
                                    <input type="hidden" name="id" value="${da.getCodigo()}" >
                                    <input type="submit" name="accion" value="eliminar" >
                                    <td>
                                        <input type="submit" name="accion" value="editar" >
                                    </td>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="blue">
            <center>
                <h1>Agregar</h1>
            <form action="index.jsp">
                <p>Codigo:</p>
                <input type="text" name="txtcodigo" >
                <p>Nombre:</p>
                <input type="text" name="txtnombre" >
                <p>Primera nota</p>
                <input type="text" name="txtnotaA" >
                <p>Segunda nota</p>
                <input type="text" name="txtnotaB" >
                <p>Tercera nota</p>
                <input type="text" name="txtnotaC" >
                <p>Asistencia</p>
                <input type="text" name="txtAsistencia" >
                 <p></p>
                 <button type="submit" name="accio" value="guardar" >Guardar</button>
            </form>
            </center> 
        </div>

    </body>
</html>
