<%@ page import="java.util.List" %>
<%@ page import="model.User" %>

<%
    List<User> users = (List<User>) request.getAttribute("users");
    int totalPages = (Integer) request.getAttribute("totalPages");
    int currentPage = (Integer) request.getAttribute("currentPage");
%>

<h2>User List (Page <%= currentPage %> of <%= totalPages %>)</h2>

<table border="1" cellpadding="5">
    <tr>
        <td>Id</td><td>Name</td><td>Email</td>
    </tr>
    <% for(User u : users) { %>
    <tr>
    	<td><%=u.getId() %></td>
        <td><%= u.getName() %></td>
        <td><%= u.getEmail() %></td>
    </tr>
    <% } %>
</table>

<div style="margin-top:10px;">
<% for(int i = 1; i <= totalPages; i++) { %>
    <% if(i == currentPage) { %>
        <b><%= i %></b>
    <% } else { %>
        <a href="Pagenation?page=<%= i %>"><%= i %></a>
    <% } %>
<% } %>
</div>

