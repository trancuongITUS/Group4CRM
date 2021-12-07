package cybersoft.java14.backend.crm.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java14.backend.crm.model.Project;
import cybersoft.java14.backend.crm.model.User;
import cybersoft.java14.backend.crm.service.ProjectService;
import cybersoft.java14.backend.crm.service.UserService;
import cybersoft.java14.backend.crm.util.JspConst;
import cybersoft.java14.backend.crm.util.RollConst;
import cybersoft.java14.backend.crm.util.UrlConst;

@WebServlet(name = "projectServlet", urlPatterns = {
		UrlConst.PROJECT_LIST,
		UrlConst.PROJECT_ASSIGNMENT,
		UrlConst.PROJECT_CREATE,
		UrlConst.PROJECT_STATISTICS,
		UrlConst.PROJECT_DELETE,
		UrlConst.PROJECT_EDIT,
})
public class ProjectServlet extends HttpServlet {
	ProjectService projectService;
	UserService userService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		projectService = new ProjectService();
		userService = new UserService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		
		User user = (User) req.getSession().getAttribute("user");
		String rollName = user.getRole().getName();
		List<Project> projects = null;
		
		switch (rollName) {
		case RollConst.ADMIN:
			projects = projectService.getProjects();
			break;
		case RollConst.LEADER:
			projects = projectService.getProjectsByCreatedUser(String.valueOf(user.getId()));
		default:
			break;
		}
		
		switch (servletPath) {
		case UrlConst.PROJECT_LIST:
			req.setAttribute("projects", projects);
			req.getRequestDispatcher(JspConst.PROJECT_LIST).forward(req, resp);
			break;
		case UrlConst.PROJECT_CREATE:
			req.setAttribute("users", userService.getUsersNotEmployees());
			req.getRequestDispatcher(JspConst.PROJECT_CREATE).forward(req, resp);
			break;
		case UrlConst.PROJECT_EDIT:
			String idEdit = req.getParameter("id");
			req.setAttribute("project", projectService.getProjectById(idEdit));
			req.setAttribute("users", userService.getUsersNotEmployees());
			req.getRequestDispatcher(JspConst.PROJECT_EDIT).forward(req, resp);
			break;
		
		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		req.setCharacterEncoding("UTF-8");
		
		switch (servletPath) {
		case UrlConst.PROJECT_CREATE:
			Project project = new Project();
			project.setName(req.getParameter("project_name"));
			project.setDescription(req.getParameter("project_description"));
			project.setStart(LocalDate.parse(req.getParameter("start_at")));
			project.setEnd(LocalDate.parse(req.getParameter("end_at")));
			
			int user_id = Integer.parseInt(req.getParameter("created"));
			for (int i = 0; i < userService.getUsersNotEmployees().size(); ++i) {
				if (userService.getUsersNotEmployees().get(i).getId() == (user_id)) {
					project.setCreated(userService.getUsersNotEmployees().get(i));
					break;
				}
			}
			
			projectService.addProject(project);
			break;
			
		case UrlConst.PROJECT_DELETE:
			String[] selected = req.getParameterValues("chkSelected");
			int countRows = projectService.deleteProject(selected);
			System.out.println(countRows + " rows has been deleted!");
			break;
			
		case UrlConst.PROJECT_EDIT:
			Project newProject = new Project();
			String id = req.getParameter("id");
			newProject.setName(req.getParameter("project_name"));
			newProject.setDescription(req.getParameter("project_description"));
			newProject.setStart(LocalDate.parse(req.getParameter("start_at")));
			newProject.setEnd(LocalDate.parse(req.getParameter("end_at")));
			
			String newCreatedId = req.getParameter("created");
			for (int i = 0; i < userService.getUsersNotEmployees().size(); ++i) {
				if (userService.getUsersNotEmployees().get(i).getId() == (Integer.parseInt(newCreatedId))) {
					newProject.setCreated(userService.getUsersNotEmployees().get(i));
					break;
				}
			}
			
			if (projectService.updateProject(id, newProject)) {
				System.out.println("Update successfully!");
			} else {
				System.out.println("Error!");
			}
		
		
			
			break;
		default:
			break;
		}
		
		resp.sendRedirect(req.getContextPath() + UrlConst.PROJECT_LIST);
	}
}
