<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Order Details</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: center; }
        th { background-color: #f0f0f0; }
    </style>
</head>
<body>
<h2>Order #${order.id} Details</h2>

<p><strong>Order Date:</strong> ${order.orderDate}</p>
<p><strong>Status:</strong> ${order.status}</p>

<table>
    <tr>
        <th>Product</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Subtotal</th>
    </tr>
    <c:forEach var="item" items="${order.orderItems}">
        <tr>
            <td>${item.product.name}</td>
            <td>${item.quantity}</td>
            <td>${item.product.price}</td>
            <td>${item.quantity * item.product.price}</td>
        </tr>
    </c:forEach>
</table>

<h3>Total Amount: ${order.totalAmount}</h3>

<a href="${pageContext.request.contextPath}/order/list">Back to Orders</a>
</body>
</html>