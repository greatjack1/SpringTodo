package com.yaakov.todo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class TodoItem {

    private @Id @GeneratedValue Long id;
    private String title;
    private String description;

  public  TodoItem() {}

  public  TodoItem(String title, String description){
        this.title = title;
        this.description = description;
    }
}
