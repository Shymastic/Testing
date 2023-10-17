<%-- 
    Document   : CreateNewAccount
    Created on : Jun 24, 2023, 8:20:27 AM
    Author     : admin
--%>


<%@page import="khoalnd.Registration_CartObj.RegistrationInsertError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Account</title>
    </head>
    <body>
        <h1>Create New Account</h1>
        <form action="MainController" method="POST">
            Username* <input type="text" name="txtUsername"
                             value=""/> (6 - 20 chars) <br/>
            <font color="red">
            <%
                RegistrationInsertError errors = (RegistrationInsertError) request.getAttribute("INSERTERROR");

                if (errors != null) {
                    if (errors.getUsernameLengthErr() != null) {
                        System.out.println("hi");
            %>
            <%= errors.getUsernameLengthErr()%>
            <%
                    }
                }
            %>
            </font>
            Password* <input type="password" name="txtPassword" value="" /> (6 - 30 chars)<br>
            <font color="red">
            <%
                if (errors != null) {
                    if (errors.getPasswordLengthErr() != null) {

            %>
            <%= errors.getPasswordLengthErr()%><br>
            <%
                    }
                }

            %>
            </font>
            Confirm* <input type="password" name="txtConfirm" value="" /><br>
            <font color="red">
            <%
                if(errors != null){
                    if (errors.getConfirmNotMatch() !=null){
                        %>
                        <%=errors.getConfirmNotMatch()%><br>
                        <%
                    }
                }
            %>
            </font>
            Last name <input type="text" name="txtLastname" value=""/> (2 - 50 chars)<br>
            <font color="red">
            <%
                if (errors != null) {
                    if (errors.getLastNameLengthErr() != null) {
            %>
            <%=errors.getLastNameLengthErr()%><br>
            <%
                    }
                }
            %>
            </font>
            <input type="submit" value="Create New Account" name="btAction"/>
            <input type="reset" value="Reset"/>
        </form><br>
        <font color="red">
        <%
            if (errors != null) {
                if (errors.getUsernameIsExisted() != null) {
        %>
        <%= errors.getUsernameIsExisted()%><br>
        <%      }
            }
            
        %>
        </font>
        <input type="hidden" value="<%=errors%>" name="error"/>
    </body>
</html>
