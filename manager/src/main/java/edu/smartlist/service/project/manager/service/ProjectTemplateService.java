package edu.smartlist.service.project.manager.service;

import edu.smartlist.service.project.manager.model.ProjectTemplateMdl;

public interface ProjectTemplateService {

	public ProjectTemplateMdl createProjectTemplateMdl(ProjectTemplateMdl projectTemplateMdl);
	public ProjectTemplateMdl getProjectTemplateMdl(String projId);
}
