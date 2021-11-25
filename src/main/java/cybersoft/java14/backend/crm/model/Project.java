package cybersoft.java14.backend.crm.model;

import java.time.LocalDate;
import java.util.Objects;

public class Project {
	private int id;
	private String name;
	private String description;
	private LocalDate start;
	private LocalDate end;
	private User created;
	
	public Project() {
		
	}

	public Project(int id, String name, String description, LocalDate start, LocalDate end, User created) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.start = start;
		this.end = end;
		this.created = created;
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

	public User getCreated() {
		return created;
	}

	public void setCreated(User created) {
		this.created = created;
	}

	@Override
	public int hashCode() {
		return Objects.hash(created, description, end, id, name, start);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Project other = (Project) obj;
		return other.name.equals(this.name) && other.created.equals(this.created);
	}
	
	
	
}
