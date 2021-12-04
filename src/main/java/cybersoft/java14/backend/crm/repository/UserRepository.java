package cybersoft.java14.backend.crm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


import cybersoft.java14.backend.crm.database.MySQLConnection;
import cybersoft.java14.backend.crm.model.Role;
import cybersoft.java14.backend.crm.model.User;

public class UserRepository {
	public List<User> getUsers() {
		List<User> users = new LinkedList<User>();
		Connection connection = null;
		
		try {
			connection = MySQLConnection.getConnection();
			String query = "SELECT user_id, user_name, user_role, email, phone, address, role_name, role_description "
					+ "FROM crm_user JOIN crm_role ON user_role = role_id";
			
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				int user_id = rs.getInt("user_id");
				String name = rs.getString("user_name");
				int role_id = rs.getInt("user_role");
				String role_name = rs.getString("role_name");
				String role_description = rs.getString("role_description");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				
				User user = new User();
				Role role = new Role(role_id, role_name, role_description);
				user.setId(user_id);
				user.setName(name);
				user.setRole(role);
				user.setEmail(email);
				user.setPhone(phone);
				user.setAddress(address);
				users.add(user);
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
			e.printStackTrace();
		}
		
		return users;
	}
	
	public User getUserByEmail(String email) {
		User user = new User();
		
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = "SELECT user_id, user_name, user_role, email, phone, address, role_name, role_description "
					+ "FROM crm_user JOIN crm_role ON user_role = role_id "
					+ "WHERE email = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			
			
			if (rs.next()) {
				int user_id = rs.getInt("user_id");
				String name = rs.getString("user_name");
				int role_id = rs.getInt("user_role");
				String role_name = rs.getString("role_name");
				String role_description = rs.getString("role_description");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				
				Role role = new Role(role_id, role_name, role_description);
				user.setId(user_id);
				user.setName(name);
				user.setRole(role);
				user.setEmail(email);
				user.setPhone(phone);
				user.setAddress(address);
				
				return user;
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public List<User> getEmployees() {
		List<User> users = new LinkedList<User>();
		Connection connection = null;
		
		try {
			connection = MySQLConnection.getConnection();
			String query = "SELECT user_id, user_name, user_role, email, phone, address, role_name, role_description "
					+ "FROM crm_user JOIN crm_role ON user_role = role_id "
					+ "WHERE role_id = 3";
			
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				int user_id = rs.getInt("user_id");
				String name = rs.getString("user_name");
				int role_id = rs.getInt("user_role");
				String role_name = rs.getString("role_name");
				String role_description = rs.getString("role_description");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				
				User user = new User();
				Role role = new Role(role_id, role_name, role_description);
				user.setId(user_id);
				user.setName(name);
				user.setRole(role);
				user.setEmail(email);
				user.setPhone(phone);
				user.setAddress(address);
				users.add(user);
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
			e.printStackTrace();
		}
		
		return users;
	}
	
	public List<User> getUsersNotEmployees() {
		List<User> users = new LinkedList<User>();
		Connection connection = null;
		
		try {
			connection = MySQLConnection.getConnection();
			String query = "SELECT user_id, user_name, user_role, email, phone, address, role_name, role_description "
					+ "FROM crm_user JOIN crm_role ON user_role = role_id "
					+ "WHERE role_id != 3";
			
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				int user_id = rs.getInt("user_id");
				String name = rs.getString("user_name");
				int role_id = rs.getInt("user_role");
				String role_name = rs.getString("role_name");
				String role_description = rs.getString("role_description");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				
				User user = new User();
				Role role = new Role(role_id, role_name, role_description);
				user.setId(user_id);
				user.setName(name);
				user.setRole(role);
				user.setEmail(email);
				user.setPhone(phone);
				user.setAddress(address);
				users.add(user);
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
			e.printStackTrace();
		}
		
		return users;
	}
	
	
	public int addUser(User user) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = "INSERT INTO\r\n"
					+ "	crm_user(user_role, user_name, email, usr_password, phone, address)\r\n"
					+ "VALUES\r\n"
					+ "	(?, ?, ?, ?, ?, ?);";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, user.getRole().getId());
			statement.setString(2, user.getName());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getPhone());
			statement.setString(6, user.getAddress());
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int deleteUser(String email) {
		User user = getUserByEmail(email);
		
		try {
			Connection connection = MySQLConnection.getConnection();
			
			String deleteQuery = "DELETE FROM crm_user WHERE email = ?";
			String updateProjectQuery = "UPDATE crm_project SET create_user = null WHERE create_user = ?";
			String updateTaskQuery = "UPDATE crm_task SET assignee = null WHERE assignee = ?";
			String deleteProjectUsersQuery = "DELETE FROM crm_project_users WHERE user_id = ?";
			
			PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
			PreparedStatement updateProjectStatement = connection.prepareStatement(updateProjectQuery);
			PreparedStatement updateTaskStatement = connection.prepareStatement(updateTaskQuery);
			PreparedStatement deleteProjectUsersStatement = connection.prepareStatement(deleteProjectUsersQuery);
			
			deleteStatement.setString(1, email);
			updateProjectStatement.setInt(1, user.getId());
			updateTaskStatement.setInt(1, user.getId());
			deleteProjectUsersStatement.setInt(1, user.getId());
			
			updateProjectStatement.executeUpdate();
			updateTaskStatement.executeUpdate();
			deleteProjectUsersStatement.executeUpdate();
			
			return deleteStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int updateUser(String email, User newUser) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = "UPDATE crm_user"
						+ " SET user_role = ?, user_name = ?, email = ?, phone = ?, address = ?"
						+ " WHERE email = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, newUser.getRole().getId());
			statement.setString(2, newUser.getName());
			statement.setString(3, newUser.getEmail());
			statement.setString(4, newUser.getPhone());
			statement.setString(5, newUser.getAddress());
			statement.setString(6, email);
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		
		return 0;
	}
}