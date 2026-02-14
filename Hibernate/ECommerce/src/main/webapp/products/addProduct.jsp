<a href="${pageContext.request.contextPath}/home">Home</a><br>
<c:if test="${not empty sessionScope.error}">
    <p style="color:red">${sessionScope.error}</p>
    <c:remove var="error" scope="session"/>
</c:if>
<form action="${pageContext.request.contextPath}/addProduct" method="post" enctype="multipart/form-data">
    <h3>Enter Product Details</h3>
    Name:<input type="text" name="name" required><br><br>
    Price:<input type="number" name="price" required><br><br>
    Description:<input type="text" name="description" required><br><br>
    Category:<input type="text" name="category" required><br><br>
    <input type="file" name="imageUrl" accept="image/*"><br><br>
    <button type="submit">Add Product</button>
</form>