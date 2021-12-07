package cybersoft.java14.backend.crm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java14.backend.crm.util.UrlConst;

@WebFilter(urlPatterns = {
		UrlConst.ROOT
})
public class AuthenticationFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		boolean isAuthed = req.getSession().getAttribute("isAuthenticated") != null ? true : false;
		
		if (isAuthed) {
			chain.doFilter(req, resp);
		} else if (UrlConst.SIGN_IN.equals(req.getServletPath())) {
			chain.doFilter(request, response);
		} else {
			resp.sendRedirect(req.getContextPath() + UrlConst.SIGN_IN);
		}
	}
}
