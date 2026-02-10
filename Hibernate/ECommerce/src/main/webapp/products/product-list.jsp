<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
 
<h2>Products</h2>
 
<c:forEach items="${products}" var="p">
    <div>
        <h4>${p.name}</h4>
        <p>₹${p.price}</p>
        <a href="product?id=${p.id}">View</a>
    </div>
</c:forEach>
 
</body>
</html>