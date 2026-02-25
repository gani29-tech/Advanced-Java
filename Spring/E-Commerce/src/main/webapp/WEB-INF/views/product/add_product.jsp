<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            padding: 0;
            margin: 0;
        }
        /* Header styling */
        .header {
            background-color: #007BFF;
            color: white;
            padding: 10px 20px;
        }
        .header h1 {
            display: inline;
            margin: 0;
            font-size: 24px;
        }
        .header .nav {
            float: right;
        }
        .header .nav a {
            color: white;
            text-decoration: none;
            margin-left: 15px;
            font-weight: bold;
        }
        .header .nav a:hover {
            text-decoration: underline;
        }
        .form-container {
            background-color: #fff;
            padding: 20px 30px;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
            max-width: 500px;
            margin: 30px auto;
        }
        label {
            font-weight: bold;
        }
        form input[type="text"],
        form input[type="number"],
        form textarea,
        form input[type="file"] {
            width: 100%;
            padding: 8px;
            margin-top: 4px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        form button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 18px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        form button:hover {
            background-color: #45a049;
        }
        .error-message {
            color: red;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>

<!-- Common Header -->
<div class="header">
    <h1>My Product App</h1>
    <div class="nav">
        <a href="${pageContext.request.contextPath}/">Home</a>
        <a href="${pageContext.request.contextPath}/product/list">Product List</a>
    </div>
    <div style="clear:both;"></div>
</div>

<div class="form-container">
    <h2>Add Product</h2>

    <c:if test="${not empty error}">
        <div class="error-message">
            ${error}
        </div>
    </c:if>

    <form:form method="POST" action="${pageContext.request.contextPath}/product/add" modelAttribute="product" enctype="multipart/form-data">

        <label>Name:</label>
        <form:input path="name"/>

        <label>Description:</label>
        <form:textarea path="description" rows="4" cols="40"/>

        <label>Price:</label>
        <form:input path="price" type="number" step="0.01"/>

        <label>Category:</label>
        <form:input path="category" type="text"/>

        <label>Image:</label>
        <input type="file" name="imageFile"/>

        <button type="submit">Add Product</button>
    </form:form>
</div>

</body>
</html>