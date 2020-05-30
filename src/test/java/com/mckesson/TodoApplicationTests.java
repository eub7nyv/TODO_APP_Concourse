package com.mckesson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.mckesson.dto.TaskDTO;
import com.mckesson.service.TaskService;

@ComponentScan("com.mckesson.service.TaskService")
@SpringBootTest
class TodoApplicationTests {

	@Test
	void contextLoads() {
		log.info("--------------contextLoads executed-----------------");
	}

	@Autowired
	private TaskService taskService;

	private static final Logger log = LoggerFactory.getLogger(TodoApplicationTests.class);

	@Test
	public void testSaveTask() {
		log.info("=======================testSaveTask=========================");
		TaskDTO taskDTO = taskService.save("TodoTask_1", "Desc_1", "User_1", "User_1");
		TaskDTO taskDTO2 = taskService.findById(taskDTO.getId());
		log.info("taskDTO.getId()================================================"+taskDTO.getId());

		assertNotNull(taskDTO2);
		assertEquals(taskDTO.getTaskSummary(), taskDTO2.getTaskSummary());
		assertEquals(taskDTO.getTaskDescription(), taskDTO2.getTaskDescription());
		log.info("taskDTO.getTaskSummary()================================================"+taskDTO.getTaskSummary());
		log.info("taskDTO.getTaskDescription()================================================"+taskDTO.getTaskDescription());
	}

	@Test
	public void testGetTask() {
		log.info("=======================testGetTask=========================");
		TaskDTO taskDTO = taskService.save("TodoTask_2", "Desc_2", "User_2", "User_2");
		TaskDTO taskDTO2 = taskService.findById(taskDTO.getId());
		log.info("taskDTO2.getId()================================================"+taskDTO2.getId());

		assertNotNull(taskDTO2);
		assertEquals(taskDTO.getTaskSummary(), taskDTO2.getTaskSummary());
		assertEquals(taskDTO.getTaskDescription(), taskDTO2.getTaskDescription());
		log.info("taskDTO2.getTaskSummary()================================================"+taskDTO2.getTaskSummary());
		log.info("taskDTO2.getTaskDescription()================================================"+taskDTO2.getTaskDescription());
	}
	
	

	@Test
	public void findAllTasks() {
		log.info("=======================findAllTasks=========================");
		taskService.save("TodoTask_4", "Desc_4", "User_4", "User_4");
		taskService.save("TodoTask_5", "Desc_5", "User_5", "User_5");
		
		assertNotNull(taskService.findAll());
	}
	
	
	@Test
	public void testDeleteTask() {
		log.info("=======================testDeleteTask=========================");
		TaskDTO taskDTO = taskService.save("TodoTask_3", "Desc_3", "User_3", "User_3");
		taskService.delete(taskDTO);

		TaskDTO taskDTO2 = taskService.findByTaskSummaryAndTaskDescriptionAndCreatedByAndUpdatedBy("TodoTask_3", "Desc_3", "User_3", "User_3");
		assertNull(taskDTO2);
	}

	
	@Test
	public void deletByTaskIdTest() {
		log.info("=======================deletByTaskIdTest=========================");
		TaskDTO taskDTO = taskService.save("TodoTask_6", "Desc_6", "User_6", "User_6");
		taskService.deleteById(taskDTO.getId());

		TaskDTO taskDTO2 = taskService.findByTaskSummaryAndTaskDescriptionAndCreatedByAndUpdatedBy("TodoTask_6", "Desc_6", "User_6", "User_6");
		assertNull(taskDTO2);
	}


	@Test
	public void testUpdateTask() {
		log.info("=======================testUpdateTask=========================");
		TaskDTO taskDTO = taskService.save("TodoTask_7", "Desc_7", "User_7", "User_7");
		TaskDTO taskDTO2 = taskService.findById(taskDTO.getId());

		assertNotNull(taskDTO2);
		taskDTO2.setTaskDescription("Desc_777");
		taskService.save(taskDTO2);

		TaskDTO taskDTO3 = taskService.findById(taskDTO2.getId());

		assertEquals(taskDTO2.getTaskSummary(), taskDTO3.getTaskSummary());
		assertEquals("Desc_777", taskDTO3.getTaskDescription());
	}
}
