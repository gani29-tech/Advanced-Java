<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Update Profile</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/home">Home</a><br>
<h2>Update Profile</h2>
<form action="updateprofile" method="post">
<input type="hidden" name="userId" value ="${userId}"/>
    Name: <input type="text" name="name" value ="${name}" required /><br><br>
    username: <input type="text" name="username" value ="${userName}" required /><br><br>
    Email: <input type="email" name="email" value ="${email}" required /><br><br>
    Phone Number: <input type="tel" name="phoneNumber" value ="${phoneNumber}" required /><br><br>
    <input type="submit" value="Update" />
</form>
<br>
<c:if test="${not empty error}">
<p style="color:red">${error}</p>
</c:if>
</body>
</html>