<html>
<body>

<h2>Checkout</h2>

<form action="${pageContext.request.contextPath}/orderitem" method="post">
    <input type="hidden" name="productId" value = "${product.id}">
    Address:<br>
    <textarea name="address" required></textarea><br><br>
    Payment Mode:
    <select name="paymentType">
        <option value="COD">Cash on Delivery</option>
        <option value="CARD">Card</option>
    </select><br><br>

    <button type="submit">Place Order</button>
</form>
</body>
</html>