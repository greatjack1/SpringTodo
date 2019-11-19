package com.yaakov.todo.exceptions;

public class TodoItemNotFoundException extends RuntimeException {
    public TodoItemNotFoundException(Long id) {
        super("Could not find Todo item with id:  " + id);
    }
}
