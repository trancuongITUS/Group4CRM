package cybersoft.java14.backend.crm.model;

import java.time.LocalDate;
import java.util.Objects;

public class Task {
	private int id;
	private String name;
	private String description;
	LocalDate start;
	LocalDate end;
	private User assignee;
	private Status status;
	private Project project;
	public Task() {
		
	}
	
	public Task(int id, String name, String description, LocalDate start, LocalDate end, User assignee, Status status,
			Project project) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.start = start;
		this.end = end;
		this.assignee = assignee;
		this.status = status;
		this.project = project;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assignee, description, end, id, name, project, start, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Task other = (Task) obj;
		return other.name.equals(this.name) && other.project.equals(this.project);
	}
	
	
	
}
