package cybersoft.java14.backend.crm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


import cybersoft.java14.backend.crm.database.MySQLConnection;
import cybersoft.java14.backend.crm.model.Project;

public class ProjectRepository {
	public List<Project> getProject(){
		List<Project> projects = new LinkedList<Project>();
		Connection connection = null;
		try {
			connection = MySQLConnection.getConnection();
			String query = "SELECT project_id, project_name, project_description, start_at, end_date, create_user FROM crm_project";
			
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next())
			{
				Project project = new Project();
				project.setId(rs.getInt("project_id")); // chỗ này nãy anh để là id .. làm gì có cột id nào .. anh phải để đúng cột nó mới match
				project.setName(rs.getString("project_name")); // này cũng z 
				project.setDescription(rs.getString("project_description"));
				/* project.setStart(rs.getDate("start_at")); */
				project.setEnd(null);
				project.setCreated(null);
				
				projects.add(project);
			}
		} catch(SQLException e)
		{
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		/*
		 * finally { if (connection != null) try { connection.close(); } catch
		 * (SQLException e) { e.printStackTrace(); } }
		 * 
		 * return projects;
		 */
		return projects;
	}
	public int addProject(Project project)
	{
		try {
			Connection conn = MySQLConnection.getConnection();
			String query = "INSERT crm_project (project_id, project_name, project_description) VALUES(?, ?, ?)";
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, project.getId());
			statement.setString(2, project.getName());
			statement.setString(3, project.getDescription());
			
			//Chỗ này anh chưa biết set dữ liệu ngày tháng
			/*statement.setDate(4, null, null);
			statement.setDate(5, null, null);
			statement.(6, project.getCreated());*/
			
			return statement.executeUpdate();
		}catch (SQLException e)
		{
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		return 0;
	}
	
	public int removeProject(String projectId)
	{
		try {
			Connection conn = MySQLConnection.getConnection();
			String query = "DELETE FROM crm_project WHERE project_id = ?";
			
			PreparedStatement statement = conn.prepareStatement(query);
			
			statement.setString(1, projectId);
			
			return statement.executeUpdate();
		}catch (SQLException e)
		{
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		return 0;
	}
}
