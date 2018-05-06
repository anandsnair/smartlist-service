package edu.smartlist.service.project.manager.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.smartlist.service.project.manager.entity.ProjectTemplate;
import edu.smartlist.service.project.manager.model.ProjectTemplateMdl;
import edu.smartlist.service.project.manager.repository.ProjectTemplateRepository;
import edu.smartlist.service.project.manager.service.ProjectTemplateService;
import edu.smartlist.service.project.manager.utils.EntityToModelConvertor;
import edu.smartlist.service.project.manager.utils.ModelToEntityConvertor;


@Service
public class ProjectTemplateServiceImpl implements ProjectTemplateService {

	@Autowired
	ProjectTemplateRepository pRepo;
	
	@Override
	public ProjectTemplateMdl createProjectTemplateMdl(ProjectTemplateMdl projectTemplateMdl) {
		ProjectTemplate pTemplate = ModelToEntityConvertor.convertToProjectTemplate(projectTemplateMdl);
		ProjectTemplate savedPTemplate = pRepo.save(pTemplate);
		return EntityToModelConvertor.convertToProjectTemplateMdl(savedPTemplate);
	}

	@Override
	public ProjectTemplateMdl getProjectTemplateMdl(String projId) {
		Optional<ProjectTemplate> pTemplate = pRepo.findById(projId);
		return EntityToModelConvertor.convertToProjectTemplateMdl(pTemplate.get());
	}

}
