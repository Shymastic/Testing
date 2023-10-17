<%-- 
    Document   : Created
    Created on : Jul 9, 2023, 8:29:04 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Created!</title>
    </head>
    <body>
        <h1>You have created Your Account!</h1>
        <h1>Please wait</h1>
        <%response.sendRedirect("login.html");
        Thread.sleep(5000);%>
        
    </body>
</html>
