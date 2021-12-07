package cybersoft.java14.backend.crm.service;

import java.util.List;

import cybersoft.java14.backend.crm.model.Status;
import cybersoft.java14.backend.crm.repository.StatusRepository;

public class StatusService {
	StatusRepository repository = new StatusRepository();
	private List<Status> statusList;
	
	public StatusService() {
		statusList = repository.getStatusList();
	}
	
	public List<Status> getStatusList() {
		return repository.getStatusList();
	}
	
	public Status getStatusById(String statusId) {
		if (statusId == null || "".equals(statusId)) {
			return null;
		}
		
		return repository.getStatusById(statusId);
	}
}
