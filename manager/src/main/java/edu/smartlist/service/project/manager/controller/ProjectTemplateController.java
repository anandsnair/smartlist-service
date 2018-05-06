package edu.smartlist.service.project.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.smartlist.service.project.manager.model.ProjectTemplateMdl;
import edu.smartlist.service.project.manager.service.ProjectTemplateService;

@RestController
@RequestMapping("/api")
public class ProjectTemplateController {

	@Autowired
	ProjectTemplateService service;
	
	@PostMapping("/projects")
	public ProjectTemplateMdl createProjectTemplate(@RequestBody ProjectTemplateMdl pTemplateMdl) {
		return service.createProjectTemplateMdl(pTemplateMdl);
	}
	
	
	@GetMapping("/projects/{projectId}")
	public ProjectTemplateMdl createProjectTemplate(@PathVariable String projectId) {
		return service.getProjectTemplateMdl(projectId);
	}
}
