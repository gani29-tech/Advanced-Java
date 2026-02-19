<html>
<head>
    <title>Delete Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 40px;
        }

        a {
            display: inline-block;
            margin-bottom: 20px;
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }

        form {
            background-color: #fff;
            padding: 25px;
            border-radius: 8px;
            max-width: 400px;
            margin: 0 auto;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
        }

        h3 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border-radius: 4px;
            border: 1px solid #ccc;
            font-size: 14px;
        }

        button {
            display: inline-block;
            background-color: #dc3545;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: 0.2s ease;
        }

        button:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>

<a href="${pageContext.request.contextPath}/home">Home</a><br><br>

<form action="${pageContext.request.contextPath}/deleteProduct" method="post">
    <h3>Delete Product</h3>

    <label for="name">Enter Product Name:</label>
    <input type="text" name="name" id="name" required>

    <button type="submit">Delete Product</button>
</form>

</body>
</html>
