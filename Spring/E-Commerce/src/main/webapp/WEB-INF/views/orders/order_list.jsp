<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>My Orders</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: center; }
        th { background-color: #f0f0f0; }
        .btn-view { background-color: blue; color: white; padding: 5px 10px; border-radius: 3px; text-decoration: none; }
    </style>
</head>
<body>
<h2>My Orders</h2>

<c:choose>
    <c:when test="${not empty orders}">
        <table>
            <tr>
                <th>Order ID</th>
                <th>Date</th>
                <th>Status</th>
                <th>Total Amount</th>
                <th>Details</th>
            </tr>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.orderDate}</td>
                    <td>${order.status}</td>
                    <td>${order.totalAmount}</td>
                    <td><a href="${pageContext.request.contextPath}/order/details/${order.id}" class="btn-view">View</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <p>You have no orders.</p>
    </c:otherwise>
</c:choose>

</body>
</html>