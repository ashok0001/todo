package com.zosh.service;

import java.time.LocalDateTime;
import java.util.List;

import com.zosh.modal.Task;
import com.zosh.modal.User;
import com.zosh.repository.TaskRepository;

public class TaskServiceImplementation implements TaskService {
	
	private TaskRepository taskRepository;
	
	public TaskServiceImplementation(TaskRepository taskRepository) {
		taskRepository=taskRepository;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public Task createTask(Task task,User user) {
		
		Task newTask=new Task();
		newTask.setCreatedAt(LocalDateTime.now());
		newTask.setDeadline(task.getDeadline());
		newTask.setDescription(task.getDescription());
		newTask.setId(task.getId());
		newTask.setPriority(task.getPriority());
		newTask.setStatus(task.getStatus());
		newTask.setTitle(task.getTitle());
		newTask.setUser(user);
		
		
		return taskRepository.save(newTask);
		
	}

	@Override
	public List<Task> findTaskByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> findTodaysTask(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		return null;
	}

}
