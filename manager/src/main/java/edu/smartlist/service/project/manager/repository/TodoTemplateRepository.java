package edu.smartlist.service.project.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.smartlist.service.project.manager.entity.TodoTemplate;

@Repository
public interface TodoTemplateRepository extends JpaRepository<TodoTemplate, String> {

}
