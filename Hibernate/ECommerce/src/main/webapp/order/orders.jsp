<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <style>
        .orders-container {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
        }

        .order-card {
            border: 1px solid #ccc;
            padding: 15px;
            width: 300px;
            text-align: center;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            border-radius: 5px;
        }

        .order-card a {
            display: inline-block;
            margin-top: 10px;
            text-decoration: none;
            color: white;
            background-color: #007bff;
            padding: 5px 10px;
            border-radius: 3px;
        }

        .order-card a:hover {
            background-color: #0056b3;
        }

        .items-container {
            margin-top: 10px;
        }

        .product-card {
            border: 1px solid #ddd;
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 3px;
            text-align: left;
        }

        .product-card img {
            width: 100%;
            max-height: 150px;
            object-fit: contain;
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
<h2>Orders</h2>
<c:if test="${not empty orders}">
            <a href="${pageContext.request.contextPath}/home">Home</a>
        </c:if><br>
<div class="orders-container">
    <c:forEach items="${orders}" var="o">
        <div class="order-card">
        <p><strong>Order Id:</strong> ${o.id}</p>
            <p><strong>Order Status:</strong> ${o.status}</p>
            <p><strong>Address:</strong> ${o.address}</p>
            <p><strong>Total Price:</strong> $${o.totalAmount}</p>
            <p><strong>Date:</strong> ${o.orderDate}</p>
            <p><strong>Payment Type:</strong> ${o.paymentType}</p>
            <div class="items-container">
                <c:forEach items="${o.items}" var="i">
                    <div class="product-card">
                        <img src="${i.product.imageUrl}" alt="${i.product.name}">
                        <p><strong>${i.product.name}</strong></p>
                        <p>Price: $${i.product.price}</p>
                        <p>Quantity: ${i.quantity}</p>
                    </div>
                </c:forEach>
            </div>
        </div>
    </c:forEach>

    <c:if test="${empty orders}">
        <p>Orders are empty</p>
        <a href="${pageContext.request.contextPath}/home">Shop now</a>
    </c:if>
</div>
</body>
</html>
