<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Product Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            padding: 0;
            margin: 0;
        }
        /* Header styling */
        .header {
            background-color: #007BFF;
            color: white;
            padding: 10px 20px;
        }
        .header h1 {
            display: inline;
            margin: 0;
            font-size: 24px;
        }
        .header .nav {
            float: right;
        }
        .header .nav a {
            color: white;
            text-decoration: none;
            margin-left: 15px;
            font-weight: bold;
        }
        .header .nav a:hover {
            text-decoration: underline;
        }
        /* Content styling */
        .content-container {
            background-color: #fff;
            padding: 20px 30px;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
            max-width: 600px;
            margin: 30px auto;
        }
        h2 {
            color: #333;
        }
        p {
            font-size: 16px;
            margin: 8px 0;
        }
        img {
            margin-top: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .links {
            margin-top: 20px;
        }
        .links a {
            text-decoration: none;
            color: #007BFF;
            margin-right: 15px;
            font-weight: bold;
        }
        .links a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<!-- Common Header -->
<div class="header">
    <h1>My Product App</h1>
    <div class="nav">
        <a href="${pageContext.request.contextPath}/">Home</a>
        <a href="${pageContext.request.contextPath}/product/list">Product List</a>
    </div>
    <div style="clear:both;"></div>
</div>

<div class="content-container">
    <h2>Product Details</h2>

    <p><strong>Name:</strong> ${product.name}</p>
    <p><strong>Description:</strong> ${product.description}</p>
    <p><strong>Price:</strong> ${product.price}</p>
    <p><strong>Category:</strong> ${product.category}</p>

    <c:if test="${not empty product.image}">
        <p><strong>Image:</strong></p>
        <img src="/uploads/products/${product.image}" width="300"/>
    </c:if>

    <div class="links">
        <a href="${pageContext.request.contextPath}/product/list">Back to List</a>
        <a href="${pageContext.request.contextPath}/">Home</a>
    </div>
</div>

</body>
</html>