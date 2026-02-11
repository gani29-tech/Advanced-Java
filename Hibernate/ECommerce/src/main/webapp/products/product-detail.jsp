<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<body>
 
<h2>${product.name}</h2>
<p>Price: ₹${product.price}</p>
<p>Description : ${product.description}</p>
 
<form action="${pageContext.request.contextPath}/addcart" method="post">
    <input type="hidden" name="productId" value="${product.id}">
    Quantity:
    <input type="number" name="quantity" value="1" min="1">
    <button type="submit">Add to Cart</button>
</form>
 
<a href="${pageContext.request.contextPath}/home">Back</a>
 
</body>
</html>