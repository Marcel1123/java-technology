package servlets;

import entities.Word;
import exceptions.DefinitionException;
import exceptions.LanguageException;
import exceptions.WordException;
import lombok.SneakyThrows;
import repositories.WordRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "InputServlet", urlPatterns = "/input", asyncSupported = true)
public class InputServlet extends HttpServlet {
    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String language = request.getParameter("language");
        String word = request.getParameter("word");
        String definition = request.getParameter("definition");

        try {
            UUID languageId = UUID.fromString(language);

            Word word1 = new WordRepository().addWord(languageId, word, definition);

            Cookie cookie = new Cookie("language", language);
            cookie.setMaxAge(60*60*24);
            response.addCookie(cookie);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/result.jsp");
            request.setAttribute("savedWord", word1);
            requestDispatcher.include(request, response);
        } catch (IllegalArgumentException e){
            throw new LanguageException("Language is invalid");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
