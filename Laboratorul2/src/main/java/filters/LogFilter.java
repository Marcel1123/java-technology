package filters;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "LogFilter", urlPatterns = {"/input", "/result"})
public class LogFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        Log log = LogFactory.getLog(this.getClass());
        log.debug("Input filter...");
        System.out.println("Input filter");

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
    }

}
