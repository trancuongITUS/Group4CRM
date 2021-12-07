package cybersoft.java14.backend.crm.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java14.backend.crm.model.Project;
import cybersoft.java14.backend.crm.model.Task;
import cybersoft.java14.backend.crm.model.User;
import cybersoft.java14.backend.crm.service.ProjectService;
import cybersoft.java14.backend.crm.service.StatusService;
import cybersoft.java14.backend.crm.service.TaskService;
import cybersoft.java14.backend.crm.service.UserService;
import cybersoft.java14.backend.crm.util.JspConst;
import cybersoft.java14.backend.crm.util.UrlConst;

@WebServlet(name = "projectEmpServlet", urlPatterns = {
		UrlConst.PROJECT_DETAIL,
		UrlConst.PROJECT_EMPS_ADD,
		UrlConst.PROJECT_EMPS_DELETE,
		UrlConst.PROJECT_TASK_CREATE,
		UrlConst.PROJECT_TASK_DELETE,
		UrlConst.PROJECT_TASK_EDIT,
})
public class ProjectDetailServlet extends HttpServlet {
	ProjectService projectService;
	UserService userService;
	TaskService taskService;
	StatusService statusService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		projectService = new ProjectService();
		userService = new UserService();
		taskService = new TaskService();
		statusService = new StatusService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		
		switch (servletPath) {
		case UrlConst.PROJECT_DETAIL:
			String projectIdDetail = req.getParameter("id");
			
			req.setAttribute("project", projectService.getProjectById(projectIdDetail));
			req.setAttribute("employees", userService.getEmployeesFromProject(projectIdDetail));
			req.setAttribute("employeesNotInProject", userService.getEmployeesNotInProject(projectIdDetail));
			req.setAttribute("tasks", taskService.getTasksFromProject(projectIdDetail));
			
			req.getRequestDispatcher(JspConst.PROJECT_DETAIL).forward(req, resp);
			break;
			
		case UrlConst.PROJECT_TASK_CREATE:
			String projectIdCreateTask = req.getParameter("project_id");
			
			req.setAttribute("project", projectService.getProjectById(projectIdCreateTask));
			req.setAttribute("employees", userService.getEmployeesFromProject(projectIdCreateTask));
			req.setAttribute("status", statusService.getStatusList());
			
			req.getRequestDispatcher(JspConst.PROJECT_TASK_CREATE).forward(req, resp);
			break;
			
		case UrlConst.PROJECT_TASK_EDIT:
			String taskId = req.getParameter("id");
			String projectIdEditTask = req.getParameter("project_id");
			
			req.setAttribute("project", projectService.getProjectById(taskId));
			req.setAttribute("employees", userService.getEmployeesFromProject(projectIdEditTask));
			req.setAttribute("status", statusService.getStatusList());
			req.setAttribute("task", taskService.getTaskById(taskId));
			
			req.getRequestDispatcher(JspConst.PROJECT_TASK_EDIT).forward(req, resp);
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
		case UrlConst.PROJECT_EMPS_ADD:
			String empIdAdd = req.getParameter("emps");
			String projectIdAdd = req.getParameter("project_id");
			projectService.addEmployeeToProject(projectIdAdd, empIdAdd);
			
		case UrlConst.PROJECT_EMPS_DELETE:
			String projectIdDeleteEmp = req.getParameter("project_id");
			String[] empsIds = req.getParameterValues("chkSelected");
			int countRows = projectService.deleteEmployeeFromProject(projectIdDeleteEmp, empsIds);
			System.out.println(countRows + " rows has been deleted!");
			break;
			
		case UrlConst.PROJECT_TASK_CREATE:
			Task task = new Task();
			
			task.setName(req.getParameter("task_name"));
			task.setDescription(req.getParameter("task_description"));
			task.setStart(LocalDate.parse(req.getParameter("start_at")));
			task.setEnd(LocalDate.parse(req.getParameter("end_at")));
			
			String projectId = req.getParameter("project_id");
			String assigneeEmail = req.getParameter("assignee");
			int statusId = Integer.parseInt(req.getParameter("status"));
			
			task.setAssignee(userService.getUserByEmail(assigneeEmail));
			task.setProject(projectService.getProjectById(projectId));
			task.setStatus(statusService.getStatusById(String.valueOf(statusId)));
			
			taskService.createNewTaskToProject(projectId, task);
			break;
			
		case UrlConst.PROJECT_TASK_DELETE:
			String projectIdDeleteTask = req.getParameter("project_id");
			String[] taskIds = req.getParameterValues("chkSelected");
			taskService.deleteTaskFromProject(projectIdDeleteTask, taskIds);
			break;
			
		case UrlConst.PROJECT_TASK_EDIT:
			Task newTask = new Task();
			
			newTask.setName(req.getParameter("task_name"));
			newTask.setDescription(req.getParameter("task_description"));
			newTask.setStart(LocalDate.parse(req.getParameter("start_at")));
			newTask.setEnd(LocalDate.parse(req.getParameter("end_at")));
			
			String projectIdEdit = req.getParameter("project_id");
			String assigneeEmailEdit = req.getParameter("assignee");
			int statusIdEdit = Integer.parseInt(req.getParameter("status"));
			
			newTask.setAssignee(userService.getUserByEmail(assigneeEmailEdit));
			newTask.setProject(projectService.getProjectById(projectIdEdit));
			newTask.setStatus(statusService.getStatusById(String.valueOf(statusIdEdit)));
			
			taskService.updateTask(req.getParameter("task_id"), newTask);
			break;
		default:
			break;
		}
		
		resp.sendRedirect(req.getContextPath() + UrlConst.PROJECT_DETAIL + "?id=" + req.getParameter("project_id"));
	}
}
