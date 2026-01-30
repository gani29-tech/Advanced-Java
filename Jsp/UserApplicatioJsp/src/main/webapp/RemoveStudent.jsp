<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Remove Student</title>
</head>
<body>
<h2>Remove Student</h2>

<p>Enter the name of the student to remove:</p>

<form method="post" action="RemoveStudent">
    <label>Name:</label>
    <input type="text" name="name" value="${param.name}"><br><br>
    <input type="submit" value="Remove">
</form>
<c:if test="${not empty message}">
    <p style="color:green">${message}</p>
</c:if>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<a href="ProfilePage">Back to Profile</a> | 
<a href="ViewStudent">View Student Details</a>
</body>
</html>
