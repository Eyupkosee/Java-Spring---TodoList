package com.example.todos.business.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteTodoRequest {
	private int id;
}

// buna hiç gerek yok id ile de silebiliyormuşum.