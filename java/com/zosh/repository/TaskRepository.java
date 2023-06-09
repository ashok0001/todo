package com.zosh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zosh.modal.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	@Query("SELECT t from Task t where t.user.id=:userId")
	public List<Task> getUsersTasks(@Param("userId") Integer UserId);
}
