<html>
<body>
 
<h2>Checkout</h2>
 
<form action="${pageContext.request.contextPath}/checkout" method="post">
    Address:<br>
    <textarea name="address" required></textarea><br><br>
    Payment Mode:
    <select name="payment">
        <option value="COD">Cash on Delivery</option>
        <option value="CARD">Card</option>
    </select><br><br>
 
    <button type="submit">Place Order</button>
</form>
 
</body>
</html>