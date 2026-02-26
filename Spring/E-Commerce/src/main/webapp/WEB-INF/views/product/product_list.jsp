<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f4;
            padding: 20px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        .home-link {
            margin-bottom: 20px;
            display: block;
            text-align: center;
        }

        .home-link a {
            text-decoration: none;
            color: #1cc88a;
            font-weight: bold;
            font-size: 16px;
        }

        .product-grid {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
        }

        .product-card {
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            padding: 15px;
            width: 30%;
            box-sizing: border-box;
            text-align: center;
        }

        .product-card img {
            max-width: 100%;
            max-height: 150px;
            object-fit: contain;
            border-radius: 5px;
        }

        .product-card h3 {
            margin: 10px 0 5px 0;
            font-size: 18px;
            color: #333;
        }

        .product-card p {
            margin: 5px 0;
            color: #555;
        }

        .product-card .actions {
            margin-top: 10px;
        }

        .product-card .actions a {
            text-decoration: none;
            margin: 0 5px;
            color: #4e73df;
            font-weight: bold;
        }

        .product-card .actions a:hover {
            text-decoration: underline;
        }

        @media screen and (max-width: 900px) {
            .product-card {
                width: 45%;
            }
        }

        @media screen and (max-width: 600px) {
            .product-card {
                width: 100%;
            }
        }
    </style>
</head>
<body>

<h2>All Products</h2>

<div class="home-link">
    <a href="${pageContext.request.contextPath}/home">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <c:if test="${user.id == 1}">
        <a href="${pageContext.request.contextPath}/product/add">Add Product</a>
    </c:if>
</div>

<div class="product-grid">
    <c:forEach var="product" items="${products}">
        <div class="product-card">
            <c:if test="${not empty product.image}">
                <img src="${pageContext.request.contextPath}/uploads/${product.image}" alt="${product.name}"/>
            </c:if>
            <h3>${product.name}</h3>
            <p>Category: ${product.category}</p>
            <p>Price: $${product.price}</p>
            <div class="actions">
                <a href="${pageContext.request.contextPath}/product/details/${product.id}">View</a>
                <a href="${pageContext.request.contextPath}/product/update/${product.id}">Update</a>
                <a href="${pageContext.request.contextPath}/product/delete/${product.id}"
                   onclick="return confirm('Are you sure?')">Delete</a>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>