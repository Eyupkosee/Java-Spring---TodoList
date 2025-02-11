package com.example.todos.business.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTodoRequest {
	private String title;
	private String description;
	private Boolean status;
	//private LocalDateTime createAt; entity sinifinda func oluşturduk otamatik set ediyor
}
