package com.zosh.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.exceptions.TaskException;
import com.zosh.exceptions.UserException;
import com.zosh.modal.Task;
import com.zosh.modal.User;
import com.zosh.response.ApiResponse;
import com.zosh.service.TaskService;
import com.zosh.service.UserService;

@RestController()
@RequestMapping("/api")
public class TaskController {
	
	private TaskService taskService;
	private UserService userService;
	
	public TaskController(TaskService taskService,UserService userService) {
		this.taskService=taskService;
		this.userService=userService;
	}
	
	@PostMapping("/tasks/create")
	public ResponseEntity<Task> createTaskHandler(@RequestBody Task task, @RequestHeader("Authorization") String jwt) throws UserException{
		System.out.println("task create ");
		User user =userService.getUserProfile(jwt);
		
		Task createdTask = taskService.createTask(task, user);
		
		return new ResponseEntity<Task>(createdTask,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/tasks")
	public ResponseEntity<List<Task>> getAllTaskHandler(@RequestHeader("Authorization") String jwt,            
			@RequestParam(value = "today", required = false) boolean today,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "priority", required = false) String priority) throws UserException{
		
		System.out.println(" today - "+today+" status - "+status +" priority - "+priority);
		
		User user =userService.getUserProfile(jwt);
		
		List<Task> tasks = taskService.getAllTask(status, priority, today);
		
		return new ResponseEntity<>(tasks,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/tasks/update/{taskId}")
	public ResponseEntity<Task> getAllTaskHandler(@PathVariable Integer taskId, @RequestHeader("Authorization") String jwt) throws UserException, TaskException{
		
		User user =userService.getUserProfile(jwt);
		
		Task task = taskService.updateTaskStatus(taskId, user);
		
		return new ResponseEntity<>(task,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/tasks/delete/{taskId}")
	public ResponseEntity<ApiResponse> deleteTaskHandler(@PathVariable Integer taskId, @RequestHeader("Authorization") String jwt) throws UserException, TaskException{
		
		User user =userService.getUserProfile(jwt);
		
		String task = taskService.deleteTaskById(taskId, user);
		
		ApiResponse res=new ApiResponse(task,true);
		
		return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
	}

}
