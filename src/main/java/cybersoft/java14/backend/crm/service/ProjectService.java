package cybersoft.java14.backend.crm.service;

import java.util.List;

import cybersoft.java14.backend.crm.model.Project;
import cybersoft.java14.backend.crm.repository.ProjectRepository;

public class ProjectService {
	private ProjectRepository repository;
	public ProjectService() {
		repository = new ProjectRepository();
	}
	public boolean addProject(Project project)
	{
		return repository.addProject(project) == 1 ? true : false;
	}

	public boolean removeProject(String projectId)
	{
		return repository.removeProject(projectId) == 1 ? true : false;
	}
	/*
	 * public boolean removeProject(String projectID) { return
	 * repository.removeProject(projectID) == 1 ? true : false; }
	 */
	public List<Project> getProjects(){
		return repository.getProject();
	}
}
