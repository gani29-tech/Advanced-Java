<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body>

<h2>Login</h2>

<form action="login" method="post">
    Username: <input type="text" name="username" required /><br><br>
    Password: <input type="password" name="password" required /><br><br>
    <input type="submit" value="Login" />
</form>
<br>
<c:if test="${not empty error}">
<p style="color:red">${error}</p>
</c:if>

New user?<a href="signup.jsp"> Signup</a>

</body>
</html>
