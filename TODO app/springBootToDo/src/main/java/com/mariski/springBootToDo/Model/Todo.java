package com.mariski.springBootToDo.Model;

import lombok.Data;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;

@Data
@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue
    @Column(name = "todo_id", unique = true, length = 128)
    private int id;
    @Column(name = "todo_text")
    private String text;
    @Column(name = "todo_done")
    private boolean done;
}
