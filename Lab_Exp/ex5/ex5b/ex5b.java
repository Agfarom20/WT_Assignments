import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/InstrumentInfoServlet")
public class ex5b extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String instrumentType = request.getParameter("instrument");
        PrintWriter out = response.getWriter();

        // Start HTML table
        StringBuilder htmlResponse = new StringBuilder();
        htmlResponse.append("<table class='table table-bordered table-striped'>")
                    .append("<thead><tr><th>Instrument</th><th>Type</th><th>Description</th></tr></thead>")
                    .append("<tbody>");

        // Append rows based on instrument type
        switch (instrumentType) {
            case "Guitar":
                htmlResponse.append(createRow("Acoustic Guitar", "String", "Popular for soft, melodious tunes"))
                            .append(createRow("Electric Guitar", "String", "Used in rock and jazz music"))
                            .append(createRow("Bass Guitar", "String", "Produces deep, low-pitched sound"));
                break;
            case "Piano":
                htmlResponse.append(createRow("Grand Piano", "Percussion", "Large and powerful in sound"))
                            .append(createRow("Upright Piano", "Percussion", "Compact and space-saving"))
                            .append(createRow("Digital Piano", "Electronic", "Modern and versatile instrument"));
                break;
            case "Violin":
                htmlResponse.append(createRow("Classical Violin", "String", "Used in orchestras and solo performances"))
                            .append(createRow("Electric Violin", "String", "Amplified for modern genres"))
                            .append(createRow("Baroque Violin", "String", "An early version of the modern violin"));
                break;
            case "Drums":
                htmlResponse.append(createRow("Snare Drum", "Percussion", "Sharp and crisp sound"))
                            .append(createRow("Bass Drum", "Percussion", "Produces deep, low-pitched beats"))
                            .append(createRow("Cymbals", "Percussion", "Creates loud crashing or shimmering sounds"));
                break;
            case "Flute":
                htmlResponse.append(createRow("Western Flute", "Wind", "Popular in orchestras and solo performances"))
                            .append(createRow("Indian Bansuri", "Wind", "A bamboo flute with a mellow tone"))
                            .append(createRow("Pan Flute", "Wind", "An ancient instrument with multiple pipes"));
                break;
            default:
                htmlResponse.append("<tr><td colspan='3'>No data available for this instrument type</td></tr>");
                break;
        }

        // End HTML table
        htmlResponse.append("</tbody></table>");
        out.write(htmlResponse.toString());
        out.close();
    }

    // Helper method to create a table row
    private String createRow(String name, String type, String description) {
        return "<tr><td>" + name + "</td><td>" + type + "</td><td>" + description + "</td></tr>";
    }
}
