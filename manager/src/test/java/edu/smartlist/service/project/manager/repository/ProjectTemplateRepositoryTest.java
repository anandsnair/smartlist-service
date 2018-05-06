package edu.smartlist.service.project.manager.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import edu.smartlist.service.project.manager.entity.ProjectTemplate;
import edu.smartlist.service.project.manager.entity.TodoTemplate;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProjectTemplateRepositoryTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	ProjectTemplateRepository projectTempRepo;
	
	@Test
	public void createProjectTemplate() {
		ProjectTemplate projTem = new ProjectTemplate();
		projTem.setName("Test");
		
		projTem = entityManager.persistAndFlush(projTem);
		
		Optional<ProjectTemplate> retrivedPT = projectTempRepo.findById(projTem.getId());
		System.out.println(retrivedPT.get().getName());
	}
	
	@Test
	public void createProjectTemplateAndAddTodos() {
		ProjectTemplate projTem = new ProjectTemplate();
		projTem.setName("Test");
		
		projTem = entityManager.persistAndFlush(projTem);
		
		Optional<ProjectTemplate> retrivedPT = projectTempRepo.findById(projTem.getId());
		ProjectTemplate retPT = retrivedPT.get();
		System.out.println(retPT.getName());
		
		List<TodoTemplate> todos = new ArrayList<>();
		
		for(int i = 1 ; i <= 5; i++) {
			TodoTemplate tTemplate = new TodoTemplate();
			tTemplate.setTodoName("Go To Some place "+i);
			tTemplate.setReminderDate(new Date(2018, 11, i));
			tTemplate.setDueDate(new Date(2018, 11, i));
			todos.add(tTemplate);
		}
		retPT.setTodoTemplates(todos);
		entityManager.persistAndFlush(retPT);
		
		retPT = projectTempRepo.findById(projTem.getId()).get();
		for(TodoTemplate temp : retPT.getTodoTemplates()) {
			System.out.println(temp.getTodoName() + " " + temp.getId());
		}
	}
	
	
	@Test
	public void createProjectTemplateAndAddNestedTodos() {
		ProjectTemplate projTem = new ProjectTemplate();
		projTem.setName("Test");
		
		projTem = entityManager.persistAndFlush(projTem);
		
		Optional<ProjectTemplate> retrivedPT = projectTempRepo.findById(projTem.getId());
		ProjectTemplate retPT = retrivedPT.get();
		System.out.println(retPT.getName());
		
		List<TodoTemplate> todos = new ArrayList<>();
		
		for(int i = 1 ; i <= 5; i++) {
			TodoTemplate tTemplate = new TodoTemplate();
			tTemplate.setTodoName("Go To Some place "+i);
			tTemplate.setReminderDate(new Date(2018, 11, i));
			tTemplate.setDueDate(new Date(2018, 11, i));
			tTemplate.setProjectTemplate(retPT);
			todos.add(tTemplate);
		}
		retPT.setTodoTemplates(todos);
		entityManager.persistAndFlush(retPT);
		
		retPT = projectTempRepo.findById(projTem.getId()).get();
		for(TodoTemplate temp : retPT.getTodoTemplates()) {
			System.out.println(temp.getTodoName() + " " + temp.getId());
			System.out.println("Adding one level to todos");
			List<TodoTemplate> childTodoTemplates = new ArrayList<>();
			for(int i = 1 ;i <=2 ;i++) {
				TodoTemplate child = new TodoTemplate();
				child.setTodoName("ChildOf"+temp.getTodoName()+" "+i);
				child.setParentTodoTemplate(temp);
				child.setProjectTemplate(retPT);
				childTodoTemplates.add(child);
			}
			temp.setChildTodoTemplates(childTodoTemplates);
			entityManager.persistAndFlush(temp);
		}
		
		System.out.println("Get all the todo templates");
		
		
		retPT = projectTempRepo.findById(projTem.getId()).get();

		for(TodoTemplate temp : retPT.getTodoTemplates()) {
			System.out.println(temp.getTodoName() + " " + temp.getId());
			for(TodoTemplate child : temp.getChildTodoTemplates()) {
				System.out.println("Child="+child.getTodoName());
			}
		}

	}
}
