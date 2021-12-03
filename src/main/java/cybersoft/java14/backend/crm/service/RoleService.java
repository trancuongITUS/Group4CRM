package cybersoft.java14.backend.crm.service;

import java.util.List;

import cybersoft.java14.backend.crm.model.Role;
import cybersoft.java14.backend.crm.repository.RoleRepository;

public class RoleService {
	RoleRepository repository = new RoleRepository();
	private List<Role> roles;
	
	public RoleService() {
		roles = repository.getRoles();
	}
	
	public List<Role> getRoles() {
		return repository.getRoles();
	}
}
