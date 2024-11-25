import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ex5chiddenform extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        // Generate HTML with hidden fields to retain session information for musician
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Musical Instrument Session with Hidden Form Fields</h2>");
        out.println("<form action='ex5c' method='POST'>");
        out.println("<input type='hidden' name='username' value='" + username + "'>");
        out.println("<input type='hidden' name='age' value='" + age + "'>");
        out.println("<input type='submit' value='Continue'>");
        out.println("</form>");
        out.println("</body></html>");
    }
}
