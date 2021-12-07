package cybersoft.java14.backend.crm.service;

import cybersoft.java14.backend.crm.model.User;
import cybersoft.java14.backend.crm.repository.AuthenticationRepository;

public class AuthenticationService {
	AuthenticationRepository authRepository;
	
	public AuthenticationService() {
		authRepository = new AuthenticationRepository();
	}
	
	public User checkLogin(String email, String password) {
		if (email == null || password == null) {
			return null;
		}
		
		return authRepository.checkLogin(email, password);
	}
}
