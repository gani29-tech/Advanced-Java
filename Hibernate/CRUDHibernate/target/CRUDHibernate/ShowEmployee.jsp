<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.techouts.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
    <style>
        table { border-collapse: collapse; width: 60%; margin: 20px auto; }
        th, td { border: 1px solid #333; padding: 8px; text-align: center; }
        th { background-color: #f2f2f2; }
        a { margin: 0 5px; }
    </style>
</head>
<body>
    <h2 style="text-align:center;">Employee List</h2>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Salary</th>
            <th>Actions</th>
        </tr>

        <%
            List<Employee> employees = (List<Employee>) request.getAttribute("employees");
            if (employees != null) {
                for (Employee e : employees) {
        %>
        <tr>
            <td><%= e.getId() %></td>
            <td><%= e.getName() %></td>
            <td><%= e.getSalary() %></td>
            <td>
                <a href="EditEmployee?id=<%= e.getId() %>">Edit</a>
                <form action="RemoveEmployee" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="<%= e.getId() %>"/>
                    <button type="submit" onclick="return confirm('Are you sure?')">Delete</button>
                </form>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>

    <div style="text-align:center;">
        <a href="AddEmployee.jsp">Add New Employee</a>
    </div>
</body>
</html>
