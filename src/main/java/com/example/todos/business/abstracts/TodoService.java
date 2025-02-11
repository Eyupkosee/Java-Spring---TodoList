package com.example.todos.business.abstracts;

import java.util.List;

import com.example.todos.business.dto.request.CreateTodoRequest;
import com.example.todos.business.dto.request.UpdateTodoRequest;
import com.example.todos.business.dto.response.GetAllTodoResponse;
import com.example.todos.entity.Todo;

public interface TodoService {

	List<GetAllTodoResponse> getAll();
	
	void add(CreateTodoRequest addTodoRequest);
	
	void delete(Integer id);
	
	void update(UpdateTodoRequest updateTodoRequest);
	
	public Todo getTodoById(Integer id);

}
