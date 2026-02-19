<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Shopping Cart</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f5f5f5;
        }

        a {
            text-decoration: none;
            color: #007BFF;
        }

        a:hover {
            text-decoration: underline;
        }

        h2 {
            color: #333;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            margin-bottom: 20px;
            background-color: #fff;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #007BFF;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .message {
            color: green;
            font-weight: bold;
        }

        .error {
            color: red;
            font-weight: bold;
        }

        .total {
            font-size: 18px;
            font-weight: bold;
        }

        .checkout-btn {
            display: inline-block;
            padding: 8px 16px;
            background-color: #28a745;
            color: white;
            border-radius: 4px;
            margin-top: 10px;
        }

        .checkout-btn:hover {
            background-color: #218838;
        }

    </style>
</head>
<body>
    <a href="${pageContext.request.contextPath}/home">Home</a><br><br>

    <h2>Your Cart</h2>

    <c:set var="cartItems" value="${sessionScope.cartItemsList}" />
    <c:set var="total" value="${sessionScope.totalPrice}" />
    <c:set var="message" value="${sessionScope.message}"/>
    <c:if test="${not empty message}">
        <p class="message">${message}</p>
        <c:remove var="message" scope="session"/>
    </c:if>

    <c:set var="error" value="${sessionScope.error}"/>
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
        <c:remove var="error" scope="session"/>
    </c:if>

    <c:if test="${not empty cartItems}">
        <a href="${pageContext.request.contextPath}/products">Add Products to cart</a><br><br>
        <table>
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
                    <td>Rs: ${c.product.price}</td>
                    <td><a href="${pageContext.request.contextPath}/removecart?id=${c.id}">Remove</a></td>
                </tr>
            </c:forEach>
        </table>

        <h3 class="total">Total: Rs: ${total}</h3>
        <a href="cart/checkout.jsp" class="checkout-btn">Checkout</a>
    </c:if>

    <c:if test="${empty cartItems}">
        <p>Cart is Empty!!!! <a href="${pageContext.request.contextPath}/home">Shop now</a></p>
    </c:if>
</body>
</html>
