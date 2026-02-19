<html>
<head>
    <title>Order Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e6ffed;
            color: #155724;
            text-align: center;
            padding: 50px;
        }

        h2 {
            color: #28a745;
            font-size: 28px;
            margin-bottom: 20px;
        }

        p {
            font-size: 18px;
            margin-bottom: 30px;
        }

        a {
            display: inline-block;
            margin: 10px 5px;
            padding: 10px 20px;
            background-color: #28a745;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
            transition: 0.2s ease;
        }

        a:hover {
            background-color: #218838;
        }

        .home-link {
            background-color: #007bff;
        }

        .home-link:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<a class="home-link" href="${pageContext.request.contextPath}/home">Home</a><br><br>

<h2>Order Placed Successfully</h2>
<p>Your order ID: ${orderId}</p>

<a href="${pageContext.request.contextPath}/orders">Go to Orders</a><br>
<a href="${pageContext.request.contextPath}/home">Continue Shopping</a>

</body>
</html>
