<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Sign Up</title></head>
<body>
<h2>Sign Up Page</h2>

<form method="post" action="Signup">
    <label>Username:</label>
    <input type="text" name="username" value="${param.username}"><br><br>
    <label>Password:</label>
    <input type="password" name="password"><br><br>
    <input type="submit" value="Sign Up">
</form>
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<c:if test="${not empty message}">
    <p style="color:green">${message}</p>
</c:if>

<a href="Login">Go to Login</a>
</body>
</html>
