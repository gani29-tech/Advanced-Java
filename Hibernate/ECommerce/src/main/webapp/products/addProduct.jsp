<html>
<head>
    <title>Add Product</title>
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
            max-width: 500px;
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

        input[type="text"],
        input[type="number"],
        input[type="file"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border-radius: 4px;
            border: 1px solid #ccc;
            font-size: 14px;
        }

        button {
            display: inline-block;
            background-color: #28a745;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: 0.2s ease;
        }

        button:hover {
            background-color: #218838;
        }

        .error-msg {
            color: red;
            text-align: center;
            font-weight: bold;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>

<a href="${pageContext.request.contextPath}/home">Home</a><br>

<c:if test="${not empty sessionScope.error}">
    <p class="error-msg">${sessionScope.error}</p>
    <c:remove var="error" scope="session"/>
</c:if>

<form action="${pageContext.request.contextPath}/addProduct" method="post" enctype="multipart/form-data">
    <h3>Enter Product Details</h3>

    <label for="name">Name:</label>
    <input type="text" name="name" id="name" required>

    <label for="price">Price:</label>
    <input type="number" name="price" id="price" required>

    <label for="description">Description:</label>
    <input type="text" name="description" id="description" required>

    <label for="category">Category:</label>
    <input type="text" name="category" id="category" required>

    <label for="imageUrl">Product Image:</label>
    <input type="file" name="imageUrl" id="imageUrl" accept="image/*">

    <button type="submit">Add Product</button>
</form>

</body>
</html>
