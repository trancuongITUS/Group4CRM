package cybersoft.java14.backend.crm.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import cybersoft.java14.backend.crm.util.UrlConst;

@WebServlet(name = "userServlet", urlPatterns = {
		UrlConst.USER,
		UrlConst.USER_LIST,
		UrlConst.USER_CREATE,
		UrlConst.USER_AUTHOR
})
public class UserServlet extends HttpServlet {
	
}
