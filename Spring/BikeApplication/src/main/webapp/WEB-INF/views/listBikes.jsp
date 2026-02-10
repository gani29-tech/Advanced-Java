<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>
<html>
<body>
<h3>Bike List</h3>
<table border="1" align="center">
<tr><th>Id</th><th>Name</th><th>CC</th></tr>
<a:forEach var="b" items ="${list}">
<tr>
    <td>${b.id}</td>
    <td>${b.name}</td>
    <td>${b.cc}</td>
</tr>
</a:forEach>
</table>
</body>
</html>
