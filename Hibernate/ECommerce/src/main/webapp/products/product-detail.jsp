<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<body>
<a href="${pageContext.request.contextPath}/home">Home</a><br>
<h2>${product.name}</h2>
<p>Price: ₹${product.price}</p>
<p>Description : ${product.description}</p>
<img src="${pageContext.request.contextPath}/images/${product.imageUrl}"
                             alt="${product.name}" />
<form action="${pageContext.request.contextPath}/addcart" method="post">
    <input type="hidden" name="productId" value="${product.id}">
   <br> Quantity:
    <input type="number" name="quantity" value="1" min="1"><br><br>
    <button type="submit">Add to Cart</button><br><br>
    <a href="${pageContext.request.contextPath}/orderitem?productId=${product.id}">Buy Now</a>
</form>
 
</body>
</html>