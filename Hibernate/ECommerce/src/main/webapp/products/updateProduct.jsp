<a href="${pageContext.request.contextPath}/home">Home</a><br>
<h3>Update Product</h3>
<form action="${pageContext.request.contextPath}/updateProduct" method="post">
    Name:<input type="text" name="name" required><br><br>
    Price:<input type="number" name="price" required><br><br>
    Description:<input type="text" name="description" required><br><br>
    <button type="submit">Update Product</button>
</form>