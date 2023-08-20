package com.pawar.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawar.model.Task;
import com.pawar.model.User;
import com.pawar.repo.TaskRepository;



@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public List<Task> getTasksDueToday() {
		// TODO Auto-generated method stub
		LocalDate today = LocalDate.now();
        return taskRepository.findByDueDate(today);
	}

	@Override
	public Task createTask(Task task) {
		// TODO Auto-generated method stub
		return taskRepository.save(task);
	}

	@Override
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}

	@Override
	public boolean existsByUser(Optional<User> user) {
		// TODO Auto-generated method stub
		return taskRepository.existsByUser(user);
	}

	
	@Override
	public List<Task> getTasksForUser(Optional<User> user) {
		// TODO Auto-generated method stub
		return taskRepository.findByUser(user);
	}

}
