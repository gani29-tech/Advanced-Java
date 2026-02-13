<form action="${pageContext.request.contextPath}/addProduct" method="post">
    Name:<input type="text" name="name" required><br><br>
    Price:<input type="number" name="price" required><br><br>
    Description:<input type="text" name="description" required><br><br>
    Category:<input type="text" name="category" required><br><br>
    ImageUrl:<input type="text" name="imageUrl" required><br><br>
    <button type="submit">Add Product</button>
</form>