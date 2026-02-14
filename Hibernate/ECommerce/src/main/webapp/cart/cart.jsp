<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<a href="${pageContext.request.contextPath}/home">Home</a><br>
<h2>Your Cart</h2>
<c:set var="cartItems" value="${sessionScope.cartItemsList}" />
<c:set var="total" value="${sessionScope.totalPrice}" />
<c:set var="message" value="${sessionScope.message}"/>
<c:if test="${not empty message}">
<p style="color:green">${message}</p>
<c:remove var="message" scope="session"/>
</c:if>
<c:set var="error" value="${sessionScope.error}"/>
<c:if test="${not empty error}">
<p style="color:red">${error}</p>
<c:remove var="error" scope="session"/>
</c:if>
<c:if test="${not empty cartItems}">
    <a href="${pageContext.request.contextPath}/products">Add Products to cart</a><br><br>
    <table border="1">
        <tr>
            <th>Product</th>
            <th>Qty</th>
            <th>Price</th>
            <th>Remove</th>
        </tr>
        <c:forEach items="${cartItems}" var="c">
            <tr>
                <td>${c.product.name}</td>
                <td>${c.quantity}</td>
                <td>Rs:${c.product.price}</td>
                <td><a href="${pageContext.request.contextPath}/removecart?id=${c.id}">Remove</a></td>
            </tr>
        </c:forEach>
    </table>

    <h3>Total: Rs:${total}</h3>
    <a href="cart/checkout.jsp">Checkout</a>
</c:if>

<c:if test="${empty cartItems}">
    Cart is Empty!!!! <a href="${pageContext.request.contextPath}/home">Shop now</a>
</c:if><br>
</body>
</html>
