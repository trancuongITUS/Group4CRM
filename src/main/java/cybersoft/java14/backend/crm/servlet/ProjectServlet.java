package cybersoft.java14.backend.crm.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import cybersoft.java14.backend.crm.util.UrlConst;

@WebServlet(name = "projectServlet", urlPatterns = {
		UrlConst.PROJECT,
		UrlConst.PROJECT_ASSIGNMENT,
		UrlConst.PROJECT_CREATE,
		UrlConst.PROJECT_MANAGE,
		UrlConst.PROJECT_STATISTICS
})
public class ProjectServlet extends HttpServlet {

}
