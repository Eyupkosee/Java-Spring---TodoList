package com.example.todos.business.conretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todos.business.abstracts.TodoService;
import com.example.todos.business.dto.request.CreateTodoRequest;
import com.example.todos.business.dto.request.UpdateTodoRequest;
import com.example.todos.business.dto.response.GetAllTodoResponse;
import com.example.todos.dataAccess.TodoRepository;
import com.example.todos.entity.Todo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TodoManager implements TodoService{
	
	private TodoRepository todoRepository; 
	

	@Override
	public List<GetAllTodoResponse> getAll() {
		
		List<Todo> todos = todoRepository.findAll();

		
		List<GetAllTodoResponse> todoResponse = new ArrayList<GetAllTodoResponse>();
		
		for (Todo todo : todos) {
			GetAllTodoResponse responseItem = new GetAllTodoResponse();
			responseItem.setId(todo.getId());
			responseItem.setTitle(todo.getTitle());
			responseItem.setDescription(todo.getDescription());
			responseItem.setStatus(todo.getStatus());
			responseItem.setCreateAt(todo.getCreateAt());
            todoResponse.add(responseItem); // bunu unutma

		}
		
		return todoResponse;
	}

	@Override
	public void add(CreateTodoRequest addTodoRequest) {
		Todo todo = new Todo();
		todo.setTitle(addTodoRequest.getTitle());
		todo.setDescription(addTodoRequest.getDescription());
		todo.setStatus(addTodoRequest.getStatus());
		//todo.setCreateAt(LocalDateTime.now()); otomatik set edilecek
		todoRepository.save(todo);
		
	}

	@Override
	public void delete(Integer id) {
		todoRepository.deleteById(id);
	}

	@Override
	public void update(UpdateTodoRequest updateTodoRequest) {
		
		  // Önce güncellenecek todo'yu ID ile buluyoruz
	    Todo todoToUpdate = todoRepository.findById(updateTodoRequest.getId())
	            .orElseThrow(() -> new RuntimeException("Todo not found")); // ID bulunamazsa hata fırlatır
	    
	    todoToUpdate.setTitle(updateTodoRequest.getTitle());
	    todoToUpdate.setDescription(updateTodoRequest.getDescription());
	    todoToUpdate.setStatus(updateTodoRequest.getStatus());
		
		todoRepository.save(todoToUpdate);
	}

	@Override
	public Todo getTodoById(Integer id) {
		Todo myTodo = todoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Todo not found")); // ID bulunamazsa hata fırlatır		
		
		return myTodo;
	}

	

	

}
