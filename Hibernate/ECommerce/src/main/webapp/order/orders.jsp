<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        .home-link {
            display: block;
            text-align: center;
            margin-bottom: 20px;
            font-weight: bold;
            text-decoration: none;
            color: #007bff;
        }

        .home-link:hover {
            text-decoration: underline;
        }

        .orders-container {
            display: flex;
            flex-direction: column;
            gap: 25px;
            max-width: 900px;
            margin: 0 auto;
        }

        .order-card {
            background-color: white;
            border-radius: 8px;
            padding: 20px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
            border-left: 5px solid #007bff;
        }

        .order-header {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            margin-bottom: 10px;
            font-size: 14px;
        }

        .order-header p {
            margin: 4px 8px 4px 0;
            font-weight: 600;
            color: #222;
        }

        .order-address {
            font-weight: 600;
            margin-bottom: 15px;
        }

        .items-container {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(160px, 1fr));
            gap: 15px;
            margin-top: 15px;
        }

        .product-card {
            background-color: #fafafa;
            border-radius: 6px;
            padding: 10px;
            text-align: center;
            box-shadow: 0 2px 4px rgba(0,0,0,0.05);
            font-size: 13px;
            color: #333;
        }

        .product-card img {
            width: 100%;
            height: 120px;
            object-fit: contain;
            border-radius: 4px;
            background-color: #ddd;
            margin-bottom: 8px;
        }

        .product-card p {
            margin: 4px 0;
        }

        .product-card p strong {
            color: #007bff;
        }

        .product-btn {
            display: inline-block;
            margin-top: 6px;
            padding: 6px 10px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            font-size: 12px;
            transition: 0.2s ease;
        }

        .product-btn:hover {
            background-color: #0056b3;
        }

        .no-orders {
            text-align: center;
            font-size: 16px;
            color: #555;
            margin-top: 50px;
        }

        .shop-now {
            display: inline-block;
            margin-top: 10px;
            padding: 8px 15px;
            background-color: #28a745;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }

        .shop-now:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

<h2>Orders</h2>

<c:if test="${not empty orders}">
    <a class="home-link" href="${pageContext.request.contextPath}/home">Home</a>
</c:if>
<c:if test="${not empty message}">
    <p style="color:red; text-align:center; font-weight:bold; font-size:16px;">
        ${message}
    </p>
</c:if>
<div class="orders-container">
    <c:forEach items="${orders}" var="o">
        <div class="order-card">
            <div class="order-header">
                <p>Order Id: ${o.id}</p>
                <p>Status: <span style="color:green">${o.status}</span></p>
                <p>Total: $${o.totalAmount}</p>
                <p>Date: <fmt:formatDate value="${o.orderDate}" pattern="yyyy-MM-dd HH:mm:ss" /></p>
                <p>Payment: ${o.paymentType}</p>
                <p class="order-address">Address: ${o.address}</p>
                <p>
                    <a href="${pageContext.request.contextPath}/cancelorder?id=${o.id}"
                       style="color:red;">Cancel Order</a>
                </p>

            </div>



            <div class="items-container">
                <c:forEach items="${o.items}" var="i">
                    <div class="product-card">
                        <img src="${pageContext.request.contextPath}/images/${i.product.imageUrl}"
                             alt="${i.product.name}" />

                        <p><strong>${i.product.name}</strong></p>

                        <a class="product-btn"
                           href="${pageContext.request.contextPath}/product?id=${i.product.id}">
                            About Product
                        </a>

                        <p>Price: $${i.product.price}</p>
                        <p>Qty: ${i.quantity}</p>
                    </div>
                </c:forEach>
            </div>
        </div>
    </c:forEach>

    <c:if test="${empty orders}">
        <div class="no-orders">
            <p>No orders found.</p>
            <a class="shop-now" href="${pageContext.request.contextPath}/home">
                Shop now
            </a>
        </div>
    </c:if>
</div>

</body>
</html>
