package com.example.ToDoApplication.Response;

import java.util.List;

import com.example.ToDoApplication.models.Tasks;

public class TaskResponses {
	private String msg;
	private List<Tasks> tasks;
	
	public TaskResponses(String msg, List<Tasks> task) {
		this.msg = msg;
		this.tasks = task;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<Tasks> getTask() {
		return tasks;
	}
	public void setTask(List<Tasks> task) {
		this.tasks = task;
	}
	
}
