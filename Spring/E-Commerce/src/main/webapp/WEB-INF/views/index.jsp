<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome to E-Commerce</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin: 50px;
            background-color: #f5f5f5;
        }

        h1 {
            color: #333;
        }

        .button {
            display: inline-block;
            margin: 15px;
            padding: 12px 25px;
            font-size: 16px;
            text-decoration: none;
            color: #fff;
            background-color: #007bff;
            border-radius: 5px;
            transition: 0.3s;
        }

        .button:hover {
            background-color: #0056b3;
        }

        .products {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            margin-top: 40px;
        }

        .product-card {
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
            margin: 15px;
            width: 250px;
            padding: 15px;
            text-align: center;
        }

        .product-card img {
            width: 200px;
            height: 150px;
            object-fit: cover;
            border-radius: 5px;
        }

        .product-card h3 {
            margin: 10px 0 5px 0;
            font-size: 18px;
            color: #333;
        }

        .product-card p {
            font-size: 14px;
            color: #666;
            margin: 5px 0;
        }

        .product-card a {
            display: inline-block;
            margin-top: 8px;
            padding: 8px 15px;
            text-decoration: none;
            color: #fff;
            background-color: #28a745;
            border-radius: 5px;
            transition: 0.3s;
        }

        .product-card a:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

<h1>Welcome to E-Commerce Portal</h1>
        <a href="login" class="button">Login</a>
        <a href="signup" class="button">Sign Up</a>
<h2>Products</h2>
<div class="products">
    <c:forEach var="product" items="${products}">
        <div class="product-card">
            <c:if test="${not empty product.image}">
                <img src="${pageContext.request.contextPath}/uploads/${product.image}" alt="${product.name}"/>
            </c:if>
            <h3>${product.name}</h3>
            <p>Category: ${product.category}</p>
            <p>Price: $${product.price}</p>
            <a href="${pageContext.request.contextPath}/product/details/${product.id}">View</a>
        </div>
    </c:forEach>
</div>
<c:if test="${empty products}">
<p>Products are empty!!!!!</p>
</c:if>
</body>
</html>