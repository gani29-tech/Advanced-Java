<c:if test="${not empty cart.cartItems}">
    <table>
        <tr>
            <th>Product</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
            <th>Action</th>
        </tr>
        <c:forEach var="item" items="${cart.cartItems}">
            <tr>
                <td>${item.product.name}</td>
                <td>${item.product.price}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/cart/update/${item.id}" method="post">
                        <input type="number" name="quantity" value="${item.quantity}" min="1"/>
                        <button type="submit">Update</button>
                    </form>
                </td>
                <td>${item.product.price * item.quantity}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/cart/remove/${item.id}" method="post">
                        <button type="submit">Remove</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form action="${pageContext.request.contextPath}/cart/checkout" method="post">
        <button type="submit">Checkout</button>
    </form>
</c:if>
<c:if test="${empty cart.cartItems}">
    <p>Your cart is empty.</p>
</c:if>