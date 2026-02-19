<html>
<head>
    <title>Checkout</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f5f5f5;
        }

        h2 {
            color: #333;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 6px;
            width: 400px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        textarea {
            width: 100%;
            height: 80px;
            padding: 8px;
            border-radius: 4px;
            border: 1px solid #ccc;
            resize: vertical;
            font-size: 14px;
        }

        select, button {
            padding: 8px 12px;
            border-radius: 4px;
            font-size: 14px;
        }

        select {
            width: 100%;
            margin-top: 5px;
            margin-bottom: 15px;
        }

        button {
            background-color: #28a745;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #218838;
        }

        label {
            font-weight: bold;
        }
    </style>
</head>
<body>

<h2>Checkout</h2>

<form action="${pageContext.request.contextPath}/checkout" method="post">
    <label for="address">Address:</label><br>
    <textarea id="address" name="address" required></textarea><br>

    <label for="paymentType">Payment Mode:</label><br>
    <select id="paymentType" name="paymentType">
        <option value="COD">Cash on Delivery</option>
        <option value="CARD">Card</option>
    </select><br>

    <button type="submit">Place Order</button>
</form>

</body>
</html>
