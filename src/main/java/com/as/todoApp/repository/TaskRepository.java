package com.as.todoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.as.todoApp.Model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
}
