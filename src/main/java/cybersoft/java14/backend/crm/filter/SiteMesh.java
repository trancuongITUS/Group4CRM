package cybersoft.java14.backend.crm.filter;

import javax.servlet.annotation.WebFilter;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

import cybersoft.java14.backend.crm.util.UrlConst;

@WebFilter(filterName = "sitemesh", urlPatterns = {
		UrlConst.HOME,
		UrlConst.PROFILE,
		UrlConst.PROJECT,
		UrlConst.PROJECT + "/*",
		UrlConst.USER,
		UrlConst.USER + "/*",
		UrlConst.TASK,
		UrlConst.TASK + "/*"
})
public class SiteMesh extends SiteMeshFilter {
	
}
