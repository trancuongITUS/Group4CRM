package cybersoft.java14.backend.crm.service;

import java.util.List;

import cybersoft.java14.backend.crm.model.User;
import cybersoft.java14.backend.crm.repository.UserRepository;

public class UserService {
	UserRepository repository = new UserRepository();
	private List<User> users;
	
	public UserService() {
		users = repository.getUsers();
	}
	
	public List<User> getUsers() {
		return repository.getUsers();
	}
	
	public List<User> getEmployees() {
		return repository.getEmployees();
	}
	
	public List<User> getUsersNotEmployees() {
		return repository.getUsersNotEmployees();
	}
	
	public List<User> getEmployeesFromProject(String projectId) {
		if (projectId == null || "".equals(projectId)) {
			return null;
		}
		
		if (users == null || users.isEmpty()) {
			return null;
		}
		
		return repository.getEmployeesFromProject(projectId);
	}
	
	public List<User> getEmployeesNotInProject(String projectId) {
		if (projectId == null || "".equals(projectId)) {
			return null;
		}
		
		if (users == null || users.isEmpty()) {
			return null;
		}
		
		return repository.getEmployeesNotInProject(projectId);
	}
	
	public User getUserByEmail(String email) {
		if (email == null || "".equals(email)) {
			return null;
		}
		
		if (users == null || users.isEmpty()) {
			return null;
		}
		
		return repository.getUserByEmail(email);
	}
	
	public boolean addUser(User user) {
		if (user == null) {
			return false;
		}
		
		if (users.contains(user)) {
			return false;
		}
		
		return repository.addUser(user) == 1 ? true : false;
	}
	
	public boolean deleteUser(String email) {
		if (email == null) {
			return false;
		}
		
		if (users.isEmpty()) {
			return false;
		}
		
		return repository.deleteUser(email) == 1 ? true : false;
	}
	
	public int deleteUser(String[] emails) {
		int count = 0;
		
		if (emails == null) {
			return 0;
		}
		
		for (String email : emails) {
			if (deleteUser(email) == false) {
				break;
			}
			
			count++;
		}
		
		return count;
	}
	
	public boolean updateUser(String email, User newUser) {
		if (email == null || newUser == null) {
			return false;
		}
		
		return repository.updateUser(email, newUser) == 1 ? true : false;
	}
}
