package com.zosh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.modal.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
