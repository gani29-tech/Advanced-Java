<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }

        .navbar {
            background-color: #007bff;
            padding: 15px 20px;
            color: white;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .navbar a {
            color: white;
            text-decoration: none;
            margin-left: 15px;
            font-weight: bold;
        }

        .container {
            padding: 20px;
            max-width: 1000px;
            margin: 20px auto;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        }

        h2 {
            color: #333;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 15px;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #f0f0f0;
        }

        img {
            border-radius: 5px;
        }

        .btn {
            padding: 5px 10px;
            text-decoration: none;
            border-radius: 3px;
            color: white;
            margin: 2px;
        }

        .btn-add { background-color: green; }
        .btn-update { background-color: orange; }
        .btn-delete { background-color: red; }
        .btn-view { background-color: blue; }

        .filter {
            margin-bottom: 15px;
        }

        select {
            padding: 5px 10px;
        }

        .empty-message {
            text-align: center;
            color: #555;
            font-style: italic;
            margin-top: 20px;
        }
    </style>
</head>
<body>

<div class="navbar">
    <div>
        Welcome, ${currentUser.username}
    </div>

    <div>
        <a href="${pageContext.request.contextPath}/user/update">Update Profile</a>
        <a href="${pageContext.request.contextPath}/user/logout">Logout</a>
    </div>
</div>

<div class="container">

    <c:if test="${currentUser.id == 1}">
        <a href="${pageContext.request.contextPath}/product/add" class="btn btn-add">Add Product</a>
    </c:if>

    <!-- Category Filter -->
    <div class="filter">
        <form method="GET" action="${pageContext.request.contextPath}/">
            <label for="categoryFilter">Filter by Category:</label>
            <select name="category" id="categoryFilter" onchange="this.form.submit()">
                <option value="">All Categories</option>
                <c:forEach var="cat" items="${categories}">
                    <option value="${cat}" <c:if test="${param.category == cat}">selected</c:if>>${cat}</option>
                </c:forEach>
            </select>
        </form>
    </div>

    <h2>Products</h2>

    <c:choose>
        <c:when test="${not empty products}">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Image</th>
                    <th>Description</th>
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
                        <td>${product.description}</td>
                        <td>${product.price}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/product/details/${product.id}" class="btn btn-view">View</a>
                            <c:if test="${currentUser.id == 1}">
                                <a href="${pageContext.request.contextPath}/product/update/${product.id}" class="btn btn-update">Update</a>
                                <a href="${pageContext.request.contextPath}/product/delete/${product.id}" class="btn btn-delete"
                                   onclick="return confirm('Are you sure?')">Delete</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <p class="empty-message">No products available.</p>
        </c:otherwise>
    </c:choose>

</div>

</body>
</html>