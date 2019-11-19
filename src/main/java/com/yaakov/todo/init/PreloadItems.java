package com.yaakov.todo.init;

import com.yaakov.todo.models.TodoItem;
import com.yaakov.todo.repositories.TodoItemRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
@Slf4j
public class PreloadItems {

    @Bean
    CommandLineRunner initDatabase(TodoItemRepository repository) {
        return args -> {
            log.info("adding " + repository.save(new TodoItem("Leetcode", "practise leetcode for interview later")));
            log.info("adding " + repository.save(new TodoItem("Lunch", "Buy a salad from the grocery store for lunch")));
        };
    }

}
