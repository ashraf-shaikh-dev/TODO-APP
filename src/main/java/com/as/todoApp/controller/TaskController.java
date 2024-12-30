package com.as.todoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.as.todoApp.Model.Task;
import com.as.todoApp.service.TaskService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Get all todos
    @GetMapping
    public List<Task> getAllTodos() {
        return taskService.getAllTasks();
    }

    // Get a todo by ID
    @GetMapping("/{id}")
    public Optional<Task> getTodoById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    // Create a new todo
    @PostMapping
    public Task createTodo(@RequestBody Task todo) {
        return taskService.createTask(todo.getName(),todo.getDescription(), todo.isCompleted());
    }


    // Update an existing todo
    @PutMapping("/{id}")
    public Task updateTodo(@PathVariable Long id, @RequestBody Task todo) {
        return taskService.updateTask(id,todo.getName() ,todo.getDescription(), todo.isCompleted());
    }

    // Delete a todo
    @DeleteMapping("/{id}")
    public boolean deleteTodo(@PathVariable Long id) {
        return taskService.deleteTask(id);
    }

}
