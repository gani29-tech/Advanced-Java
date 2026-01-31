<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String name = (String)request.getAttribute("username");%>
<%if(name!=null){%>Hello <%=name%><%}%>
<%if(name==null){%><form action="ForwardRequest">
<label>Enter Name: </label>
<input type = "text" name = "name">
<input type = "submit" value ="Enter">
</form>
<%}%>