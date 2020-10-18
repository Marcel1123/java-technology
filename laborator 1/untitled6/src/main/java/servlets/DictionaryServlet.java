package servlets;

import repository.WordRepository;
import util.ResponseSenderDictionaryServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DictionaryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        WordRepository wordRepository = new WordRepository();
        String userAgent = req.getHeader("user-agent");
        String letters = req.getParameter("letters");
        if(letters != null){
            if(userAgent.startsWith("Postman") || userAgent.startsWith("Python")){
                ResponseSenderDictionaryServlet.sendDoGetPostManResponse(response, wordRepository.getSpecificWords(letters));
            } else {
                ResponseSenderDictionaryServlet.sendDoGetBrowserResponse(response, wordRepository.getSpecificWords(letters));
            }
        } else {
            response.setStatus(400);
        }
    }
}
