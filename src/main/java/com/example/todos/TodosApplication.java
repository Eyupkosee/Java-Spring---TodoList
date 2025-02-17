package com.example.todos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.todos.utilities.excaption.BusinessExcaption;
import com.example.todos.utilities.excaption.ProblemDetails;

@SpringBootApplication
@RestControllerAdvice
public class TodosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodosApplication.class, args);
	}
	
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handLeBusinessException(BusinessExcaption businessExcaption) {
	    ProblemDetails problemDetail = new ProblemDetails();
	    problemDetail.setMessage(businessExcaption.getMessage());
	    return problemDetail;
	}

	
	

}
