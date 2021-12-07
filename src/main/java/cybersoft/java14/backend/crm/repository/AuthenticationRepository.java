package cybersoft.java14.backend.crm.repository;

import cybersoft.java14.backend.crm.model.User;

public class AuthenticationRepository {
	UserRepository userRepository = new UserRepository();
	
	public User checkLogin(String email, String password) {
		User user = userRepository.getUserByEmail(email);
		
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		
		return null;
	}
}
