package com.mariski.springBootToDo.Service;

import com.mariski.springBootToDo.Model.Todo;
import com.mariski.springBootToDo.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> addTodo(Todo todo) {
        todoRepository.save(todo);
        return todoRepository.findAll();
    }

    public List<Todo> addTodos(List<Todo> todos) {
        return todoRepository.saveAll(todos);
    }

    public Todo getTodo(int id) {
        return todoRepository.findById(id).orElse(null);
    }

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public List<Todo> updateTodo(int id, boolean done) {
        Todo todoToUpdate = todoRepository.findById(id).orElse(null);
        if (!todoToUpdate.equals(null)) {
            todoToUpdate.setDone(done);
            todoRepository.save(todoToUpdate);
            return todoRepository.findAll();
        }
        else
            return null;
    }

    public List<Todo> deleteTodo(int id) {
        todoRepository.deleteById(id);
        return todoRepository.findAll();
    }

    public List<Todo> deleteAllTodos() {
        todoRepository.deleteAll();
        return todoRepository.findAll();
    }
}
