package cybersoft.java14.backend.crm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cybersoft.java14.backend.crm.database.MySQLConnection;
import cybersoft.java14.backend.crm.model.Status;

public class StatusRepository {
	public List<Status> getStatusList() {
		List<Status> statusList = new LinkedList<Status>();
		Connection connection = null;
		
		try {
			connection = MySQLConnection.getConnection();
			String query = "SELECT status_id, status_name, status_description FROM crm_status";
			
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				int status_id = rs.getInt("status_id");
				String status_name = rs.getString("status_name");
				String status_description = rs.getString("status_description");
				
				Status status = new Status(status_id, status_name, status_description);
				statusList.add(status);
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
			e.printStackTrace();
		}
		
		return statusList;
	}
	
	public Status getStatusById(String statusId) {
		Connection connection = null;
		
		try {
			connection = MySQLConnection.getConnection();
			String query = "SELECT status_id, status_name, status_description FROM crm_status WHERE status_id = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, Integer.parseInt(statusId));
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {
				int status_id = rs.getInt("status_id");
				String status_name = rs.getString("status_name");
				String status_description = rs.getString("status_description");
				
				return new Status(status_id, status_name, status_description);
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
			e.printStackTrace();
		}
		
		return null;
	}
}