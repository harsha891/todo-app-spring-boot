package com.example.ToDoApplication.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Tasks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String task;
	private char status;
	private boolean completed;
	@Column(updatable = false)
	private LocalDate createdAt;

	private LocalDate updatedAt;

	private LocalDate dueDate;

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

	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDate.now();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = LocalDate.now();
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
}
