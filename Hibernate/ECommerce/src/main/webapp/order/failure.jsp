<html>
<head>
    <title>Order Failed</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8d7da;
            color: #721c24;
            text-align: center;
            padding: 50px;
        }

        h2 {
            color: #721c24;
            font-size: 28px;
        }

        p {
            font-size: 18px;
        }

        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #f5c6cb;
            color: #721c24;
            border-radius: 5px;
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            background-color: #f1b0b7;
        }
    </style>
</head>
<body>

<a href="${pageContext.request.contextPath}/home">Home</a><br><br>

<h2>Order Failed</h2>
<p>Something went wrong. Please try again.</p>

<a href="../cart/cart.jsp">Back to Cart</a>

</body>
</html>
