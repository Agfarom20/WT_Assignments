import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ex5a extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Generate the musical-themed response
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Music Vibes</title>");
        out.println("<style>");
        out.println("body {");
        out.println("    font-family: Arial, sans-serif;");
        out.println("    background-color: #1e1e2f;");
        out.println("    color: #ffffff;");
        out.println("    text-align: center;");
        out.println("    padding: 20px;");
        out.println("}");
        out.println("h1 {");
        out.println("    font-size: 2.5em;");
        out.println("    color: #ff6b6b;");
        out.println("}");
        out.println("p {");
        out.println("    font-size: 1.5em;");
        out.println("    color: #1e90ff;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Welcome to Music Vibes!</h1>");
        out.println("<p>Your servlet is playing the right notes!</p>");
        out.println("<img src='https://example.com/music-notes.gif' alt='Music Notes' style='width: 300px; margin-top: 20px;'>");
        out.println("</body>");
        out.println("</html>");
    }
}
