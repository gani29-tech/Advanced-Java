<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Checkout</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: center; }
        th { background-color: #f0f0f0; }
        .btn-confirm {
            background-color: #28a745;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 20px;
        }
        .btn-confirm:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

<h2>Checkout</h2>

<c:if test="${not empty cart.cartItems}">
    <table>
        <tr>
            <th>Product</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total</th>
        </tr>
        <c:forEach var="item" items="${cart.cartItems}">
            <tr>
                <td>${item.product.name}</td>
                <td>${item.quantity}</td>
                <td>${item.product.price}</td>
                <td>${item.quantity * item.product.price}</td>
            </tr>
        </c:forEach>
    </table>

    <h3>
        Total Amount:
        <c:set var="total" value="0" />
        <c:forEach var="item" items="${cart.cartItems}">
            <c:set var="total" value="${total + (item.quantity * item.product.price)}" />
        </c:forEach>
        ${total}
    </h3>

    <form action="${pageContext.request.contextPath}/order/confirm" method="post">
        <button type="submit" class="btn-confirm">Confirm Order</button>
    </form>
</c:if>

<c:if test="${empty cart.cartItems}">
    <p>Your cart is empty. Please add products before checking out.</p>
</c:if>

</body>
</html>