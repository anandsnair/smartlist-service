package edu.smartlist.service.project.manager.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PROJECT_TEMPLATE")
public class ProjectTemplate extends AbstractBaseEntity{
	
	@Column(name="NAME")
	private String name;
	
	@OneToMany(mappedBy="projectTemplate")
	private List<TodoTemplate> todoTemplates;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TodoTemplate> getTodoTemplates() {
		return todoTemplates;
	}

	public void setTodoTemplates(List<TodoTemplate> todos) {
		this.todoTemplates = todos;
	}
	
	
}
