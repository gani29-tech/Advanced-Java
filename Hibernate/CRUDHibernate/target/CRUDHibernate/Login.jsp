<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<html>
<head><title>Login</title></head>
<body>
<h2>Login Page</h2>

<form method="post" action="Login">
    <label>Username:</label>
    <input type="text" name="username" value="${param.username}"><br><br>
    <label>Password:</label>
    <input type="password" name="password"><br><br>
    <input type="submit" value="Login"><br>
</form>
<form method = "post" action = Signup>
	<label>Dont have Account?</label>
    <input type="submit" value ="Signup">
</form>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
</body>
</html>
    