<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.techouts.entities.User"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<style>
body{font-family:Arial,sans-serif;margin:10px;background:#f4f6f9;}
.header-links{margin-bottom:10px;}
.header-links a{margin-right:10px;text-decoration:none;color:#007bff;font-size:13px;}
.header-links a:hover{text-decoration:underline;}
h2{margin:10px 0;font-size:18px;}
.category-select{margin:10px 0;font-size:13px;}
select{padding:3px;border:1px solid #ccc;border-radius:3px;font-size:13px;}
.products-container{display:flex;flex-wrap:wrap;gap:10px;}
.product-card{border:1px solid #ccc;padding:10px;width:190px;text-align:center;border-radius:5px;background:#fff;box-shadow:0 2px 4px rgba(0,0,0,0.1);transition:0.2s;}
.product-card:hover{transform:scale(1.03);}
.product-card img{width:120px;height:120px;object-fit:contain;}
.product-card h3{margin:5px 0;font-size:14px;}
.product-card p{margin:3px 0;font-size:13px;}
.product-card a,.product-card button{display:inline-block;margin-top:5px;padding:4px 8px;font-size:12px;text-decoration:none;color:#fff;background:#28a745;border:none;border-radius:3px;cursor:pointer;}
.product-card a:hover,.product-card button:hover{background:#218838;}
.message{color:green;font-size:13px;}
.error{color:red;font-size:13px;}
</style>
</head>
<body>
<%
User user=(User)session.getAttribute("user");
%>
<div class="header-links">
<a href="${pageContext.request.contextPath}/updateprofile">Update Profile</a>
<a href="${pageContext.request.contextPath}/displaycart">View Cart</a>
<a href="${pageContext.request.contextPath}/orders">Orders</a>
<% if(1==user.getId()){ %>
<a href="products/addProduct.jsp">Add Product</a>
<a href="products/deleteProduct.jsp">Delete Product</a>
<a href="products/updateProduct.jsp">Update Product</a>
<% } %>
<a href="${pageContext.request.contextPath}/logout">Logout</a>
</div>
<h2>Welcome, <%= user.getName() %>!</h2>
<form method="get" action="home">
<div class="category-select">
<label for="category">Filter by Category:</label>
<select name="category" id="category" onchange="this.form.submit()">
<option value="All" ${param.category==null||param.category=='All'?'selected':''}>All</option>
<c:forEach items="${categories}" var="cat">
<option value="${cat}" ${param.category==cat?'selected':''}>${cat}</option>
</c:forEach>
</select>
</div>
</form>
<c:if test="${not empty sessionScope.message}">
<p class="message">${sessionScope.message}</p>
<c:remove var="message" scope="session"/>
</c:if>
<c:if test="${not empty sessionScope.error}">
<p class="error">${sessionScope.error}</p>
<c:remove var="error" scope="session"/>
</c:if>
<div class="products-container">
<c:forEach items="${products}" var="p">
<c:if test="${param.category==null||param.category=='All'||param.category==p.category}">
<div class="product-card">
<img src="${pageContext.request.contextPath}/images/${p.imageUrl}" alt="${p.name}">
<h3>${p.name}</h3>
<p>Category: ${p.category}</p>
<p>Price: <fmt:formatNumber value="${p.price}" type="currency"/></p>
<a href="product?id=${p.id}">About</a>
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
</body>
</html>
