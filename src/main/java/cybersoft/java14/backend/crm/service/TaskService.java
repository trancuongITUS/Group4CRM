package cybersoft.java14.backend.crm.service;

import java.util.List;

import cybersoft.java14.backend.crm.model.Project;
import cybersoft.java14.backend.crm.model.Status;
import cybersoft.java14.backend.crm.model.Task;
import cybersoft.java14.backend.crm.repository.TaskRepository;

public class TaskService {
	TaskRepository repository = new TaskRepository();
	private List<Task> tasks;
	
	public TaskService() {
		tasks = repository.getTasks();
	}
	
	public List<Task> getTasks() {
		return repository.getTasks();
	}
	
	public List<Task> getTasksFromProject(String projectId) {
		if (projectId == null || "".equals(projectId)) {
			return null;
		}
		
		return repository.getTasksFromProject(projectId);
	}
	
	public Task getTaskById(String taskId) {
		if (taskId == null || "".equals(taskId)) {
			return null;
		}
		
		return repository.getTaskById(taskId);
	}
	
	public List<Task> getTasksByLeader(String leader_id) {
		if (leader_id == null || "".equals(leader_id)) {
			return null;
		}
		
		return repository.getTasksByLeader(leader_id);
	}
	
	public List<Task> getTasksByAssignee(String assignee_id) {
		if (assignee_id == null || "".equals(assignee_id)) {
			return null;
		}
		
		return repository.getTasksByAssignee(assignee_id);
	}
	
	public boolean createNewTask(Task task) {
		return repository.createNewTask(task) == 1 ? true : false;
	}
	
	public boolean createNewTaskToProject(String projectId, Task task) {
		if (projectId == null || task == null) {
			return false;
		}
		
		return repository.createNewTaskToProject(projectId, task) == 1 ? true : false;
	}
	
	public boolean deleteTask(String taskId) {
		if (taskId == null || "".equals(taskId)) {
			return false;
		}
		
		if (tasks.isEmpty()) {
			return false;
		}
		
		return repository.deleteTask(taskId) == 1 ? true : false;
	}
	
	public int deleteTask(String[] taskIds) {
		if (taskIds == null) {
			return 0;
		}
		
		int count = 0;
		
		for (String id : taskIds) {
			if (deleteTask(id) == false) {
				break;
			}
			
			count++;
		}
		
		return count;
	}
	
	public boolean deleteTaskFromProject(String projectId, String taskId) {
		if (projectId == null || taskId == null) {
			return false;
		}
		
		return repository.deleteTaskFromProject(projectId, taskId) == 1 ? true : false;
	}
	
	public int deleteTaskFromProject(String projectId, String[] taskIds) {
		if (projectId == null || taskIds == null) {
			return 0;
		}
		
		int count = 0;
		
		for (String id : taskIds) {
			if (deleteTaskFromProject(projectId, id) == false) {
				break;
			}
			
			count++;
		}
		
		return count;
	}
	
	public boolean updateTask(String id, Task newTask) {
		if (id == null || newTask == null) {
			return false;
		}
		
		return repository.updateTask(id, newTask) == 1 ? true : false;
	}
	
	public boolean updateStatus(String taskId, Status status) {
		if (taskId == null || status == null) {
			return false;
		}
		
		return repository.updateStatus(taskId, status) == 1 ? true : false;
	}
}
