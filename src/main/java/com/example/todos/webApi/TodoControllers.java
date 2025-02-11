package com.example.todos.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todos.business.abstracts.TodoService;
import com.example.todos.business.dto.request.CreateTodoRequest;
import com.example.todos.business.dto.request.UpdateTodoRequest;
import com.example.todos.business.dto.response.GetAllTodoResponse;
import com.example.todos.entity.Todo;

@RestController //annotation
@RequestMapping("/api/todos") 
public class TodoControllers {
	private TodoService todoService;
	
	public TodoControllers(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	@GetMapping("/getall")
	List<GetAllTodoResponse> getAll(){
		return todoService.getAll();
	}
	
	@PostMapping("/addtodo")
	public void add(CreateTodoRequest addTodoRequest) {
		this.todoService.add(addTodoRequest);
	}
	
	@DeleteMapping("delete/{id}")
	public void delete(Integer id) {
		this.todoService.delete(id);
	}
	
	@PutMapping("/update")
	public void update(UpdateTodoRequest updateTodoRequest) {
		this.todoService.update(updateTodoRequest);
	}
	
	@GetMapping("/gettodo/{id}")
	public Todo geTodo(Integer id) {
		return todoService.getTodoById(id);
	}
	
}
