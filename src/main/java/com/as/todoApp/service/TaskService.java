package com.as.todoApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.as.todoApp.Model.Task;
import com.as.todoApp.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {


	@Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(String name, String description, boolean completed) {
        Task task = new Task();
        task.setName(name);
        task.setDescription(description);
        task.setCompleted(completed);
        return taskRepository.save(task); // Save to MySQL
    }

    public Task updateTask(Long id, String name,  String description, boolean completed) {
        Optional<Task> existingTask = taskRepository.findById(id);
        if (existingTask.isPresent()) {
            Task task = existingTask.get();
            task.setName(name);
            task.setDescription(description);
            task.setCompleted(completed);
            return taskRepository.save(task); // Update in MySQL
        }
        throw new RuntimeException("Task not found");
    }

    public boolean deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id); // Delete from MySQL
            return true;
        }
        return false;
    }

	
}
