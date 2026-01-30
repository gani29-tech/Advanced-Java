<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Add Student</title>
</head>
<body>
<h2>Add Student</h2>

<form method="post" action="AddStudent">
    <label>ID:</label>
    <input type="number" name="id" value="${param.id}"><br><br>
    
    <label>Name:</label>
    <input type="text" name="name" value="${param.name}"><br><br>
    
    <input type="submit" value="Submit">
</form>

<c:if test="${not empty message}">
    <p style="color:green">${message}</p>
</c:if>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<a href="ProfilePage">Back to Profile</a>
</body>
</html>
