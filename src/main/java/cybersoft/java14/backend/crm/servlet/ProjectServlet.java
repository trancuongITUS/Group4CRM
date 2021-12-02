package cybersoft.java14.backend.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java14.backend.crm.model.Project;
import cybersoft.java14.backend.crm.service.ProjectService;
import cybersoft.java14.backend.crm.util.JspConst;
import cybersoft.java14.backend.crm.util.UrlConst;

@WebServlet(name = "projectServlet", urlPatterns = {
		UrlConst.PROJECT,
		UrlConst.PROJECT_ASSIGNMENT,
		UrlConst.PROJECT_CREATE,
		UrlConst.PROJECT_MANAGE,
		UrlConst.PROJECT_STATISTICS,
		UrlConst.PROJECT_REMOVE
})
public class ProjectServlet extends HttpServlet {
	/*
	 * Servlet của anh cũng k có cái service để get data ... em mới thêm dô
	 */
	ProjectService service;
	
	@Override
	public void init() throws ServletException {
		super.init();
		service = new ProjectService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
	
		switch (path)
		{
		case UrlConst.PROJECT_MANAGE:
			req.setAttribute("projects", service.getProjects()); // chỗ này nãy anh cũng k setAttribute thì bên jsp a k get ra được đâu
			req.getRequestDispatcher("/WEB-INF/views/project/projectmanage.jsp")
			.forward(req, resp);
			break;
		case UrlConst.PROJECT_REMOVE:
			String deleteId = req.getParameter("id");
			service.removeProject(deleteId);
			resp.sendRedirect(req.getContextPath() + UrlConst.PROJECT_MANAGE);
			break;
		case UrlConst.PROJECT_CREATE:
			req.getRequestDispatcher(JspConst.PROJECT_CREATE).forward(req, resp);
		
		//Chỗ này chưa là của bện ProjectCreate
//		case UrlConst.PROJECT_ADD:
//			String addProject = req.
//			service.addProject(Project);
		default:
			break;
		}
	}
}
