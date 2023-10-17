<%-- 
    Document   : Search
    Created on : Jun 10, 2023, 8:45:45 AM
    Author     : admin
--%>

<%@page import="khoalnd.Registration_CartObj.RegistrationDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <%
            Cookie[] cookie = request.getCookies();
            String username = cookie[cookie.length - 1].getName();
        %>
        <p style="color: red">Welcome <%=username%></p>    
        <h1>Search Page</h1>
        <form action="MainController">
            Search Value <input type ="text" name="txtSearchValue" value="<%=request.getParameter("txtSearchValue")%>"/><br>
            <input type="submit" value="Search" name ="btAction"/>
        </form>
        <%
            String searchValue = request.getParameter("txtSearchValue");

            if (searchValue != null) {
                List<RegistrationDTO> result
                        = (List<RegistrationDTO>) request.getAttribute("SEARCHRESULT");

                if (result != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>LastName</th>
                    <th>Role</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (RegistrationDTO dto : result) {
                        String urlRewriting = "MainController?username=" + dto.getUsername() + "&lastValue=" + request.getParameter("txtSearchValue") + "&btAction=Del";

                %>
            <form action='MainController'><tr>
                    <td>
                        <%= ++count%>
                    </td>

                    <td>
                        <input type="hidden" name="txtUsername" value="<%= dto.getUsername()%>"> 
                        <%= dto.getUsername()%>
                    </td>

                    <td>
                        <input type='text' name='txtPassword' value="<%=dto.getPassword()%>"/>
                    </td>

                    <td>
                       <%=dto.getLastname()%>
                    </td>
                    <%if (dto.isRole()) {%>
                    <td><input type='checkbox' checked='checked' name='isAdmin'/> <%=dto.isRole()%></td>
                        <%} else {%>
                    <td><input type='checkbox' name='isAdmin'/> <%=dto.isRole()%> </td>
                        <%}%> 
                    <td><a href= "<%=urlRewriting%>" >Delete</a></td>

                <input type='hidden' name='lastSearchValue' value='<%=request.getParameter("txtSearchValue")%>'>
                <td><input type='submit' value='Update' name='btAction'></td>              
                </tr></form>
                <%
                    }
                %>
        </tbody>
    </table>
    <%
    } else {
    %>
    <h2>No record is matched</h2>
    <%
            }
        }
    %>
</body>
</html>
