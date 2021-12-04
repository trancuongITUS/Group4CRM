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
import cybersoft.java14.backend.crm.model.Role;
import cybersoft.java14.backend.crm.model.User;

public class ProjectRepository {
	public List<Project> getProject() {
		UserRepository userRepository = new UserRepository();
		List<User> users = userRepository.getUsers();
		
		List<Project> projects = new LinkedList<Project>();
		Connection connection = null;
		
		try {
			connection = MySQLConnection.getConnection();
			String query = "SELECT project_id, project_name, project_description, start_at, end_at, create_user "
					+ "FROM crm_project";
			
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Project project = new Project();
				project.setId(rs.getInt("project_id"));
				project.setName(rs.getString("project_name"));
				project.setDescription(rs.getString("project_description"));
				project.setStart(LocalDate.parse(rs.getString("start_at")));
				project.setEnd(LocalDate.parse(rs.getString("end_at")));
				
				User user = new User();
				int id = rs.getInt("create_user");
				
				for (User usr : users) {
					if (usr.getId() == id) {
						user = usr;
						break;
					}
				}
				
				project.setCreated(user);
				
				projects.add(project);
			}
		} catch(SQLException e)
		{
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		
		return projects;
	}
	
	public Project getProjectById(String id) {
		UserRepository userRepository = new UserRepository();
		List<User> users = userRepository.getUsers();
		
		List<Project> projects = new LinkedList<Project>();
		Connection connection = null;
		
		Project project = new Project();
		
		try {
			connection = MySQLConnection.getConnection();
			String query = "SELECT project_id, project_name, project_description, start_at, end_at, create_user "
					+ "FROM crm_project "
					+ "WHERE project_id = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, Integer.parseInt(id));
			ResultSet rs = statement.executeQuery();
			
			
			if (rs.next()) {
				project.setId(rs.getInt("project_id"));
				project.setName(rs.getString("project_name"));
				project.setDescription(rs.getString("project_description"));
				project.setStart(LocalDate.parse(rs.getString("start_at")));
				project.setEnd(LocalDate.parse(rs.getString("end_at")));
				
				User user = new User();
				int created = rs.getInt("create_user");
				
				for (User usr : users) {
					if (usr.getId() == created) {
						user = usr;
						break;
					}
				}
				
				project.setCreated(user);
				
				return project;
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int addProject(Project project) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = "INSERT INTO\r\n"
					+ "	crm_project(project_name, project_description, start_at, end_at, create_user)\r\n"
					+ "VALUES\r\n"
					+ "	(?, ?, ?, ?, ?);";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setString(3, project.getStart().toString());
			statement.setString(4, project.getEnd().toString());
			statement.setInt(5, project.getCreated().getId());
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteProject(String id) {
		try {
			Connection connection = MySQLConnection.getConnection();
			
			String deleteQuery = "DELETE FROM crm_project WHERE project_id = ?";
			String deleteTaskOfProjectQuery = "DELETE FROM crm_task WHERE task_project = ?";
			String deleteProjectUsersQuery = "DELETE FROM crm_project_users WHERE project_id = ?";
			
			PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
			PreparedStatement deleteTaskOfProjectStatement = connection.prepareStatement(deleteTaskOfProjectQuery);
			PreparedStatement deleteProjectUsersStatement = connection.prepareStatement(deleteProjectUsersQuery);
			
			deleteStatement.setInt(1, Integer.parseInt(id));
			deleteTaskOfProjectStatement.setInt(1, Integer.parseInt(id));
			deleteProjectUsersStatement.setInt(1, Integer.parseInt(id));
			
			deleteTaskOfProjectStatement.executeUpdate();
			deleteProjectUsersStatement.executeUpdate();
			
			return deleteStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int updateProject(String id, Project newProject) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = "UPDATE crm_project"
						+ " SET project_name = ?, project_description = ?, start_at = ?, end_at = ?, create_user = ?"
						+ " WHERE project_id = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, newProject.getName());
			statement.setString(2, newProject.getDescription());
			statement.setString(3, newProject.getStart().toString());
			statement.setString(4, newProject.getEnd().toString());
			statement.setInt(5, newProject.getCreated().getId());
			statement.setString(6, id);
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		
		return 0;
	}
}
