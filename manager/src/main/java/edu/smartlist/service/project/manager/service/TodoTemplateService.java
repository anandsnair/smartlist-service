package edu.smartlist.service.project.manager.service;

import edu.smartlist.service.project.manager.model.TodoTemplateMdl;

public interface TodoTemplateService {

	public TodoTemplateMdl createTodoTemplate(TodoTemplateMdl todoTemplateMdl);
	public TodoTemplateMdl getTodoTemplate(String id);
}
