package edu.smartlist.service.project.manager.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TODO_TEMPLATE")
public class TodoTemplate extends AbstractBaseEntity {
	
	@Column(name="TODO_NAME")
	private String todoName;
	
	@Column(name="DUE_DATE")
	private Date dueDate;
	
	@Column(name="REMINDER_DATE")
	private Date reminderDate;
	
	@OneToMany(mappedBy="parentTodoTemplate")
	private List<TodoTemplate> childTodoTemplates;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PARENT_TODO_TEMPLATE_ID")
	private TodoTemplate parentTodoTemplate;
	
	@Column(name="EXTRA_NOTES")
	private String extraNotes;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PROJECT_ID")
	private ProjectTemplate projectTemplate;
	
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
	public List<TodoTemplate> getChildTodoTemplates() {
		return childTodoTemplates;
	}
	public void setChildTodoTemplates(List<TodoTemplate> childTodoTemplates) {
		this.childTodoTemplates = childTodoTemplates;
	}
	public TodoTemplate getParentTodoTemplate() {
		return parentTodoTemplate;
	}
	public void setParentTodoTemplate(TodoTemplate parentTodoTemplate) {
		this.parentTodoTemplate = parentTodoTemplate;
	}
	public String getExtraNotes() {
		return extraNotes;
	}
	public void setExtraNotes(String extraNotes) {
		this.extraNotes = extraNotes;
	}
	public ProjectTemplate getProjectTemplate() {
		return projectTemplate;
	}
	public void setProjectTemplate(ProjectTemplate projectTemplate) {
		this.projectTemplate = projectTemplate;
	}
	
	
}
