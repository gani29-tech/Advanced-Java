<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Product Details - Techouts Ecommerce</title>

    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', sans-serif;
        }

        body {
            background: linear-gradient(to right, #e3f2fd, #fce4ec);
            padding: 30px;
        }

        /* Header */
        .top-bar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 30px;
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
            transition: 0.3s;
        }

        .home-btn:hover {
            background: #1a252f;
        }

        /* Main Card */
        .product-container {
            max-width: 1000px;
            margin: auto;
            background: white;
            border-radius: 15px;
            padding: 30px;
            box-shadow: 0 8px 25px rgba(0,0,0,0.1);
            display: flex;
            gap: 40px;
        }

        /* Product Image */
        .product-image {
            flex: 1;
            text-align: center;
        }

        .product-image img {
            max-width: 100%;
            height: 350px;
            object-fit: contain;
        }

        /* Product Info */
        .product-info {
            flex: 1;
        }

        .product-info h2 {
            font-size: 28px;
            margin-bottom: 15px;
            color: #2c3e50;
        }

        .product-info p {
            margin-bottom: 12px;
            font-size: 16px;
            color: #555;
        }

        .price {
            font-size: 24px;
            font-weight: bold;
            color: #27ae60;
            margin: 15px 0;
        }

        /* Buttons */
        .buttons {
            margin-top: 20px;
        }

        .btn {
            display: inline-block;
            padding: 10px 20px;
            margin-right: 10px;
            border-radius: 6px;
            text-decoration: none;
            font-weight: 600;
            transition: 0.3s;
        }

        .btn-cart {
            background-color: #2980b9;
            color: white;
        }

        .btn-cart:hover {
            background-color: #1f6692;
        }

        .btn-buy {
            background-color: #27ae60;
            color: white;
        }

        .btn-buy:hover {
            background-color: #1e8449;
        }

        .btn-back {
            background-color: #7f8c8d;
            color: white;
            margin-top: 20px;
        }

        .btn-back:hover {
            background-color: #5f6a6a;
        }

        /* Responsive */
        @media (max-width: 768px) {
            .product-container {
                flex-direction: column;
                text-align: center;
            }

            .product-image img {
                height: 250px;
            }
        }
    </style>
</head>
<body>

<div class="top-bar">
    <div class="brand">Techouts Ecommerce</div>
    <a href="${pageContext.request.contextPath}/home" class="home-btn">Home</a>
</div>

<div class="product-container">

    <!-- Product Image -->
    <div class="product-image">
        <c:if test="${not empty product.image}">
            <img src="${pageContext.request.contextPath}/uploads/${product.image}"
                 alt="${product.name}" />
        </c:if>
    </div>

    <!-- Product Information -->
    <div class="product-info">
        <h2>${product.name}</h2>

        <p><strong>Category:</strong> ${product.category}</p>
        <p><strong>Description:</strong> ${product.description}</p>

        <div class="price">$${product.price}</div>

        <div class="buttons">
            <!-- Add to Cart -->
            <a href="${pageContext.request.contextPath}/cart/add/${product.id}"
               class="btn btn-cart">
               Add to Cart
            </a>

            <!-- Buy Now -->
            <a href="${pageContext.request.contextPath}/cart/buynow/${product.id}"
               class="btn btn-buy">
               Buy Now
            </a>
        </div>

        <br>
        <a href="${pageContext.request.contextPath}/product/list"
           class="btn btn-back">
           Back to Products
        </a>
    </div>

</div>

</body>
</html>