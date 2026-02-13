<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Update Profile</title>
</head>
<body>

<h2>Update Profile</h2>

<form action="profile" method="post">
    Name: <input type="text" name="name" required /><br><br>
    username: <input type="text" name="username" required /><br><br>
    Email: <input type="email" name="email" required /><br><br>
    Password: <input type="password" name="password" required /><br><br>
    Phone Number: <input type="tel" name="phonenumber" required /><br><br>
    <input type="submit" value="Update" />
</form>
<br>
<c:if test="${not empty error}">
<p style="color:red">${error}</p>
</c:if>
</body>
</html>