package edu.smartlist.service.project.manager.model;

import java.util.Date;
import java.util.List;

import edu.smartlist.service.project.manager.entity.TodoTemplate;

public class TodoTemplateMdl {

	private String id;
	private String todoName;
	private Date dueDate;
	private Date reminderDate;
	private String parentTodoTemplateId;
	private String projectId;
	private String extraNotes;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTodoName() {
		return todoName;
	}
	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getReminderDate() {
		return reminderDate;
	}
	public void setReminderDate(Date reminderDate) {
		this.reminderDate = reminderDate;
	}
	public String getExtraNotes() {
		return extraNotes;
	}
	public void setExtraNotes(String extraNotes) {
		this.extraNotes = extraNotes;
	}
	public String getParentTodoTemplateId() {
		return parentTodoTemplateId;
	}
	public void setParentTodoTemplateId(String parentTodoTemplateId) {
		this.parentTodoTemplateId = parentTodoTemplateId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
}
