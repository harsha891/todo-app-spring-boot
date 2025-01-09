package com.example.ToDoApplication.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ToDoApplication.models.Tasks;
import com.example.ToDoApplication.repositories.TasksRepository;
import com.example.ToDoExceptions.TaskAlreadyExistsException;
import com.example.ToDoExceptions.TaskNotFoundException;

@Service
public class TasksService {

	@Autowired
	private TasksRepository tasksRepository;

	public Tasks createNewTask(Tasks task) {
		Optional<Tasks> findTask = tasksRepository.findByTask(task.getTask().toLowerCase());
		if(findTask.isPresent())
			throw new TaskAlreadyExistsException("Task already exist with task id - " + findTask.get().getId());
			
		task.setTask(task.getTask().toLowerCase());
		return tasksRepository.save(task);
	}

	public List<Tasks> getAllTask() {
		return tasksRepository.findAll();
	}

	public Tasks updateTask(Long id, Tasks task) {
		Optional<Tasks> exTask = tasksRepository.findById(id);
		
		if(exTask.isPresent()) {
			task.setId(id);
			return tasksRepository.save(task);
		}
		throw new TaskNotFoundException("Task <" + id + "> does not exist.");
	}

	public void deleteTask(Long id) {
		if(tasksRepository.existsById(id)) {
			tasksRepository.deleteById(id);
			return;
		}
		throw new TaskNotFoundException("Task <" + id + "> does not exist.");
	}

	public Optional<Tasks> getTaskById(Long id) throws Exception {
		try {
			return tasksRepository.findById(id);
		}
		catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
