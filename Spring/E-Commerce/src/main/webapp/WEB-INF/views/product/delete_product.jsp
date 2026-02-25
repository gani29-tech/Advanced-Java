<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Product</title>
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
            max-width: 400px;
            margin: 30px auto;
        }
        label {
            font-weight: bold;
        }
        form input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-top: 4px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        form button {
            background-color: #e74c3c;
            color: white;
            padding: 10px 18px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        form button:hover {
            background-color: #c0392b;
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
    <h2>Delete Product</h2>

    <form:form method="POST" action="${pageContext.request.contextPath}/product/delete">
        <label for="name">Product Name:</label>
        <form:input path="name" id="name" placeholder="Enter product name" type="text"/>
        <button type="submit">Delete Product</button>
    </form:form>
</div>

</body>
</html>