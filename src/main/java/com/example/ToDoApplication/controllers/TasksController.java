package com.example.ToDoApplication.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ToDoApplication.Response.TaskResponse;
import com.example.ToDoApplication.Response.TaskResponses;
import com.example.ToDoApplication.models.Tasks;
import com.example.ToDoApplication.services.TasksService;

@RestController
@RequestMapping("api/tasks")
public class TasksController {

	@Autowired
	private TasksService tasksService;

	@GetMapping("/getAllTasks")
	public ResponseEntity<TaskResponses> getAllTasks() {
		List<Tasks> result = null;
		try {
			result = tasksService.getAllTask();
			if(result == null || result.size() == 0) return new ResponseEntity<>(new TaskResponses("No Tasks Found", null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new TaskResponses("200", result), HttpStatus.OK);
	}

	@PostMapping("/createTask")
	public ResponseEntity<String> createTask(@RequestBody Tasks task) {
		Tasks result = null;
		try {
		result = tasksService.createNewTask(task);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		if(result == null)
			return new ResponseEntity<>("Task <" + task.getTask() + "> Not Created", HttpStatus.OK);
		return new ResponseEntity<>("Task Created Successfully", HttpStatus.OK);
	}
	
	@PutMapping("/updateTask/{id}")
	public ResponseEntity<String> updateTask(@PathVariable Long id, @RequestBody Tasks task) {
		Tasks result = null;
		try {
			result = tasksService.updateTask(id, task);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		if(result == null)
			return new ResponseEntity<>("Task <" + task.getTask() + "> Not Updated", HttpStatus.OK);
		return new ResponseEntity<>("Task Updated Successfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteTask/{id}")
	public ResponseEntity<String> deleteTask(@PathVariable Long id) {
		try {
			tasksService.deleteTask(id);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>("Task <" + id + "> Deleted Successfully.", HttpStatus.OK);
	}
	
	@GetMapping("/getTaskById/{id}")
	public ResponseEntity<TaskResponse> getTaskById(@PathVariable Long id) {
		Optional<Tasks> result = null;
		try {
			result = tasksService.getTaskById(id);
			}
		catch(Exception e) {
			return new ResponseEntity<>(new TaskResponse(e.getMessage(), null), HttpStatus.NOT_FOUND);
		}
		if(!result.isPresent())
			return new ResponseEntity<>(new TaskResponse("Task <" + id + "> does not exist.", null), HttpStatus.OK);
		return new ResponseEntity<>(new TaskResponse("200", result.get()), HttpStatus.OK);
	}
}
