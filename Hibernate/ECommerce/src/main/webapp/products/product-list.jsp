<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Products</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 40px;
        }

        a.home-link {
            display: inline-block;
            margin-bottom: 20px;
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
        }

        a.home-link:hover {
            text-decoration: underline;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }

        .products-container {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            justify-content: center;
        }

        .product-card {
            background-color: #fff;
            border: 1px solid #ddd;
            padding: 15px;
            width: 220px;
            text-align: center;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            border-radius: 8px;
        }

        .product-card img {
            width: 100%;
            height: 150px;
            object-fit: contain;
            margin-bottom: 10px;
            border-radius: 5px;
            background-color: #f0f0f0;
        }

        .product-card p {
            margin: 5px 0;
            font-size: 14px;
        }

        .product-card p strong {
            color: #007bff;
        }

        .product-card a {
            display: inline-block;
            margin-top: 8px;
            text-decoration: none;
            color: white;
            background-color: #28a745;
            padding: 6px 12px;
            border-radius: 4px;
            font-size: 14px;
        }

        .product-card a:hover {
            background-color: #218838;
        }

        .product-card button {
            background-color: #ffc107;
            color: #333;
            border: none;
            padding: 8px 12px;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 8px;
            font-size: 14px;
        }

        .product-card button:hover {
            background-color: #e0a800;
        }

        .buy-now {
            display: inline-block;
            margin-top: 8px;
            padding: 6px 12px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            font-size: 14px;
        }

        .buy-now:hover {
            background-color: #0056b3;
        }

        .no-products {
            text-align: center;
            font-size: 16px;
            color: #555;
            margin-top: 30px;
        }

        .no-products a {
            color: #28a745;
            text-decoration: none;
            font-weight: bold;
        }

        .no-products a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<a class="home-link" href="${pageContext.request.contextPath}/home">Home</a>

<h2>Products</h2>

<c:if test="${empty products}">
    <div class="no-products">
        <p>Products are Empty</p>
        <a href="products/addProduct.jsp">Add product?</a>
    </div>
</c:if>

<div class="products-container">
    <c:forEach items="${products}" var="p">
        <div class="product-card">
            <img src="${pageContext.request.contextPath}/images/${p.imageUrl}" alt="${p.name}">
            <p><strong>${p.name}</strong></p>
            <p>Price: $${p.price}</p>
            <a href="product?id=${p.id}">About Product</a>

            <form action="${pageContext.request.contextPath}/addcart" method="post">
                <input type="hidden" name="productId" value="${p.id}">
                <input type="hidden" name="quantity" value="1">
                <br>
                <button type="submit">Add to Cart</button>
            </form>

            <a class="buy-now" href="${pageContext.request.contextPath}/orderitem?productId=${p.id}">Buy Now</a>
        </div>
    </c:forEach>
</div>

</body>
</html>
