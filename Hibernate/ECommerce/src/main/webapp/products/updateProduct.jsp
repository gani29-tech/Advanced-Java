<html>
<head>
    <title>Update Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 40px;
            text-align: center;
        }

        a.home-link {
            display: inline-block;
            margin-bottom: 20px;
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
        }

        a.home-link:hover {
            text-decoration: underline;
        }

        form {
            background-color: #fff;
            padding: 25px;
            border-radius: 8px;
            max-width: 400px;
            margin: 0 auto;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
            text-align: left;
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

        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border-radius: 4px;
            border: 1px solid #ccc;
            font-size: 14px;
        }

        button {
            display: block;
            width: 100%;
            background-color: #ffc107;
            color: #333;
            padding: 10px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: 0.2s ease;
        }

        button:hover {
            background-color: #e0a800;
        }
    </style>
</head>
<body>

<a class="home-link" href="${pageContext.request.contextPath}/home">Home</a>

<h3>Update Product</h3>

<form action="${pageContext.request.contextPath}/updateProduct" method="post">
    <label for="name">Name:</label>
    <input type="text" name="name" id="name" required>

    <label for="price">Price:</label>
    <input type="number" name="price" id="price" required>

    <label for="description">Description:</label>
    <input type="text" name="description" id="description" required>

    <button type="submit">Update Product</button>
</form>

</body>
</html>
