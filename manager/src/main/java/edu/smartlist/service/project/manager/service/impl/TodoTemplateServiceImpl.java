package edu.smartlist.service.project.manager.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import edu.smartlist.service.project.manager.entity.TodoTemplate;
import edu.smartlist.service.project.manager.model.TodoTemplateMdl;
import edu.smartlist.service.project.manager.repository.TodoTemplateRepository;
import edu.smartlist.service.project.manager.service.TodoTemplateService;
import edu.smartlist.service.project.manager.utils.EntityToModelConvertor;
import edu.smartlist.service.project.manager.utils.ModelToEntityConvertor;

public class TodoTemplateServiceImpl implements TodoTemplateService {

	@Autowired
	private TodoTemplateRepository tRepo;
	@Override
	public TodoTemplateMdl createTodoTemplate(TodoTemplateMdl todoTemplateMdl) {
		TodoTemplate tTemplate = ModelToEntityConvertor.convertToTodoTemplate(todoTemplateMdl);
		TodoTemplate savedTTemplate = tRepo.save(tTemplate);
		return EntityToModelConvertor.convertToTodoTemplateMdl(savedTTemplate);
	}

	@Override
	public TodoTemplateMdl getTodoTemplate(String id) {
		Optional<TodoTemplate> tTemplate = tRepo.findById(id);
		return EntityToModelConvertor.convertToTodoTemplateMdl(tTemplate.get());
	}

}
