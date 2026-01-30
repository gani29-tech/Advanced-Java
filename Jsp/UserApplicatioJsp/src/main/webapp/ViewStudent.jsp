<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>View Students</title></head>
<body>
<h2>Student Details</h2>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<c:if test="${empty students}">
    <p>No student entries found.</p>
</c:if>

<c:if test="${not empty students}">
    <table border="1">
        <tr><th>ID</th><th>Name</th></tr>
        <c:forEach var="stu" items="${students}">
            <tr>
                <td>${stu.id}</td>
                <td>${stu.name}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<a href="AddStudent">Add Student</a> | 
<a href="RemoveStudent">Remove Student</a> | 
<a href="Login">Logout</a>

</body>
</html>
