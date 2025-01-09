package com.example.ToDoApplication.Response;

import com.example.ToDoApplication.models.Tasks;

public class TaskResponse {
	private String msg;
	private Tasks task;
	
	public TaskResponse(String msg, Tasks task) {
		this.msg = msg;
		this.task = task;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Tasks getTask() {
		return task;
	}
	public void setTask(Tasks task) {
		this.task = task;
	}
	
}
