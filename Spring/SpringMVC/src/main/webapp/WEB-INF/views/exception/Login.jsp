<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty message}">
    <p style="color:red">${message}</p>
</c:if>
<form action="login">
Name:<input type="text" name="name"><br><br>
Password:<input type="password" name="password"><br><br>
<input type="submit" value="Login">
</form>