package com.mariski.springBootToDo.Controller;

import com.mariski.springBootToDo.Model.Todo;
import com.mariski.springBootToDo.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping("/api/todo/addTodo")
    public List<Todo> addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    @PostMapping("/api/todo/addTodos")
    public List<Todo> addTodos(@RequestBody List<Todo> todos) {
        return todoService.addTodos(todos);
    }

    @GetMapping("/api/todo/getTodo/{id}")
    public Todo getTodo(@PathVariable int id) {
        return todoService.getTodo(id);
    }

    @GetMapping("/api/todo/getTodos")
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @PutMapping("/api/todo/updateTodo/{id}/{state}")
    public List<Todo> updateTodo(@PathVariable int id, @PathVariable boolean state) {
        return todoService.updateTodo(id, state);
    }

    @DeleteMapping("/api/todo/deleteTodo/{id}")
    public List<Todo> deleteTodo(@PathVariable int id) {
        return todoService.deleteTodo(id);
    }

    @DeleteMapping("/api/todo/deleteTodos")
    public List<Todo> deleteAllTodos() {
        return todoService.deleteAllTodos();
    }
}
