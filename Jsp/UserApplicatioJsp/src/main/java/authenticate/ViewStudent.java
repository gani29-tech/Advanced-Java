package authenticate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewStudent")
public class ViewStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "jdbc:postgresql://localhost:2010/student";
        String dbUsername = "postgres";
        String dbPassword = "root";

        List<HashMap<String, String>> students = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
             PreparedStatement ps = con.prepareStatement("SELECT * FROM StudentDetails");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                HashMap<String, String> stu = new HashMap<>();
                stu.put("id", rs.getString("id"));
                stu.put("name", rs.getString("name"));
                students.add(stu);
            }

        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }

        request.setAttribute("students", students);
        request.getRequestDispatcher("ViewStudent.jsp").forward(request, response);
    }
}
