<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login - E-Commerce</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .login-container {
            background-color: white;
            padding: 30px 40px;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
            width: 350px;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-top: 10px;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }
        button {
            width: 100%;
            margin-top: 20px;
            padding: 10px;
            border: none;
            background-color: #007bff;
            color: white;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
        .message {
            margin-top: 10px;
            text-align: center;
        }
        .message.error { color: red; }
        .message.success { color: green; }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Login</h2>

    <!-- Error message -->
    <c:if test="${not empty param.error}">
        <div class="message error">Invalid username or password.</div>
    </c:if>

    <!-- Logout success message -->
    <c:if test="${not empty param.logout}">
        <div class="message success">You have been logged out successfully.</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <label>Username:</label>

        <input type="text" name="username" required />

        <label>Password:</label>
        <input type="password" name="password" required />

        <button type="submit">Login</button>
    </form>

    <c:if test="${param.logout != null}">
        <div style="color:green;">Logged out successfully</div>
    </c:if>
</div>
</body>
</html>