<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
    <title>My Orders - Techouts Ecommerce</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to right, #f3e5f5, #e8f5e9);
            padding: 30px;
            margin: 0;
        }

        .container {
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 6px 18px rgba(0,0,0,0.1);
            max-width: 1100px;
            margin: auto;
        }

        .top-bar {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .brand {
            font-size: 22px;
            font-weight: bold;
            color: #2c3e50;
        }

        .home-btn {
            background: #2c3e50;
            color: white;
            padding: 8px 15px;
            text-decoration: none;
            border-radius: 6px;
            transition: 0.3s;
        }

        .home-btn:hover {
            background: #1a252f;
        }

        h2 {
            margin-top: 20px;
            color: #34495e;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            text-align: center;
            vertical-align: middle;
            word-break: keep-all; /* Prevent breaking words */
        }

        th {
            background: #2c3e50;
            color: white;
        }

        tr:nth-child(even) {
            background: #f2f2f2;
        }

        .btn-view, .btn-cancel {
            padding: 6px 15px; /* More horizontal padding */
            border-radius: 5px;
            text-decoration: none;
            transition: 0.3s;
            display: inline-block;
            white-space: nowrap; /* Prevent wrapping */
            font-weight: 600;
            font-size: 14px;
            line-height: 1.2;
            cursor: pointer;
        }

        .btn-view {
            background: #2980b9;
            color: white;
        }

        .btn-view:hover {
            background: #1f6692;
        }

        .btn-cancel {
            background: #c0392b;
            color: white;
        }

        .btn-cancel:hover {
            background: #7f1c18;
        }

        .status-placed {
            color: green;
            font-weight: bold;
        }

        .status-cancelled {
            color: red;
            font-weight: bold;
        }

        .no-orders {
            text-align: center;
            margin-top: 30px;
            font-size: 18px;
            color: #555;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="top-bar">
        <div class="brand">Techouts Ecommerce</div>
        <a href="${pageContext.request.contextPath}/home" class="home-btn">Home</a>
    </div>

    <h2>My Orders</h2>

    <c:choose>
        <c:when test="${not empty orders}">
            <table>
                <tr>
                    <th>Order ID</th>
                    <th>Date</th>
                    <th>Total Amount</th>
                    <th>Status</th>
                    <th>Shipping Address</th>
                    <th>Details</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="order" items="${orders}">
                    <tr>
                        <td>${order.id}</td>
                        <td>${order.orderDate}</td>
                        <td>$${order.totalAmount}</td>
                        <td>
                            <c:choose>
                                <c:when test="${fn:toUpperCase(fn:trim(order.status)) == 'PLACED'}">
                                    <span class="status-placed">${order.status}</span>
                                </c:when>
                                <c:when test="${fn:toUpperCase(fn:trim(order.status)) == 'CANCELLED'}">
                                    <span class="status-cancelled">${order.status}</span>
                                </c:when>
                                <c:otherwise>
                                    ${order.status}
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            ${order.address}, ${order.city}, ${order.state} - ${order.pincode}
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/order/details/${order.id}" class="btn-view">
                                View
                            </a>
                        </td>
                        <td>
                            <c:if test="${fn:toUpperCase(fn:trim(order.status)) == 'PLACED'}">
                                <a href="${pageContext.request.contextPath}/order/cancel/${order.id}" class="btn-cancel">Cancel Order</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <div class="no-orders">You have no orders yet.</div>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>