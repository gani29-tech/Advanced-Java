<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Checkout - Techouts Ecommerce</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            margin: 0;
            padding: 30px;
            background: linear-gradient(to right, #e3f2fd, #fce4ec);
        }

        .container {
            max-width: 1100px;
            margin: auto;
            background: #ffffff;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 6px 18px rgba(0,0,0,0.1);
        }

        .top-bar {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .brand {
            font-size: 22px;
            font-weight: bold;
            color: #2c3e50;
        }

        .home-btn {
            background: #2c3e50;
            color: white;
            padding: 8px 15px;
            text-decoration: none;
            border-radius: 6px;
        }

        .home-btn:hover {
            background: #1a252f;
        }

        h2 {
            margin-top: 20px;
            color: #34495e;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            text-align: center;
        }

        th {
            background: #2c3e50;
            color: white;
        }

        tr:nth-child(even) {
            background: #f2f2f2;
        }

        .section {
            margin-top: 30px;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            font-weight: 600;
            display: block;
            margin-bottom: 5px;
        }

        input, textarea, select {
            width: 100%;
            padding: 8px;
            border-radius: 6px;
            border: 1px solid #ccc;
        }

        textarea {
            resize: none;
        }

        .total-box {
            text-align: right;
            font-size: 20px;
            font-weight: bold;
            margin-top: 20px;
            color: #27ae60;
        }

        .btn-confirm {
            background-color: #27ae60;
            color: white;
            padding: 12px 25px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            margin-top: 20px;
            font-size: 16px;
        }

        .btn-confirm:hover {
            background-color: #1e8449;
        }

        .empty-cart {
            text-align: center;
            font-size: 18px;
            margin-top: 30px;
            color: #555;
        }
    </style>
</head>
<body>

<div class="container">

    <div class="top-bar">
        <div class="brand">Techouts Ecommerce</div>
        <a href="${pageContext.request.contextPath}/home" class="home-btn">Home</a>
    </div>

    <h2>Checkout</h2>

    <c:if test="${not empty cart.cartItems}">

        <!-- Order Summary -->
        <table>
            <tr>
                <th>Product</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Total</th>
            </tr>

            <c:set var="total" value="0" />
            <c:forEach var="item" items="${cart.cartItems}">
                <tr>
                    <td>${item.product.name}</td>
                    <td>${item.quantity}</td>
                    <td>$${item.product.price}</td>
                    <td>$${item.quantity * item.product.price}</td>
                </tr>
                <c:set var="total" value="${total + (item.quantity * item.product.price)}" />
            </c:forEach>
        </table>

        <div class="total-box">
            Total Amount: $${total}
        </div>

        <!-- Address & Payment Form -->
        <form action="${pageContext.request.contextPath}/cart/checkout" method="post">

            <div class="section">
                <h3>Shipping Address</h3>

                <div class="form-group">
                    <label>Full Address</label>
                    <textarea name="address" rows="3" required></textarea>
                </div>

                <div class="form-group">
                    <label>City</label>
                    <input type="text" name="city" required/>
                </div>

                <div class="form-group">
                    <label>State</label>
                    <input type="text" name="state" required/>
                </div>

                <div class="form-group">
                    <label>Pincode</label>
                    <input type="text" name="pincode" required/>
                </div>
            </div>

            <div class="section">
                <h3>Payment Method</h3>

                <div class="form-group">
                    <select name="paymentType" required>
                        <option value="">-- Select Payment Type --</option>
                        <option value="COD">Cash On Delivery</option>
                        <option value="UPI">UPI</option>
                        <option value="CARD">Credit / Debit Card</option>
                    </select>
                </div>
            </div>

            <button type="submit" class="btn-confirm">Confirm Order</button>

        </form>

    </c:if>

    <c:if test="${empty cart.cartItems}">
        <div class="empty-cart">
            Your cart is empty. Please add products before checking out.
        </div>
    </c:if>

</div>

</body>
</html>