package com.example.ToDoApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ToDoApplication.models.Tasks;
import java.util.List;
import java.util.Optional;


@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {

	@Query("SELECT t FROM Tasks t WHERE t.task = :task")
	Optional<Tasks> findByTask(@Param("task") String task);


}
