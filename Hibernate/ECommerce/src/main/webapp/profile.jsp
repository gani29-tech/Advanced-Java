<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Update Profile</title>

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
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        width: 400px;
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    .home-link {
        text-decoration: none;
        font-size: 14px;
        color: #4CAF50;
        font-weight: bold;
    }

    label {
        font-weight: bold;
        display: block;
        margin-top: 10px;
    }

    input[type="text"],
    input[type="email"],
    input[type="tel"] {
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
        background-color: #45a049;
    }

    .error {
        color: red;
        margin-top: 15px;
        text-align: center;
        font-weight: bold;
    }
</style>

</head>
<body>

<div class="container">

    <a class="home-link" href="${pageContext.request.contextPath}/home">← Home</a>

    <h2>Update Profile</h2>

    <form action="updateprofile" method="post">

        <input type="hidden" name="userId" value="${userId}"/>

        <label>Name</label>
        <input type="text" name="name" value="${name}" required />

        <label>Username</label>
        <input type="text" name="username" value="${userName}" required />

        <label>Email</label>
        <input type="email" name="email" value="${email}" required />

        <label>Phone Number</label>
        <input type="tel" name="phoneNumber" value="${phoneNumber}" required />

        <input type="submit" value="Update" />

    </form>

    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>

</div>

</body>
</html>
