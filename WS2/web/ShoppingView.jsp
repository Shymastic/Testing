<%-- 
    Document   : ShoppingView
    Created on : Jun 21, 2023, 8:10:53 AM
    Author     : admin
--%>

<%@page import="khoalnd.Registration_CartObj.CartObj"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Store</title>
    </head>
    <body>
        <h1>Your Cart includes</h1>
        <%
            if(session != null){
                CartObj cart =(CartObj) session.getAttribute("CART");
                
                if(cart !=null){
                    if(cart.getItems() !=null){
                        %>
                        <table border="1">
                               <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>Title</th>
                                    <th>Quantity</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                            <form action ="MainController">
                                <%
                                    Map<String, Integer> items = cart.getItems();
                                    int count = 0;
                                    for(Map.Entry item : items.entrySet()){
                                %>
                                <tr>
                                    <td>
                                        <%=++count%>
                                    </td>
                                    
                                    <td>
                                        <%= item.getKey() %>
                                    </td>
                                    
                                    <td>
                                        <%= item.getValue() %>
                                    </td>
                                    <td>
                                        <input type="checkbox" name="bookList" value="<%=item.getKey()%>"/>
                                    </td>
                                </tr>
                                <% } %>
                                <tr>
                                    <td colspan="3">
                                        <a href ="ShoppingCart1.html">Add More Items to Your Cart</a>
                                    </td>
                                    <td>
                                        <input type="submit" value="Remove Selected Items" name="btAction"/>
                                    </td>    
                                </tr>
                            </form>
                            </tbody>
    </table>
       <%
           return;
                    }
                }
            }
       %>
       <h2>No cart is existed</h2>
    </body>
</html>
