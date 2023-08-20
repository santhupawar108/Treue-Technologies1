package com.pawar.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawar.model.Task;
import com.pawar.model.User;

public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByDueDate(LocalDate today);

	boolean existsByUser(Optional<User> user);

	

	List<Task> findByUser(Optional<User> user);

}
