<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<a href="${pageContext.request.contextPath}/home">Home</a><br>
    <style>
        .products-container {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
        }

        .product-card {
            border: 1px solid #ccc;
            padding: 15px;
            width: 200px;
            text-align: center;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            border-radius: 5px;
        }

        .product-card a {
            display: inline-block;
            margin-top: 10px;
            text-decoration: none;
            color: white;
            background-color: #28a745;
            padding: 5px 10px;
            border-radius: 3px;
        }

        .product-card a:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

<h2>Products</h2>
<c:if test="${empty products}">
    <p>Products are Empty</p>
    <a href="products/addProduct.jsp">Add product?</a>
</c:if>
<div class="products-container">
    <c:forEach items="${products}" var="p">
        <div class="product-card">
            <img src="${pageContext.request.contextPath}/images/${p.imageUrl}" alt="${p.name}">
            <p><strong>${p.name}</strong></p>
            <p>Price: $${p.price}</p>
            <a href="product?id=${p.id}">About product</a>
            <form action="${pageContext.request.contextPath}/addcart" method="post">
                  <input type="hidden" name="productId" value="${p.id}">
                  <input type="hidden" name="quantity" value="1"<br><br>
                  <button type="submit">Add to Cart</button><br><br>
                  <a href="${pageContext.request.contextPath}/orderitem?productId=${p.id}">Buy Now</a>
            </form>
        </div>
    </c:forEach>
</div>

</body>
</html>
