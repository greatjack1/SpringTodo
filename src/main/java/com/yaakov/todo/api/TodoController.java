package com.yaakov.todo.api;

import java.util.List;

import com.yaakov.todo.exceptions.TodoItemNotFoundException;
import com.yaakov.todo.models.TodoItem;
import com.yaakov.todo.repositories.TodoItemRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TodoController {

    private final TodoItemRepository repository;

    TodoController(TodoItemRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/todoitems")
    List<TodoItem> all() {
        return repository.findAll();
    }

    @PostMapping("/todoitems")
   TodoItem newTodoItem(@RequestBody TodoItem item) {
        return repository.save(item);
    }


    @GetMapping("/todoitems/{id}")
    TodoItem one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TodoItemNotFoundException(id));
    }

    @PutMapping("/todoitems/{id}")
   TodoItem replaceItem(@RequestBody TodoItem item, @PathVariable Long id) {
        return repository.findById(id)
                .map(todoItem -> {
                    todoItem.setTitle(item.getTitle());
                    todoItem.setDescription(item.getDescription());
                    return repository.save(todoItem);
                })
                .orElseGet(() -> {
                    item.setId(id);
                    return repository.save(item);
                });
    }

    @DeleteMapping("/todoitems/{id}")
    void deleteItem(@PathVariable Long id) {
        repository.deleteById(id);
    }
}