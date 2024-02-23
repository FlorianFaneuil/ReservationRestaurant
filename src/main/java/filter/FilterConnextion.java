package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class FilterConnextion extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		Boolean estConnecte = (Boolean) req.getSession().getAttribute("estConnecte");

		if (estConnecte != null && estConnecte) {
			
			chain.doFilter(request, response);
		} else {
			
			res.sendRedirect(req.getContextPath() + "/connexion");
		}
	}

	public void destroy() {
		// Destruction du filtre
	}

}
