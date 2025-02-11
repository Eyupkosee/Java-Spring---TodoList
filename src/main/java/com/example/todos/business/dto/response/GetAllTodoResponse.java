package com.example.todos.business.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTodoResponse {
	private int id;
	private String title;
	private String description;
	private Boolean status;
	private LocalDateTime createAt;
	
}
