<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Signup</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f6f9;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .container {
        background: #ffffff;
        padding: 30px 40px;
        border-radius: 8px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        width: 350px;
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    input[type="text"],
    input[type="email"],
    input[type="password"],
    input[type="tel"] {
        width: 100%;
        padding: 8px;
        margin-top: 5px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #4CAF50;
        border: none;
        border-radius: 4px;
        color: white;
        font-size: 16px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }

    .error {
        color: red;
        text-align: center;
        margin-top: 10px;
    }

    .login-link {
        text-align: center;
        margin-top: 15px;
    }

    .login-link a {
        text-decoration: none;
        color: #4CAF50;
        font-weight: bold;
    }

    .login-link a:hover {
        text-decoration: underline;
    }
</style>

</head>
<body>

<div class="container">
    <h2>Signup</h2>

    <form action="signup" method="post">
        Name:
        <input type="text" name="name" required />

        Username:
        <input type="text" name="username" required />

        Email:
        <input type="email" name="email" required />

        Password:
        <input type="password" name="password" required />

        Phone Number:
        <input type="tel" name="phonenumber" required />

        <input type="submit" value="Register" />
    </form>

    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>

    <div class="login-link">
        Already have account? <a href="login.jsp">Login</a>
    </div>
</div>

</body>
</html>
