<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h4>Reservation</h4>
<form:form action="submitForm" modelAttribute="res" method="post">
    Name: <form:input path="name"/>
    <form:errors path="name" cssStyle="color:red"/>
    <br><br>
    Age: <form:input path="age"/>
    <form:errors path="age" cssStyle="color:red"/>
    <br><br>
    <input type="submit" value="Submit">
</form:form>
