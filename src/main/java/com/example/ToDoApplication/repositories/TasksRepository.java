package com.example.ToDoApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ToDoApplication.models.Tasks;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {

}
