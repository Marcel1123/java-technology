package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InputFilter implements Filter {
    FilterConfig filterConfig;
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String language = request.getParameter("language");
        String word = request.getParameter("word");
        String definition = request.getParameter("definition");

        if(word == null || definition == null || word.isEmpty() || definition.isEmpty()){
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("pages/input.jsp");
        } if(language == null || language.isEmpty()) {
            request.setAttribute("language", this.filterConfig.getInitParameter("defaultLanguage"));
        } else {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = filterConfig;
    }

}
