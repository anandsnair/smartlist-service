package edu.smartlist.service.project.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.smartlist.service.project.manager.entity.ProjectTemplate;

@Repository
public interface ProjectTemplateRepository extends JpaRepository<ProjectTemplate, String> {

}
