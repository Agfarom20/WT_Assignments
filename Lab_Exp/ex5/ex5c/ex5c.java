import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ex5c extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = null;
        String ageStr = null;
        String method = "SESSION HANDLING";
        int age = 0;
        int birthYear = 0;

        // Check if session data is in cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    username = cookie.getValue();
                } else if ("age".equals(cookie.getName())) {
                    ageStr = cookie.getValue();
                } else if ("method".equals(cookie.getName())) {
                    method = cookie.getValue();
                }
            }
        }

        // Check if session data is in HttpSession
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (username == null) username = (String) session.getAttribute("username");
            if (ageStr == null) ageStr = (String) session.getAttribute("age");
        }

        // Check if session data is in URL parameters
        if (username == null) username = request.getParameter("username");
        if (ageStr == null) ageStr = request.getParameter("age");

        // Parse age and calculate birth year if age is provided
        if (ageStr != null) {
            try {
                age = Integer.parseInt(ageStr);
                int currentYear = 2024;  // Use the current year as needed
                birthYear = currentYear - age;
            } catch (NumberFormatException e) {
                ageStr = "Invalid age";
            }
        }

        // Print session data and method
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<p>" + method + "</p>");
        if (username != null && ageStr != null && birthYear != 0) {
            out.println("<p>Hi " + username + ". Your musical journey started in " + birthYear + ".</p>");
        } else {
            out.println("<p>No valid session data found.</p>");
        }
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
