<a href="${pageContext.request.contextPath}/home">Home</a><br><br>
<form action="${pageContext.request.contextPath}/deleteProduct" method="post">
    Enter Product Name:<input type="text" name="name" required><br><br>
    <button type="submit">Delete Product</button>
</form>