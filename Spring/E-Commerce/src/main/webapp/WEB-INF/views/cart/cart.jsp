<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
    body {
        font-family: Arial, sans-serif;
        margin: 40px;
        background-color: #f9f9f9;
        color: #333;
    }
    h2 {
        text-align: center;
        color: #222;
    }
    table {
        width: 90%;
        margin: 20px auto;
        border-collapse: collapse;
        box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        background-color: white;
        border-radius: 8px;
        overflow: hidden;
    }
    th, td {
        padding: 12px 15px;
        text-align: center;
        border-bottom: 1px solid #ddd;
        vertical-align: middle;
    }
    th {
        background-color: #007bff;
        color: white;
        font-weight: bold;
    }
    tr:hover {
        background-color: #f1f7ff;
    }
    img.product-image {
        width: 60px;
        height: 60px;
        object-fit: contain;
        border-radius: 5px;
    }
    button {
        background-color: #28a745;
        color: white;
        border: none;
        padding: 8px 14px;
        border-radius: 5px;
        cursor: pointer;
        font-size: 14px;
        transition: background-color 0.3s ease;
    }
    button:hover {
        background-color: #218838;
    }
    form {
        margin: 0;
    }
    input[type="number"] {
        width: 60px;
        padding: 6px;
        font-size: 14px;
        border: 1px solid #ccc;
        border-radius: 5px;
        text-align: center;
    }
    .total-price {
        width: 90%;
        margin: 30px auto;
        font-size: 20px;
        font-weight: bold;
        text-align: right;
        color: #007bff;
    }
    .home-button {
        display: block;
        width: 100px;
        margin: 0 auto 20px auto;
        padding: 10px 0;
        text-align: center;
        background-color: #007bff;
        color: white;
        text-decoration: none;
        border-radius: 6px;
        font-weight: bold;
        box-shadow: 0 3px 6px rgba(0,0,0,0.2);
        transition: background-color 0.3s ease;
    }
    .home-button:hover {
        background-color: #0056b3;
    }
</style>

<a href="${pageContext.request.contextPath}/home" class="home-button">Home</a>

<h2>Your Cart</h2>

<c:if test="${not empty cart.cartItems}">
    <table>
        <thead>
        <tr>
            <th>Product</th>
            <th>Image</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${cart.cartItems}">
            <tr>
                <td>${item.product.name}</td>
                 <td>
                    <c:if test="${not empty item.product.image}">
                        <img src="${pageContext.request.contextPath}/uploads/${item.product.image}" alt="${item.product.name}" class="product-image"/>
                    </c:if>
                 </td>
                <td>$${item.product.price}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/cart/update/${item.id}" method="post">
                        <input type="number" name="quantity" value="${item.quantity}" min="1" required />
                        <button type="submit">Update</button>
                    </form>
                </td>
                <td>$${item.product.price * item.quantity}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/cart/remove/${item.id}" method="post">
                        <button type="submit">Remove</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="total-price">
        Total Price: $${cart.totalPrice}
    </div>

    <form action="${pageContext.request.contextPath}/cart/checkout" style="text-align: center;">
        <button type="submit" style="width: 150px; font-size: 16px;">Checkout</button>
    </form>
</c:if>

<c:if test="${empty cart.cartItems}">
    <p style="text-align: center; font-size: 18px; margin-top: 40px;">Your cart is empty.</p>
</c:if>