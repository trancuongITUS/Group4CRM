package cybersoft.java14.backend.crm.util;

public class UrlConst {
	/* Root */
	public static final String ROOT = "/*";
	public static final String PROJECT_ROOT = "/project/*";
	public static final String USER_ROOT = "/user/*";
	public static final String TASK_ROOT = "/task/*";
	
	/* Authentication */
	public static final String SIGN_IN = "/login";
	public static final String SIGN_UP = "/signup";
	
	/* Home */
	public static final String HOME = "/home";
	
	/* Profile */
	public static final String PROFILE = "/profile";
	
	/* Project */
	public static final String PROJECT_LIST = "/project/project-list";
	public static final String PROJECT_ASSIGNMENT = "/project/project-assignment";
	public static final String PROJECT_CREATE = "/project/project-create";
	public static final String PROJECT_DELETE = "/project/project-delete";
	public static final String PROJECT_EDIT = "/project/project-edit";
	public static final String PROJECT_STATISTICS = "/project/project-statistics";
	
	/* Project Detail */
	public static final String PROJECT_DETAIL = "/project/project-detail";
	public static final String PROJECT_EMPS_ADD = "/project/project-detail/project-employees/add";
	public static final String PROJECT_EMPS_DELETE = "/project/project-detail/project-employees/delete";
	public static final String PROJECT_TASK_CREATE = "/project/project-detail/project-tasks/create";
	public static final String PROJECT_TASK_DELETE = "/project/project-detail/project-tasks/delete";
	public static final String PROJECT_TASK_EDIT = "/project/project-detail/project-tasks/edit";
	
	
	/* Task */
	public static final String TASK = "/task";
	public static final String TASK_CREATE = "/task/task-create";
	public static final String TASK_DELETE = "/task/task-delete";
	public static final String TASK_LIST = "/task/task-list";
	public static final String TASK_EDIT = "/task/task-edit";
	public static final String TASK_STATISTICS = "/task/task-statistics";
	
	/* User */
	public static final String USER_LIST = "/user/user-list";
	public static final String USER_EDIT = "/user/user-edit";
	public static final String USER_CREATE = "/user/user-create";
	public static final String USER_DELETE = "/user/user-delete";
}