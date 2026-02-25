<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Products List</title>
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
            max-width: 900px;
            margin: 30px auto;
            background-color: #fff;
            padding: 20px 30px;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        }
        h2 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }
        table th, table td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }
        table th {
            background-color: #f0f0f0;
        }
        img {
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        a.button-link {
            text-decoration: none;
            padding: 5px 10px;
            background-color: #007BFF;
            color: white;
            border-radius: 4px;
            margin-right: 5px;
        }
        a.button-link:hover {
            background-color: #0056b3;
        }
        select {
            padding: 5px 10px;
            margin-left: 10px;
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
    <h2>All Products</h2>

    <!-- Category Filter -->
    <form method="GET" action="${pageContext.request.contextPath}/product/list">
        <label for="categoryFilter">Filter by Category:</label>
        <select name="category" id="categoryFilter" onchange="this.form.submit()">
            <option value="">All Categories</option>
            <c:forEach var="cat" items="${categories}">
                <option value="${cat}" <c:if test="${param.category == cat}">selected</c:if>>${cat}</option>
            </c:forEach>
        </select>
    </form>

    <br>

    <a href="${pageContext.request.contextPath}/product/add" class="button-link">Add Product</a>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Category</th>
            <th>Image</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>

        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.category}</td>

                <td>
                    <c:if test="${not empty product.image}">
                        <img src="/uploads/product/${product.image}" width="80"/>
                    </c:if>
                </td>

                <td>${product.price}</td>

                <td>
                    <a href="${pageContext.request.contextPath}/product/details/${product.id}" class="button-link">View</a>
                    <a href="${pageContext.request.contextPath}/product/update/${product.id}" class="button-link">Update</a>
                    <a href="${pageContext.request.contextPath}/product/delete/${product.id}" class="button-link"
                       onclick="return confirm('Are you sure you want to delete this product?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>