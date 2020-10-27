package servlets;


import repositories.PopulateDataBaseRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DBServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        PopulateDataBaseRepository repository = new PopulateDataBaseRepository();
        repository.populateLanguage();
        repository.populateWords();
    }
}
