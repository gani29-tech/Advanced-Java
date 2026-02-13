<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .header-links a { margin-right: 15px; text-decoration: none; color: #007bff; }
        .header-links a:hover { text-decoration: underline; }
        .category-select { margin: 20px 0; }
        .products-container { display: flex; flex-wrap: wrap; gap: 20px; }
        .product-card { border: 1px solid #ccc; padding: 15px; width: 200px; text-align: center;
                        box-shadow: 0 2px 5px rgba(0,0,0,0.1); border-radius: 5px; transition: transform 0.2s; }
        .product-card:hover { transform: scale(1.05); }
        .product-card img { width: 150px; height: 150px; object-fit: contain; }
        .product-card a, .product-card button { display: inline-block; margin-top: 10px; text-decoration: none;
                                                color: white; background-color: #28a745; padding: 5px 10px;
                                                border-radius: 3px; border: none; cursor: pointer; }
        .product-card a:hover, .product-card button:hover { background-color: #218838; }
        .message { color: green; }
        .error { color: red; }
    </style>
</head>
<body>

<%
    String user = (String) session.getAttribute("username");
%>

<div class="header-links">
    <a href="profile.jsp">Update Profile</a>
    <a href="${pageContext.request.contextPath}/displaycart">View Cart</a>
    <a href="${pageContext.request.contextPath}/orders">Orders</a>

    <% if ("Gani4240".equals(user)) { %>
        <a href="products/addProduct.jsp">Add Product</a>
        <a href="products/deleteProduct.jsp">Delete Product</a>
        <a href="products/updateProduct.jsp">Update Product</a>
    <% } %>

    <a href="${pageContext.request.contextPath}/logout">Logout</a>
</div>

<h2>Welcome, <%= user %>!</h2>

<!-- Category filter -->
<form method="get" action="home">
    <div class="category-select">
        <label for="category">Filter by Category: </label>
        <select name="category" id="category" onchange="this.form.submit()">
            <option value="All" ${param.category == null || param.category == 'All' ? 'selected' : ''}>All</option>
            <c:forEach items="${categories}" var="cat">
                <option value="${cat}" ${param.category == cat ? 'selected' : ''}>${cat}</option>
            </c:forEach>
        </select>
    </div>
</form>

<!-- Products -->
<div class="products-container">
    <c:forEach items="${products}" var="p">
        <c:if test="${param.category == null || param.category == 'All' || param.category == p.category}">
            <div class="product-card">
                <img src="${p.imageUrl}" alt="Image of ${p.name}">
                <h3>${p.name}</h3>
                <p>Category: ${p.category}</p>
                <p>Price: <fmt:formatNumber value="${p.price}" type="currency"/></p>

                <a href="product?id=${p.id}">About Product</a>

                <form action="${pageContext.request.contextPath}/addcart" method="post">
                    <input type="hidden" name="productId" value="${p.id}">
                    <input type="hidden" name="quantity" value="1">
                    <button type="submit">Add to Cart</button>
                </form>

                <a href="${pageContext.request.contextPath}/orderitem?productId=${p.id}">Buy Now</a>
            </div>
        </c:if>
    </c:forEach>
</div>

<c:if test="${empty products}">
    <p class="error">No products available.</p>
</c:if>

<!-- Display messages -->
<c:if test="${not empty sessionScope.message}">
    <p class="message">${sessionScope.message}</p>
    <c:remove var="message" scope="session"/>
</c:if>

<c:if test="${not empty sessionScope.error}">
    <p class="error">${sessionScope.error}</p>
    <c:remove var="error" scope="session"/>
</c:if>

</body>
</html>
