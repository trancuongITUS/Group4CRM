package cybersoft.java14.backend.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java14.backend.crm.model.User;
import cybersoft.java14.backend.crm.service.RoleService;
import cybersoft.java14.backend.crm.service.UserService;
import cybersoft.java14.backend.crm.util.JspConst;
import cybersoft.java14.backend.crm.util.UrlConst;

@WebServlet(name = "userServlet", urlPatterns = {
		UrlConst.USER_LIST,
		UrlConst.USER_DELETE,
		UrlConst.USER_CREATE,
		UrlConst.USER_EDIT
})
public class UserServlet extends HttpServlet {
	UserService userService;
	RoleService roleService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		userService = new UserService();
		roleService = new RoleService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		
		switch (servletPath) {
		case UrlConst.USER_LIST:
			req.setAttribute("roles", roleService.getRoles());
			req.setAttribute("users", userService.getUsers());
			req.getRequestDispatcher(JspConst.USER_LIST).forward(req, resp);
			break;
		case UrlConst.USER_EDIT:
			String email = req.getParameter("email");
			req.setAttribute("user", userService.getUserByEmail(email));
			req.setAttribute("roles", roleService.getRoles());
			req.getRequestDispatcher(JspConst.USER_AUTHOR).forward(req, resp);
		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		req.setCharacterEncoding("UTF-8");
		
		switch (servletPath) {
		case UrlConst.USER_CREATE:
			User user = new User();
			user.setName(req.getParameter("user_name"));
			user.setEmail(req.getParameter("user_email"));
			user.setPassword(req.getParameter("user_pass"));
			user.setPhone(req.getParameter("user_phone"));
			user.setAddress(req.getParameter("user_address"));
			
			String roleName = req.getParameter("user_role");
			for (int i = 0; i < roleService.getRoles().size(); ++i) {
				if (roleService.getRoles().get(i).getName().equals(roleName)) {
					user.setRole(roleService.getRoles().get(i));
					break;
				}
			}
			
			userService.addUser(user);
			break;
			
		case UrlConst.USER_DELETE:
			String[] selected = req.getParameterValues("chkSelected");
			int countRows = userService.deleteUser(selected);
			System.out.println(countRows + " rows has been deleted!");
			break;
			
		case UrlConst.USER_EDIT:
			User newUser = new User();
			String email = req.getParameter("email");
			newUser.setName(req.getParameter("user_name"));
			newUser.setEmail(req.getParameter("user_email"));
			newUser.setPhone(req.getParameter("user_phone"));
			newUser.setAddress(req.getParameter("user_address"));
			
			String newRoleName = req.getParameter("user_role");
			for (int i = 0; i < roleService.getRoles().size(); ++i) {
				if (roleService.getRoles().get(i).getName().equals(newRoleName)) {
					newUser.setRole(roleService.getRoles().get(i));
					break;
				}
			}
			
			if (userService.updateUser(email, newUser)) {
				System.out.println("Update successfully!");
			} else {
				System.out.println("Error!");
			}
			
		default:
			break;
		}
		
		resp.sendRedirect(req.getContextPath() + UrlConst.USER_LIST);
	}
}
