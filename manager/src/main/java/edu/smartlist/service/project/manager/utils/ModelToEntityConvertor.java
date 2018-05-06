package edu.smartlist.service.project.manager.utils;

import edu.smartlist.service.project.manager.entity.ProjectTemplate;
import edu.smartlist.service.project.manager.entity.TodoTemplate;
import edu.smartlist.service.project.manager.model.ProjectTemplateMdl;
import edu.smartlist.service.project.manager.model.TodoTemplateMdl;

public class ModelToEntityConvertor {

	public static ProjectTemplate convertToProjectTemplate(ProjectTemplateMdl pTemplateMdl) {
		ProjectTemplate mdl = new ProjectTemplate();
		if(pTemplateMdl.getId() != null)
			mdl.setId(pTemplateMdl.getId());
		mdl.setName(pTemplateMdl.getName());
		if(pTemplateMdl.getTodoTemplateMdl() != null) {
			for(TodoTemplateMdl tTemplate : pTemplateMdl.getTodoTemplateMdl()) {
				mdl.getTodoTemplates().add(convertToTodoTemplate(tTemplate));
			}
		}
		return mdl;
	}
	
	public static TodoTemplate convertToTodoTemplate(TodoTemplateMdl tTemplate) {
		TodoTemplate mdl = new TodoTemplate();
		mdl.setDueDate(tTemplate.getDueDate());
		mdl.setExtraNotes(tTemplate.getExtraNotes());
		if(tTemplate.getId() != null)
			mdl.setId(tTemplate.getId());
		mdl.setReminderDate(tTemplate.getReminderDate());
		mdl.setTodoName(tTemplate.getTodoName());
		//mdl.setProjectTemplate(tTemplate.getProjectId());
		return mdl;
	}

}
