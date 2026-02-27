<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Order Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 40px;
            text-align: center;
            background-color: #f9f9f9;
        }
        .success-message {
            color: #28a745;
            font-size: 24px;
            margin-bottom: 20px;
        }
        .order-details {
            font-size: 18px;
            margin-top: 20px;
        }
        a {
            display: inline-block;
            margin-top: 30px;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="success-message">
    Thank you! Your order has been placed successfully.
</div>

<c:if test="${not empty order}">
    <div class="order-details">
        <p>Order ID: ${order.id}</p>
        <p>Order Date: ${order.orderDate}</p>
        <p>Total Amount: ${order.totalAmount}</p>
    </div>
</c:if>

<a href="${pageContext.request.contextPath}/home">Continue Shopping</a>
<a href="${pageContext.request.contextPath}/order/list">Go to Orders</a>

</body>
</html>