import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ex5d extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String nickname = request.getParameter("nickname");

        HttpSession session = request.getSession(true);

        Integer loginCount = (Integer) session.getAttribute("loginCount");
        if (loginCount == null) {
            loginCount = 1; 
        } else {
            loginCount++; 
        }

        session.setAttribute("loginCount", loginCount);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head><meta charset='UTF-8'><title>Welcome</title></head>");
        out.println("<body>");
        out.println("<h2>Welcome!</h2>");
        out.println("<p>Hey " + name + " aka " + nickname + ", you have entered this page for the " + loginCount + "th time.</p>");
        out.println("</body></html>");
    }
}