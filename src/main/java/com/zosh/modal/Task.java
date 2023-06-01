package com.zosh.modal;

import java.time.LocalDateTime;

import com.zosh.modal.domain.TasksStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Tasks")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String title;
	
	private String description;
	
	@OneToMany
	private User user;
	
	private String Priority;
	
	@Enumerated(EnumType.STRING)
	private TasksStatus Status;
	
	private LocalDateTime Deadline;
	
	private LocalDateTime createdAt;

}
