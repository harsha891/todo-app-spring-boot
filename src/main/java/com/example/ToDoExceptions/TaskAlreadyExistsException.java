package com.example.ToDoExceptions;

public class TaskAlreadyExistsException extends RuntimeException{
	public TaskAlreadyExistsException(String msg) {
		super(msg);
	}
}
