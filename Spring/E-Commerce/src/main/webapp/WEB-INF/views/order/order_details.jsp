<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Order Details - Techouts Ecommerce</title>
    <style>
        body { font-family: 'Segoe UI', sans-serif; background: linear-gradient(to right, #e3f2fd, #fce4ec); padding: 30px; margin: 0; }
        .container { background: #ffffff; padding: 30px; border-radius: 12px; box-shadow: 0 6px 18px rgba(0,0,0,0.1); max-width: 1000px; margin: auto; }
        .top-bar { display: flex; justify-content: space-between; align-items: center; }
        .brand { font-size: 22px; font-weight: bold; color: #2c3e50; }
        .home-btn { background: #2c3e50; color: white; padding: 8px 15px; text-decoration: none; border-radius: 6px; transition: 0.3s; }
        .home-btn:hover { background: #1a252f; }
        h2 { margin-top: 20px; color: #34495e; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 12px; text-align: center; }
        th { background: #2c3e50; color: white; }
        tr:nth-child(even) { background: #f2f2f2; }
        img { width: 70px; height: 70px; object-fit: contain; }
        .total { text-align: right; margin-top: 20px; font-size: 20px; font-weight: bold; color: #27ae60; }
        .back-btn { display: inline-block; margin-top: 20px; background: #2980b9; color: white; padding: 8px 15px; border-radius: 6px; text-decoration: none; }
        .back-btn:hover { background: #1f6692; }
        .status-placed { color: green; font-weight: bold; }
        .status-cancelled { color: red; font-weight: bold; }
        .btn-cancel { background: #c0392b; color: white; padding: 6px 12px; border-radius: 5px; text-decoration: none; transition: 0.3s; }
        .btn-cancel:hover { background: #7f1c18; }
    </style>
</head>
<body>

<div class="container">
    <div class="top-bar">
        <div class="brand">Techouts Ecommerce</div>
        <a href="${pageContext.request.contextPath}/order/list" class="home-btn">Back to Orders</a>
    </div>

    <h2>Order #${order.id} Details</h2>

    <p><strong>Order Date:</strong> ${order.orderDate}</p>
    <p><strong>Payment Type:</strong> ${order.paymentType}</p>
    <p><strong>Status:</strong>
        <c:choose>
            <c:when test="${order.status == 'PLACED'}">
                <span class="status-placed">${order.status}</span>
            </c:when>
            <c:when test="${order.status == 'CANCELLED'}">
                <span class="status-cancelled">${order.status}</span>
            </c:when>
            <c:otherwise>
                ${order.status}
            </c:otherwise>
        </c:choose>
    </p>
    <p><strong>Shipping Address:</strong> ${order.address}, ${order.city}, ${order.state} - ${order.pincode}</p>

    <table>
        <tr>
            <th>Image</th>
            <th>Product</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Subtotal</th>
        </tr>
        <c:forEach var="item" items="${order.orderItems}">
            <tr>
                <td><img src="${pageContext.request.contextPath}/uploads/${item.product.image}" /></td>
                <td>${item.product.name}</td>
                <td>${item.quantity}</td>
                <td>$${item.product.price}</td>
                <td>$${item.quantity * item.product.price}</td>
            </tr>
        </c:forEach>
    </table>
    <div class="total">Total Amount: $${order.totalAmount}</div>

    <c:if test="${order.status == 'PLACED'}">
        <a href="${pageContext.request.contextPath}/order/cancel/${order.id}" class="btn-cancel">Cancel Order</a>
    </c:if>
</div>

</body>
</html>1