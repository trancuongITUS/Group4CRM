package cybersoft.java14.backend.crm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import cybersoft.java14.backend.crm.database.MySQLConnection;
import cybersoft.java14.backend.crm.model.Project;
import cybersoft.java14.backend.crm.model.Status;
import cybersoft.java14.backend.crm.model.Task;
import cybersoft.java14.backend.crm.model.User;

public class TaskRepository {
	public List<Task> getTasks() {
		UserRepository userRepository = new UserRepository();
		StatusRepository statusRepository = new StatusRepository();
		ProjectRepository projectRepository = new ProjectRepository();
		
		List<User> employees =  userRepository.getEmployees();
		List<Status> statusList = statusRepository.getStatusList();
		List<Project> projects = projectRepository.getProject();
		
		List<Task> tasks = new LinkedList<Task>();
		Connection connection = null;
		
		try {
			connection = MySQLConnection.getConnection();
			String query = "SELECT task_id, assignee, task_name, task_description, start_at, end_at, task_status, task_project "
					+ "FROM crm_task";
			
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("task_id"));
				task.setName(rs.getString("task_name"));
				task.setDescription(rs.getString("task_description"));
				task.setStart(LocalDate.parse(rs.getString("start_at")));
				task.setEnd(LocalDate.parse(rs.getString("end_at")));
				
				int assignee = rs.getInt("assignee");
				int task_status = rs.getInt("task_status");
				int task_project = rs.getInt("task_project");
				
				for (User employee : employees) {
					if (employee.getId() == assignee) {
						task.setAssignee(employee);
						break;
					}
				}
				
				for (Status status : statusList) {
					if (status.getId() == task_status) {
						task.setStatus(status);
						break;
					}
				}
				
				for (Project project : projects) {
					if (project.getId() == task_project) {
						task.setProject(project);
						break;
					}
				}
				
				tasks.add(task);
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
			e.printStackTrace();
		}
		
		return tasks;
	}
	
	public List<Task> getTasksFromProject(String projectId) {
		UserRepository userRepository = new UserRepository();
		StatusRepository statusRepository = new StatusRepository();
		ProjectRepository projectRepository = new ProjectRepository();
		
		List<User> employees =  userRepository.getEmployees();
		List<Status> statusList = statusRepository.getStatusList();
		Project project = projectRepository.getProjectById(projectId);
		
		List<Task> tasks = new LinkedList<Task>();
		Connection connection = null;
		
		try {
			connection = MySQLConnection.getConnection();
			String query = "SELECT task_id, assignee, task_name, task_description, start_at, end_at, task_status, task_project "
					+ "FROM crm_task "
					+ "WHERE task_project = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, projectId);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("task_id"));
				task.setName(rs.getString("task_name"));
				task.setDescription(rs.getString("task_description"));
				task.setStart(LocalDate.parse(rs.getString("start_at")));
				task.setEnd(LocalDate.parse(rs.getString("end_at")));
				
				int assignee = rs.getInt("assignee");
				int task_status = rs.getInt("task_status");
				
				for (User employee : employees) {
					if (employee.getId() == assignee) {
						task.setAssignee(employee);
						break;
					}
				}
				
				for (Status status : statusList) {
					if (status.getId() == task_status) {
						task.setStatus(status);
						break;
					}
				}
				
				task.setProject(project);
						
				tasks.add(task);
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
			e.printStackTrace();
		}
		
		return tasks;
	}
	
	public Task getTaskById(String taskId) {
		UserRepository userRepository = new UserRepository();
		StatusRepository statusRepository = new StatusRepository();
		ProjectRepository projectRepository = new ProjectRepository();
		
		Connection connection = null;
		
		try {
			connection = MySQLConnection.getConnection();
			String query = "SELECT task_id, assignee, task_name, task_description, start_at, end_at, task_status, task_project "
					+ "FROM crm_task "
					+ "WHERE task_id = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, taskId);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("task_id"));
				task.setName(rs.getString("task_name"));
				task.setDescription(rs.getString("task_description"));
				task.setStart(LocalDate.parse(rs.getString("start_at")));
				task.setEnd(LocalDate.parse(rs.getString("end_at")));
				task.setAssignee(userRepository.getUserById(String.valueOf(rs.getInt("assignee"))));
				task.setProject(projectRepository.getProjectById(String.valueOf(rs.getInt("task_project"))));
				task.setStatus(statusRepository.getStatusById(String.valueOf(rs.getInt("task_status"))));
			
				return task;
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Task> getTasksByLeader(String leader_id) {
		UserRepository userRepository = new UserRepository();
		StatusRepository statusRepository = new StatusRepository();
		ProjectRepository projectRepository = new ProjectRepository();
		
		List<User> employees =  userRepository.getEmployees();
		List<Status> statusList = statusRepository.getStatusList();
		List<Project> projects = projectRepository.getProject();
		
		List<Task> tasks = new LinkedList<Task>();
		Connection connection = null;
		
		try {
			connection = MySQLConnection.getConnection();
			String query = "SELECT task_id, assignee, task_name, task_description, crm_task.start_at, crm_task.end_at, task_status, task_project "
					+ "FROM crm_task JOIN crm_project ON task_project = project_id "
					+ "WHERE crm_project.create_user = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, leader_id);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("task_id"));
				task.setName(rs.getString("task_name"));
				task.setDescription(rs.getString("task_description"));
				task.setStart(LocalDate.parse(rs.getString("start_at")));
				task.setEnd(LocalDate.parse(rs.getString("end_at")));
				
				int assignee = rs.getInt("assignee");
				int task_status = rs.getInt("task_status");
				int task_project = rs.getInt("task_project");
				
				for (User employee : employees) {
					if (employee.getId() == assignee) {
						task.setAssignee(employee);
						break;
					}
				}
				
				for (Status status : statusList) {
					if (status.getId() == task_status) {
						task.setStatus(status);
						break;
					}
				}
				
				for (Project project : projects) {
					if (project.getId() == task_project) {
						task.setProject(project);
						break;
					}
				}
				
				tasks.add(task);
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
			e.printStackTrace();
		}
		return tasks;
	}
	
	public List<Task> getTasksByAssignee(String assignee_id) {
		UserRepository userRepository = new UserRepository();
		StatusRepository statusRepository = new StatusRepository();
		ProjectRepository projectRepository = new ProjectRepository();
		
		List<User> employees =  userRepository.getEmployees();
		List<Status> statusList = statusRepository.getStatusList();
		List<Project> projects = projectRepository.getProject();
		
		List<Task> tasks = new LinkedList<Task>();
		Connection connection = null;
		
		try {
			connection = MySQLConnection.getConnection();
			String query = "SELECT task_id, assignee, task_name, task_description, start_at, end_at, task_status, task_project "
					+ "FROM crm_task "
					+ "WHERE assignee = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, assignee_id);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("task_id"));
				task.setName(rs.getString("task_name"));
				task.setDescription(rs.getString("task_description"));
				task.setStart(LocalDate.parse(rs.getString("start_at")));
				task.setEnd(LocalDate.parse(rs.getString("end_at")));
				
				int assignee = rs.getInt("assignee");
				int task_status = rs.getInt("task_status");
				int task_project = rs.getInt("task_project");
				
				for (User employee : employees) {
					if (employee.getId() == assignee) {
						task.setAssignee(employee);
						break;
					}
				}
				
				for (Status status : statusList) {
					if (status.getId() == task_status) {
						task.setStatus(status);
						break;
					}
				}
				
				for (Project project : projects) {
					if (project.getId() == task_project) {
						task.setProject(project);
						break;
					}
				}
				
				tasks.add(task);
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
			e.printStackTrace();
		}
		
		return tasks;
	}
	
	public int createNewTask(Task task) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = "INSERT INTO "
					+ "crm_task(assignee, task_name, task_description, start_at, end_at, task_status, task_project) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, task.getAssignee().getId());
			statement.setString(2, task.getName());
			statement.setString(3, task.getDescription());
			statement.setString(4, task.getStart().toString());
			statement.setString(5, task.getEnd().toString());
			statement.setInt(6, task.getStatus().getId());
			statement.setInt(7, task.getProject().getId());
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	public int createNewTaskToProject(String projectId, Task task) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = "INSERT INTO "
					+ "crm_task(assignee, task_name, task_description, start_at, end_at, task_status, task_project) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, task.getAssignee().getId());
			statement.setString(2, task.getName());
			statement.setString(3, task.getDescription());
			statement.setString(4, task.getStart().toString());
			statement.setString(5, task.getEnd().toString());
			statement.setInt(6, task.getStatus().getId());
			statement.setInt(7, task.getProject().getId());
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int deleteTask(String taskId) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = "DELETE FROM crm_task WHERE task_id = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, Integer.parseInt(taskId));
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int deleteTaskFromProject(String projectId, String taskIds) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = "DELETE FROM crm_task WHERE task_project = ? AND task_id = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, Integer.parseInt(projectId));
			statement.setInt(2, Integer.parseInt(taskIds));
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int updateTask(String id, Task newTask) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = "UPDATE crm_task"
					+ " SET task_name = ?, task_description = ?, start_at = ?, end_at = ?, assignee = ?, task_status = ?, task_project = ? "
					+ " WHERE task_id = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, newTask.getName());
			statement.setString(2, newTask.getDescription());
			statement.setString(3, newTask.getStart().toString());
			statement.setString(4, newTask.getEnd().toString());
			statement.setInt(5, newTask.getAssignee().getId());
			statement.setInt(6, newTask.getStatus().getId());
			statement.setInt(7, newTask.getProject().getId());
			statement.setInt(8, Integer.parseInt(id));
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int updateStatus(String id, Status status) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = "UPDATE crm_task"
					+ " SET task_status = ?"
					+ " WHERE task_id = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, status.getId());
			statement.setInt(2, Integer.parseInt(id));
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
			e.printStackTrace();
		}
		
		return 0;
	}
}
