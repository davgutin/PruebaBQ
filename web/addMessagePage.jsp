<%-- 
    Document   : addMessagePage
    Created on : 23-may-2015, 11:05:13
    Author     : DGG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Message Page</title>
    </head>
    <body>
        <form action="introduceMensaje">
            Introduzca el usuario:
            <input type="text" name="Usuario" value="">
            Y el mensaje que quiere enviar al sistema: 
            <input type="text" name="Mensaje" value="">
            <input type="submit" value="Enviar Mensaje">
            
        </form>
    </body>
</html>
