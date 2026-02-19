<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>${product.name}</title>
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

        h2 {
            color: #333;
            margin-bottom: 10px;
        }

        p {
            font-size: 16px;
            margin: 5px 0;
        }

        img {
            max-width: 300px;
            height: auto;
            margin: 15px 0;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        }

        form {
            margin-top: 20px;
        }

        input[type="number"] {
            padding: 6px;
            width: 60px;
            border-radius: 4px;
            border: 1px solid #ccc;
            font-size: 14px;
            text-align: center;
        }

        button {
            background-color: #28a745;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            margin-top: 10px;
            transition: 0.2s ease;
        }

        button:hover {
            background-color: #218838;
        }

        a.buy-now {
            display: inline-block;
            margin-top: 10px;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
        }

        a.buy-now:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<a class="home-link" href="${pageContext.request.contextPath}/home">Home</a><br>

<h2>${product.name}</h2>
<p>Price: ₹${product.price}</p>
<p>Description: ${product.description}</p>

<img src="${pageContext.request.contextPath}/images/${product.imageUrl}" alt="${product.name}" />

<form action="${pageContext.request.contextPath}/addcart" method="post">
    <input type="hidden" name="productId" value="${product.id}">

    <label for="quantity">Quantity:</label>
    <input type="number" name="quantity" id="quantity" value="1" min="1"><br><br>

    <button type="submit">Add to Cart</button><br><br>

    <a class="buy-now" href="${pageContext.request.contextPath}/orderitem?productId=${product.id}">Buy Now</a>
</form>

</body>
</html>
