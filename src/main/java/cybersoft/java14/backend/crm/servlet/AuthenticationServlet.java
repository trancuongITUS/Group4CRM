package cybersoft.java14.backend.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java14.backend.crm.util.JspConst;
import cybersoft.java14.backend.crm.util.UrlConst;

@WebServlet(name = "authServlet", urlPatterns = {
		UrlConst.SIGN_IN,
		UrlConst.SIGN_UP
})
public class AuthenticationServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		
		switch (servletPath) {
		case UrlConst.SIGN_IN:
			req.getRequestDispatcher(JspConst.SIGN_IN).forward(req, resp);
			break;
		case UrlConst.SIGN_UP:
			req.getRequestDispatcher(JspConst.SIGN_UP).forward(req, resp);
			break;
		default:
			break;
		}
	}
}
