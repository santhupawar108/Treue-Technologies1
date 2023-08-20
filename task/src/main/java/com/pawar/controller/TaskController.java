package com.pawar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pawar.model.Task;
import com.pawar.model.User;
import com.pawar.repo.TaskRepository;
import com.pawar.repo.UserRepository;
import com.pawar.service.TaskService;



@Controller
public class TaskController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private TaskService taskService;

	

	    @GetMapping("/")
	    public String showTaskList(Model model) {
	    	Optional<User> user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
	    	
	    	if(user.isPresent()&&taskService.existsByUser(user)) {
	         List<Task> tasks = taskService.getTasksForUser(user);
	         model.addAttribute("tasks", tasks);
	    	}
	    	
	        return "list";
	    }
	    @GetMapping("/all")
	    public String showAllTaskList(Model model) {
	       List<Task> tasks = taskService.findAll();
	        //List<Task> tasks = taskService.getTasksDueToday();
	        model.addAttribute("tasks", tasks);
	        return "list";
	    }

	    @GetMapping("/tasks/new")
	    public String showCreateTaskForm(Model model) {
	    	
	        model.addAttribute("task", new Task());
	        return "createtask";
	    }

	    @PostMapping("/tasks/new")
	    public String createTask(@Validated Task task, BindingResult result, Model model) {
	    	
	   	    	
	        if (result.hasErrors()) {
	            return "createtask";
	        }
	        

			Optional<User> user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
	      
	        if (user.isPresent()) {
	        	task.setUser(user.get());
	        	 task.setStatus("Pending");
	 	        taskService.createTask(task);
	            
	        }
	        

	       // task.setStatus("Pending");
	      //  taskService.createTask(task);
	        return "redirect:/";
	    }

	    @GetMapping("/edit")
	    public String showEditTaskForm(@RequestParam("taskId") long id, Model model) {
	        Task task = taskRepository.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("Invalid task Id: " + id));

	        model.addAttribute("task", task);
	        return "createtask";
	    }

	    

	    @GetMapping("/delete")
	    public String deleteTask(@RequestParam("taskId") long id) {
	        Task task = taskRepository.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("Invalid task Id: " + id));

	        taskRepository.delete(task);
	        return "redirect:/";
	    }

	    @GetMapping("/complete")
	    public String completeTask(@RequestParam("taskId") long id) {
	        Task task = taskRepository.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("Invalid task Id: " + id));

	        task.setStatus("Completed");
	        taskRepository.save(task);
	        return "redirect:/";
	    }
	
	    
	
	    
	    


}   // class end
