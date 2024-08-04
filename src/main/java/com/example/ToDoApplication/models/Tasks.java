package com.example.ToDoApplication.models;

import jakarta.persistence.*; 

@Entity
public class Tasks { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	// this is the primary key which will be auto generated 
	private Long id;
	private String task; 
	private boolean completed; 

	public Tasks() { 
	} 
	public Tasks(String task, boolean completed) { 
		this.task = task; 
		this.completed = completed; 
	} 
	public Long getId() { 
		return id; 
	} 
	public void setId(Long id) { 
		this.id = id; 
	} 
	public String getTask() { 
		return task; 
	} 
	public void setTask(String task) { 
		this.task = task; 
	} 
	public boolean isCompleted() { 
		return completed; 
	} 
	public void setCompleted(boolean completed) { 
		this.completed = completed; 
	} 
} 

