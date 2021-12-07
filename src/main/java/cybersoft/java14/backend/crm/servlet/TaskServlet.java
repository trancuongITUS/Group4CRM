package cybersoft.java14.backend.crm.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ant.jmx.JMXAccessorQueryTask;

import cybersoft.java14.backend.crm.model.Project;
import cybersoft.java14.backend.crm.model.Status;
import cybersoft.java14.backend.crm.model.Task;
import cybersoft.java14.backend.crm.model.User;
import cybersoft.java14.backend.crm.service.ProjectService;
import cybersoft.java14.backend.crm.service.StatusService;
import cybersoft.java14.backend.crm.service.TaskService;
import cybersoft.java14.backend.crm.service.UserService;
import cybersoft.java14.backend.crm.util.JspConst;
import cybersoft.java14.backend.crm.util.RollConst;
import cybersoft.java14.backend.crm.util.UrlConst;

@WebServlet(name = "taskServlet", urlPatterns = {
		UrlConst.TASK,
		UrlConst.TASK_LIST,
		UrlConst.TASK_CREATE,
		UrlConst.TASK_DELETE,
		UrlConst.TASK_EDIT,
		UrlConst.TASK_STATISTICS
})
public class TaskServlet extends HttpServlet {
	TaskService taskService;
	ProjectService projectService;
	UserService userService;
	StatusService statusService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		projectService = new ProjectService();
		taskService = new TaskService();
		userService = new UserService();
		statusService = new StatusService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		User user = (User) req.getSession().getAttribute("user");
		String rollName = user.getRole().getName();
		List<Task> tasks = null;
		
		switch (rollName) {
		case RollConst.ADMIN:
			tasks = taskService.getTasks();
			break;
		case RollConst.LEADER:
			tasks = taskService.getTasksByLeader(String.valueOf(user.getId()));
			break;
		case RollConst.EMPLOYEE:
			tasks = taskService.getTasksByAssignee(String.valueOf(user.getId()));
			break;
		default:
			break;
		}
		
		
		switch (servletPath) {
		case UrlConst.TASK_LIST :
			req.setAttribute("tasks", tasks);
			req.setAttribute("status", statusService.getStatusList());
			req.getRequestDispatcher(JspConst.TASK_LIST).forward(req, resp);;
			break;
		case UrlConst.TASK_CREATE:
			req.setAttribute("employees", userService.getEmployees());
			req.setAttribute("projects", projectService.getProjects());
			req.setAttribute("status", statusService.getStatusList());
			req.getRequestDispatcher(JspConst.TASK_CREATE).forward(req, resp);;
			break;
		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		
		switch (servletPath) {
		case UrlConst.TASK_CREATE:
			Task task = new Task();
			
			task.setName(req.getParameter("task_name"));
			task.setDescription(req.getParameter("task_description"));
			task.setStart(LocalDate.parse(req.getParameter("start_at")));
			task.setEnd(LocalDate.parse(req.getParameter("end_at")));
			
			String projectId = req.getParameter("project");
			String assigneeEmail = req.getParameter("assignee");
			int statusId = Integer.parseInt(req.getParameter("status"));
			
			task.setAssignee(userService.getUserByEmail(assigneeEmail));
			task.setProject(projectService.getProjectById(projectId));
			task.setStatus(statusService.getStatusById(String.valueOf(statusId)));
			
			taskService.createNewTask(task);
			break;
		case UrlConst.TASK_DELETE:
			String[] taskIds = req.getParameterValues("chkSelected");
			taskService.deleteTask(taskIds);
			break;
		case UrlConst.TASK_EDIT:
			String taskId = req.getParameter("task");
			String sttId = req.getParameter("status");
			
			Status newStatus = statusService.getStatusById(sttId);
			taskService.updateStatus(taskId, newStatus);
			break;
		default:
			break;
		}
		
		resp.sendRedirect(req.getContextPath() + UrlConst.TASK_LIST);
	}
}
