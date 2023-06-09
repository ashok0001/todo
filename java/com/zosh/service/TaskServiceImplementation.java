package com.zosh.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.zosh.exceptions.TaskException;
import com.zosh.modal.Task;
import com.zosh.modal.User;
import com.zosh.modal.domain.TasksStatus;
import com.zosh.repository.TaskRepository;

@Service
public class TaskServiceImplementation implements TaskService {
	
	private TaskRepository taskRepository;
	
	public TaskServiceImplementation(TaskRepository taskRepository) {
		this.taskRepository=taskRepository;
	}

	@Override
	public Task createTask(Task task,User user) {
		
		Task newTask=new Task();
		newTask.setCreatedAt(LocalDateTime.now());
		newTask.setDeadline(task.getDeadline());
		newTask.setDescription(task.getDescription());
		newTask.setId(task.getId());
		newTask.setPriority(task.getPriority());
		newTask.setStatus(TasksStatus.INPROGRESS);
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
	public List<Task> getAllTask(Integer userId,String status, String priority,boolean today) {
		
		List<Task> tasks=taskRepository.getUsersTasks(userId);
		
		System.out.println("---------- status - "+status + " task status - "+tasks.get(0).getStatus());
		System.out.println(" ---- compare "+ tasks.get(0).getStatus().toString().equals(status));
		
		if(status!=null) {
			tasks=tasks.stream().filter(task -> task.getStatus().toString().equals(status)).collect(Collectors.toList());
		}
		if(priority!=null) {
			tasks=tasks.stream().filter(task->task.getPriority().equals(priority)).collect(Collectors.toList());
		}
		if(today) {
			LocalDateTime todaysDate= LocalDateTime.now();
			tasks=tasks.stream().filter(task->todaysDate.isEqual(task.getDeadline())).collect(Collectors.toList());
		}
		
		return tasks;
	}

	@Override
	public Task updateTaskStatus(Integer taskId,User user) throws TaskException {
		
		Task task=findTaskById(taskId);
		
		if(user.getId().equals(task.getUser().getId())) {
			
		task.setStatus(TasksStatus.COMPLETED);
		
		return taskRepository.save(task);
		}
		
		throw new TaskException("you don't have authority to update this task");
	}

	@Override
	public Task findTaskById(Integer taskId) throws TaskException {
		
		Optional<Task> opt = taskRepository.findById(taskId);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		
		throw new TaskException("Task Not Exist With Id "+taskId);
		
	}

	@Override
	public String deleteTaskById(Integer taskId, User user) throws TaskException {
		Task task=findTaskById(taskId);
		
		if(user.getId().equals(task.getUser().getId())) {
			taskRepository.deleteById(task.getId());
			
			return "Task Deleted Successfully";
		}
		throw new TaskException("you can't delete anothor users task");
		
		
		
		
	}

}
