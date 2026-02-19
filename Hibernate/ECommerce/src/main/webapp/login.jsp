<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<style>
    body {
        font-family: Arial, sans-serif;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .login-container {
        background: #ffffff;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 6px 15px rgba(0,0,0,0.2);
        width: 350px;
        text-align: center;
    }
    h2 {
        margin-bottom: 20px;
        color: #333;
    }
    label {
        display: block;
        text-align: left;
        margin-top: 10px;
        font-weight: bold;
    }
    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 8px;
        margin-top: 5px;
        border-radius: 5px;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }
    input[type="submit"] {
        width: 100%;
        margin-top: 20px;
        padding: 10px;
        border: none;
        border-radius: 5px;
        background-color: #4CAF50;
        color: white;
        font-weight: bold;
        cursor: pointer;
        transition: 0.3s;
    }
    input[type="submit"]:hover {
        background-color: #388E3C;
    }
    .error {
        color: red;
        margin-top: 10px;
        font-weight: bold;
    }
    .signup-link {
        margin-top: 15px;
        display: block;
        font-size: 14px;
    }
    .signup-link a {
        text-decoration: none;
        color: #4CAF50;
        font-weight: bold;
    }
    .signup-link a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
<div class="login-container">
    <h2>Login</h2>
    <form action="login" method="post">
        <label>Username</label>
        <input type="text" name="username" required />
        <label>Password</label>
        <input type="password" name="password" required />
        <input type="submit" value="Login" />
    </form>
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>
    <div class="signup-link">
        New user? <a href="signup.jsp">Signup</a>
    </div>
</div>
</body>
</html>
