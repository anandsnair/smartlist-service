package edu.smartlist.service.project.manager.model;

import java.util.List;

public class ProjectTemplateMdl {

	private String id;
	private String name;
	private List<TodoTemplateMdl> todoTemplateMdl;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<TodoTemplateMdl> getTodoTemplateMdl() {
		return todoTemplateMdl;
	}
	public void setTodoTemplateMdl(List<TodoTemplateMdl> todoTemplateMdl) {
		this.todoTemplateMdl = todoTemplateMdl;
	}
	
}
