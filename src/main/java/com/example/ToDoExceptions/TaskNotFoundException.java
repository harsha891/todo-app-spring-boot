package com.example.ToDoExceptions;

public class TaskNotFoundException extends RuntimeException {
	public TaskNotFoundException(String msg) {
		super(msg);
	}

}
