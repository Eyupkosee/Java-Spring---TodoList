package com.example.todos.business.rules;

import org.springframework.stereotype.Service;

import com.example.todos.dataAccess.TodoRepository;
import com.example.todos.utilities.excaption.BusinessExcaption;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TodoBusinessRules {
	
	private TodoRepository todoRepository;
	
	public void checkIfTodoIdNotExists(Integer id) {
		if(this.todoRepository.existsById(id) == false) {
			throw new BusinessExcaption("Todo id not exists");
		}
	}
	
}
