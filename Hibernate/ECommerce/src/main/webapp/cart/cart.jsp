<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
 
<h2>Your Cart</h2>
 
<table border="1">
<tr>
    <th>Product</th>
    <th>Qty</th>
    <th>Price</th>
</tr>
 <c:if test="${not empty cartItems}">
<c:forEach items="${cartItems}" var="c">
<tr>
    <td>${c.product.name}</td>
    <td>${c.quantity}</td>
    <td>₹${c.product.price}</td>
</tr>
<a href="${pageContext.request.contextPath}/removecart?id=${c.id}">Remove From Cart</a>
</c:forEach>
</table>

<h3>Total: ₹${total}</h3>

<a href="cart/checkout.jsp">Checkout</a>
 </c:if>
  <c:if test="${empty cartItems}">
  Cart is Empty!!!!
  <a href="${pageContext.request.contextPath}/home">Shop now</a>
  </c:if>
</body>
</html>