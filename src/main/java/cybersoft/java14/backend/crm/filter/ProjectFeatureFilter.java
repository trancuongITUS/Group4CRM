package cybersoft.java14.backend.crm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java14.backend.crm.model.User;
import cybersoft.java14.backend.crm.util.RollConst;
import cybersoft.java14.backend.crm.util.UrlConst;

@WebFilter(urlPatterns = {
		UrlConst.PROJECT_ROOT
})
public class ProjectFeatureFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		User user = (User) req.getSession().getAttribute("user");
		String rollName = user.getRole().getName();
		
		if (RollConst.ADMIN.equals(rollName) || RollConst.LEADER.equals(rollName)) {
			chain.doFilter(req, resp);
		} else {
			System.out.println("Bạn không có quyền truy cập vào chức năng này!");
			resp.sendRedirect(req.getContextPath() + UrlConst.HOME);
		}
	}
}
