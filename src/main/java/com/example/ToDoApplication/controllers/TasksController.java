package com.example.ToDoApplication.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ToDoApplication.models.Tasks;
import com.example.ToDoApplication.services.TasksService;

@RestController
@RequestMapping("api/tasks")
public class TasksController {

	@Autowired
	private TasksService tasksService;

	@GetMapping("/getAllTasks")
	public List<Tasks> getAllTasks() {
		List<Tasks> result = null;
		try {
			result = tasksService.getAllTask();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@PostMapping("/createTask")
	public Tasks createTask(@RequestBody Tasks task) {
		return tasksService.createNewTask(task);
	}
	
	@PutMapping("/updateTask/{id}")
	public Tasks updateTask(@PathVariable Long id, @RequestBody Tasks task) {
		return tasksService.updateTask(id, task);
	}
	
	@DeleteMapping("/deleteTask/{id}")
	public boolean deleteTask(@PathVariable Long id) {
		return tasksService.deleteTask(id);
	}
	
	@GetMapping("/getTaskById/{id}")
	public Optional<Tasks> getTaskById(@PathVariable Long id) {
		return tasksService.getTaskById(id);
	}
}
