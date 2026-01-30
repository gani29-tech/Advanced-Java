<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String username = (String) session.getAttribute("username");
    if(username == null){
        response.sendRedirect("Login");
        return;
    }
%>

<html>
<head>
    <title>Profile Page</title>
</head>
<body>
    <h2>Welcome, ${username}!</h2>

    <a href="AddStudent">Add</a>
    <a href="RemoveStudent">Remove</a>
    <a href="ViewStudent">View</a>
    <br><br>
    <a href="Logout">Logout</a>
</body>
</html>
