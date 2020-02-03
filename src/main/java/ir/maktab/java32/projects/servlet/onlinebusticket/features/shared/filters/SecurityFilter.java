package ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "SecurityFilter", urlPatterns = {"/secured/*"})
public class SecurityFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        if (request.getSession() != null && request.getSession().getAttribute("user_data") != null) {
            chain.doFilter(req, resp);
        } else {
            response.sendRedirect("view/login/login.html");
        }

    }

    public void init(FilterConfig config) throws ServletException {
    }

}
