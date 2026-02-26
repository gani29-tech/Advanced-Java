<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Product Details</title>
</head>
<body>

<h2>Product Details</h2>
    <c:if test="${not empty product.image}">
        <img src="${pageContext.request.contextPath}/uploads/${product.image}" width="300" />
    </c:if>
<p><strong>Name:</strong> ${product.name}</p>
<p><strong>Description:</strong> ${product.description}</p>
<p><strong>Category:</strong> ${product.category}</p>
<p><strong>Price:</strong> ${product.price}</p>

<p><a href="${pageContext.request.contextPath}/product/list">Back to List</a></p>

</body>
</html>