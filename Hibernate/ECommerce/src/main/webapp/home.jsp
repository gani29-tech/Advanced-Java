<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*, com.techouts.entities.Product" %>
 
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
</head>
<body>

<%
    String user = (String) request.getSession().getAttribute("user");
%>

<p>Welcome, <%= user %>!</p>
<c:if test="${not empty message}">
<p style="color:green">${message}</p>
</c:if>
<% if ("gani".equals(user)) { %>
    <a href="products/addProduct.jsp">Add Product</a><br>
    <a href="products/deleteProduct.jsp">Delete Product</a><br>
    <a href="products/updateProduct.jsp">Update Product</a><br>
<% } %>
<a href="${pageContext.request.contextPath}/products">Products</a><br><br>
<a href="cart/cart.jsp">View Cart</a><br><br>
<a href="${pageContext.request.contextPath}/logout">Logout</a>
</body>
</html>