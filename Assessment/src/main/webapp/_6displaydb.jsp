<%@ page import = "java.sql.*"%>
	<%
	try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	String url = "jdbc:postgresql://localhost:2010/student";
	String username = "postgres";
	String password = "root";
	try(Connection con = DriverManager.getConnection(url,username,password)){
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("Select * from StudentDetails");
	%>
	<table Border = "1">
	<tr><th>Id</th>
	<th>Name</th>
	</tr>
	<%while(rs.next()){%>
	<tr><td><%=rs.getString(1) %></td>
	<td><%=rs.getString(2) %></td>
	</tr>
	
	<%}
	}
	catch(Exception e){%>
	</table>
		<%=e.getMessage() %>
	<%} %>
	