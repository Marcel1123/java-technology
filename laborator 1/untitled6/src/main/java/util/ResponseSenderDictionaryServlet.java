package util;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ResponseSenderDictionaryServlet {
    public static void sendDoGetPostManResponse(HttpServletResponse response, List<String> wordList) throws IOException {
        response.setContentType("application/json");
        PrintWriter out = new PrintWriter(response.getWriter());

        Gson gson = new Gson();
        out.print(gson.toJson(wordList));
    }

    public static void sendDoGetBrowserResponse(HttpServletResponse response, List<String> wordList) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = new PrintWriter(response.getWriter());

        out.println("<html><head><style>table,\n" +
                "td {\n" +
                "    border: 1px solid #333;\n" +
                "}\n" +
                "\n" +
                "thead,\n" +
                "tfoot {\n" +
                "    background-color: #333;\n" +
                "    color: #fff;\n" +
                "}</style><title>Hello</title></head>");
        out.println("<body><table> <thead>\n" +
                "        <tr>\n" +
                "            <th>WORD</th>\n" +
                "        </tr>\n" +
                "    </thead><tbody>");
        for(String string : wordList){
            out.println("<tr><td>");
            out.println(string);
            out.println("</td></tr>");
        }
        out.println("</tbody></table></body></html>");
    }
}
