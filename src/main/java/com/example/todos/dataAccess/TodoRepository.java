package com.example.todos.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todos.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{

}
