package edu.smartlist.service.project.manager.utils;

import edu.smartlist.service.project.manager.entity.ProjectTemplate;
import edu.smartlist.service.project.manager.entity.TodoTemplate;
import edu.smartlist.service.project.manager.model.ProjectTemplateMdl;
import edu.smartlist.service.project.manager.model.TodoTemplateMdl;

public class EntityToModelConvertor {

	public static ProjectTemplateMdl convertToProjectTemplateMdl(ProjectTemplate pTemplate) {
		ProjectTemplateMdl mdl = new ProjectTemplateMdl();
		mdl.setId(pTemplate.getId());
		mdl.setName(pTemplate.getName());
		if( pTemplate.getTodoTemplates() != null) {
			for(TodoTemplate tTemplate : pTemplate.getTodoTemplates()) {
				mdl.getTodoTemplateMdl().add(convertToTodoTemplateMdl(tTemplate));
			}
		}
		return mdl;
	}
	
	public static TodoTemplateMdl convertToTodoTemplateMdl(TodoTemplate tTemplate) {
		TodoTemplateMdl mdl = new TodoTemplateMdl();
		mdl.setDueDate(tTemplate.getDueDate());
		mdl.setExtraNotes(tTemplate.getExtraNotes());
		mdl.setId(tTemplate.getId());
		mdl.setReminderDate(tTemplate.getReminderDate());
		mdl.setTodoName(tTemplate.getTodoName());
		mdl.setParentTodoTemplateId(tTemplate.getParentTodoTemplate().getId());
		mdl.setProjectId(tTemplate.getProjectTemplate().getId());
		return mdl;
	}

}
