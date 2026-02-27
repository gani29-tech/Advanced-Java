<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Product List - Techouts Ecommerce</title>
    <style>
        * { box-sizing: border-box; margin: 0; padding: 0; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; }
        body { background-color: #f3f6fb; color: #333; padding-bottom: 40px; }

        /* Top links / Header */
        .top-links { background-color: #2c3e50; padding: 15px 30px; display: flex; justify-content: center; flex-wrap: wrap; gap: 10px; }
        .top-links a { text-decoration: none; color: #ecf0f1; padding: 8px 15px; border-radius: 5px; font-weight: bold; transition: background 0.3s; }
        .top-links a:hover { background-color: #34495e; }

        h2 { text-align: center; margin: 30px 0 20px; color: #2c3e50; }

        /* Category filter */
        .category-filter { text-align: center; margin-bottom: 20px; }
        .category-filter a { display: inline-block; margin: 0 8px 8px 8px; padding: 6px 14px; text-decoration: none; border-radius: 5px; color: white; background-color: #6c7ae0; font-weight: bold; transition: background 0.3s; }
        .category-filter a.active, .category-filter a:hover { background-color: #34495e; }

        /* Product grid */
        .product-grid { display: grid; grid-template-columns: repeat(auto-fit, minmax(220px, 1fr)); gap: 20px; padding: 0 30px; }

        /* Product card */
        .product-card {
            background-color: #fff;
            border-radius: 8px;
            padding: 15px;
            text-align: center;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
            transition: transform 0.2s, box-shadow 0.2s;
            cursor: pointer;
        }
        .product-card:hover { transform: translateY(-5px); box-shadow: 0 5px 15px rgba(0,0,0,0.2); }
        .product-card img { max-width: 100%; height: 150px; object-fit: contain; margin-bottom: 10px; border-radius: 5px; }
        .product-card h3 { margin: 10px 0 5px; font-size: 18px; color: #34495e; }
        .product-card p { margin: 5px 0; color: #555; font-size: 14px; }

        /* Action buttons */
        .actions { margin-top: 10px; display: flex; justify-content: center; flex-wrap: wrap; gap: 5px; }
        .actions a { text-decoration: none; display: inline-block; padding: 6px 12px; font-size: 14px; border-radius: 4px; transition: background 0.3s; }
        .actions a[href*="/cart/add"] { background-color: #27ae60; color: white; }
        .actions a[href*="/cart/buynow"] { background-color: #e67e22; color: white; } /* Buy Now button */
        .actions a.admin { background-color: #e74c3c; color: white; }

        /* No products message */
        p { text-align: center; font-size: 16px; color: #555; margin-top: 30px; }

        /* Responsive adjustments */
        @media (max-width: 600px) {
            .product-card img { height: 120px; }
            .top-links { flex-direction: column; align-items: center; }
        }
    </style>
</head>
<body>

<h2>Product List</h2>

<!-- Top links / Header -->
<div class="top-links">
    <a href="${pageContext.request.contextPath}/home">Home</a>
    <a href="${pageContext.request.contextPath}/cart/show">Cart</a>
    <c:if test="${user.role=='ROLE_ADMIN'}">
        <a href="${pageContext.request.contextPath}/admin/add">Add Product</a>
    </c:if>
</div>

<!-- Category Filter -->
<div class="category-filter"><br>
    <h3>Categories</h3>
    <c:forEach var="cat" items="${categories}">
        <a href="${pageContext.request.contextPath}/product/list?category=${cat}" class="${selectedCategory == cat ? 'active' : ''}">${cat}</a>
    </c:forEach>
    <a href="${pageContext.request.contextPath}/product/list?category=All" class="${selectedCategory == 'All' ? 'active' : ''}">All</a>
</div>

<!-- Product Grid -->
<c:choose>
    <c:when test="${not empty products}">
        <div class="product-grid">
            <c:forEach var="product" items="${products}">
                <div class="product-card" onclick="window.location.href='${pageContext.request.contextPath}/product/details/${product.id}'">
                    <c:if test="${not empty product.image}">
                        <img src="${pageContext.request.contextPath}/uploads/${product.image}" alt="${product.name}"/>
                    </c:if>
                    <h3>${product.name}</h3>
                    <p>Category: ${product.category}</p>
                    <p>Price: $${product.price}</p>
                    <div class="actions">
                        <a href="${pageContext.request.contextPath}/cart/add/${product.id}">Add to Cart</a>
                        <a href="${pageContext.request.contextPath}/cart/buynow/${product.id}">Buy Now</a>
                        <c:if test="${user.role=='ROLE_ADMIN'}">
                            <a href="${pageContext.request.contextPath}/admin/update/${product.id}" class="admin">Update</a>
                            <a href="${pageContext.request.contextPath}/admin/delete/${product.id}" class="admin"
                               onclick="return confirm('Are you sure?')">Delete</a>
                        </c:if>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:when>
    <c:otherwise>
        <p>No products available.</p>
    </c:otherwise>
</c:choose>

</body>
</html>