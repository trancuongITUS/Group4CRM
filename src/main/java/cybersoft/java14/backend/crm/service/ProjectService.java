package cybersoft.java14.backend.crm.service;

import java.util.List;

import cybersoft.java14.backend.crm.model.Project;
import cybersoft.java14.backend.crm.model.User;
import cybersoft.java14.backend.crm.repository.ProjectRepository;

public class ProjectService {
	private ProjectRepository repository = new ProjectRepository();
	private List<Project> projects;
	
	public ProjectService() {
		projects = repository.getProject();
	}
	
	public List<Project> getProjects(){
		return repository.getProject();
	}
	
	public Project getProjectById(String id) {
		if (id == null || "".equals(id)) {
			return null;
		}
		
		if (projects == null || projects.isEmpty()) {
			return null;
		}
		
		return repository.getProjectById(id);
	}
	
	public List<Project> getProjectsByCreatedUser(String user_id) {
		if (user_id == null || "".equals(user_id)) {
			return null;
		}
		
		if (projects == null || projects.isEmpty()) {
			return null;
		}
		
		return repository.getProjectsByCreatedUser(user_id);
	}
	
	public boolean addProject(Project project) {
		if (project == null) {
			return false;
		}
		
		if (projects.contains(project)) {
			return false;
		}
		
		return repository.addProject(project) == 1 ? true : false;
	}
	
	public boolean addEmployeeToProject(String projectId, String empId) {
		return repository.addEmployeeToProject(projectId, empId) == 1 ? true : false;
	}
	
	public boolean deleteEmployeeFromProject(String projectId, String empsId) {
		if (projectId == null || empsId == null) {
			return false;
		}
		
		return repository.deleteEmployeeFromProject(projectId, empsId) == 1 ? true : false;
	}
	
	public int deleteEmployeeFromProject(String projectId, String[] empsId) {
		if (projectId == null || empsId == null) {
			return 0;
		}
		
		int count = 0;
		
		for (String id : empsId) {
			if (deleteEmployeeFromProject(projectId, id) == false) {
				break;
			}
			
			count++;
		}
		
		return count;
	}
	
	public boolean deleteProject(String id) {
		if (id == null) {
			return false;
		}
		
		if (projects.isEmpty()) {
			return false;
		}
		
		return repository.deleteProject(id) == 1 ? true : false;
	}
	
	public int deleteProject(String[] ids) {
		int count = 0;
		
		if (ids == null) {
			return 0;
		}
		
		for (String id : ids) {
			if (deleteProject(id) == false) {
				break;
			}
			
			count++;
		}
		
		return count;
	}
	
	public boolean updateProject(String id, Project newProject) {
		if (id == null || newProject == null) {
			return false;
		}
		
		return repository.updateProject(id, newProject) == 1 ? true : false;
	}
}
