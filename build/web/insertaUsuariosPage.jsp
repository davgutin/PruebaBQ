<%-- 
    Document   : insertaUsuariosPage
    Created on : 23-may-2015, 11:49:37
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserta Usuarios Page</title>
    </head>
    <body>
        <form action="introduceMensaje">
            Introduzca un nuevo usuario, con nombre:
            <input type="text" name="Nombre" value="">
            E-Mail: 
            <input type="text" name="Email" value="">
            Identificador para el sistema: 
            <input type="text" name="Identificador" value="">
            <input type="submit" value="Introducir Usuario">
            
        </form>
    </body>
</html>

