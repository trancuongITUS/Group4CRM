package cybersoft.java14.backend.crm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cybersoft.java14.backend.crm.database.MySQLConnection;
import cybersoft.java14.backend.crm.model.Role;

public class RoleRepository {
	public List<Role> getRoles() {
		List<Role> roles = new LinkedList<Role>();
		Connection connection;
		
		try {
			connection = MySQLConnection.getConnection();
			String query = "SELECT role_id, role_name, role_description FROM crm_role";
			
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				int role_id = rs.getInt("role_id");
				String role_name = rs.getString("role_name");
				String role_description = rs.getString("role_description");
				
				Role role = new Role(role_id, role_name, role_description);
				roles.add(role);
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
			e.printStackTrace();
		}
		
		return roles;
	}
}
