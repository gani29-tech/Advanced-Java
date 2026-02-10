<form action="${pageContext.request.contextPath}/updateProduct" method="post">
    Name:<input type="text" name="name" required><br><br>
    Price:<input type="number" name="price" required><br><br>
    Description:<input type="text" name="description" required><br><br>
    ImageUrl:<input type="text" name="imageUrl" required><br><br>
    <button type="submit">Update Product</button>
</form>