<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up - E-Commerce</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .signup-container {
            background-color: white;
            padding: 30px 40px;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
            width: 400px;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-top: 10px;
        }
        input[type="text"], input[type="password"], input[type="email"], input[type="tel"], textarea {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }
        textarea {
            resize: vertical;
        }
        button {
            width: 100%;
            margin-top: 20px;
            padding: 10px;
            border: none;
            background-color: #28a745;
            color: white;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #218838;
        }
        .message {
            margin-top: 10px;
            text-align: center;
        }
        .message.error { color: red; }
        .message.success { color: green; }
        .login-link {
            margin-top: 15px;
            text-align: center;
        }
        .login-link a {
            text-decoration: none;
            color: #007bff;
        }
        .login-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="signup-container">
    <h2>Sign Up</h2>

    <c:if test="${not empty error}">
        <div class="message error">${error}</div>
    </c:if>

    <c:if test="${not empty success}">
        <div class="message success">${success}</div>
    </c:if>

    <form action="signup" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required/>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required/>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required/>

        <label for="phone">Phone:</label>
        <input type="tel" id="phone" name="phone" required/>

        <label for="address">Address:</label>
        <textarea id="address" name="address" rows="3" required></textarea>

        <button type="submit">Sign Up</button>
    </form>

    <div class="login-link">
        Already have an account? <a href="<c:url value='/login'/>">Login here</a>
    </div>
</div>
</body>
</html>