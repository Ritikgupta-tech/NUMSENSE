package nums;


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (Connection con = DBConnection.getConnection()) {

            if ("register".equals(action)) {
                PreparedStatement ps = con.prepareStatement("INSERT INTO users(username, password) VALUES (?, ?)");
                ps.setString(1, username);
                ps.setString(2, password);
                ps.executeUpdate();
                response.sendRedirect("login.jsp");

            } else if ("login".equals(action)) {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    HttpSession session = request.getSession();
                    session.setAttribute("userId", rs.getInt("id"));
                    session.setAttribute("username", username);
                    response.sendRedirect("index.html");
                } else {
                    response.sendRedirect("login.jsp?error=Invalid+credentials");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

