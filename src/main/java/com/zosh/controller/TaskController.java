package com.zosh.controller;

import com.zosh.service.TaskService;

public class TaskController {
	
	private TaskService taskService;
	
	public TaskController(TaskService taskService) {
		taskService=taskService;
	}

}
