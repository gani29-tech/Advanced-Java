<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*, com.techouts.entities.Product" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
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

<%
    String user = (String) request.getSession().getAttribute("user");
%>

<p>Welcome, <%= user %>!</p>

<h2>Products</h2>
<c:if test="${empty products}">
    <p>Products are Empty</p>
    <a href="products/addProduct.jsp">Add product?</a>
</c:if>

<div class="products-container">
    <c:forEach items="${products}" var="p">
        <div class="product-card">
            <img src="${p.imageUrl}" alt="${p.name}">
            <p><strong>${p.name}</strong></p>
            <p>Price: $${p.price}</p>
            <a href="product?id=${p.id}">About product</a>
        </div>
    </c:forEach>
</div><br><br>

<c:if test="${not empty message}">
    <p style="color:green">${message}</p>
</c:if><br>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if><br>

<a href="cart/cart.jsp">View Cart</a><br><br>
<a href="orders/orders.jsp">Orders</a><br><br>

<% if ("Gani4240".equals(user)) { %>
    <a href="products/addProduct.jsp">Add Product</a><br>
    <a href="products/deleteProduct.jsp">Delete Product</a><br>
    <a href="products/updateProduct.jsp">Update Product</a><br>
<% } %>

<a href="${pageContext.request.contextPath}/logout">Logout</a>

</body>
</html>
