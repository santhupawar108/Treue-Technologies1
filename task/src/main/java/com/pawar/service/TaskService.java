package com.pawar.service;

import java.util.List;
import java.util.Optional;

import com.pawar.model.Task;
import com.pawar.model.User;



public interface TaskService {
	
	List<Task> getTasksDueToday();
	
	
	Task createTask(Task task);


	List<Task> findAll();


	boolean existsByUser(Optional<User> user);


	


	List<Task> getTasksForUser(Optional<User> user);

}
