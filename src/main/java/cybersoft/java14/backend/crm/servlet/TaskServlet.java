package cybersoft.java14.backend.crm.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import cybersoft.java14.backend.crm.util.UrlConst;

@WebServlet(name = "taskServlet", urlPatterns = {
		UrlConst.TASK,
		UrlConst.TASK_LIST,
		UrlConst.TASK_PROGRESS,
		UrlConst.TASK_STATISTICS
})
public class TaskServlet extends HttpServlet {

}
