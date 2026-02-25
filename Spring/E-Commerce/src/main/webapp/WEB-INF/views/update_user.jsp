<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Profile</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        h2 { margin-bottom: 20px; }
        label { display: block; margin-top: 10px; }
        input, textarea { width: 300px; padding: 5px; margin-top: 5px; }
        button { margin-top: 15px; padding: 8px 15px; }
    </style>
</head>
<body>
    <h2>Update Profile</h2>

    <form:form method="POST" action="/user/update" modelAttribute="user">
        <form:hidden path="id"/>
        <label for="username">Username:</label>
        <form:input path="username" id="username" placeholder="Enter username"/>
        <label for="password">Password:</label>
        <form:password path="password" id="password" placeholder="Enter password"/>
        <label for="email">Email:</label>
        <form:input path="email" id="email" placeholder="Enter email"/>
        <label for="phone">Phone:</label>
        <form:input path="phone" id="phone" placeholder="Enter phone number"/>
        <label for="address">Address:</label>
        <form:textarea path="address" id="address" placeholder="Enter address" rows="4"/>
        <button type="submit">Update Profile</button>
    </form:form>

</body>
</html>