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

    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
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

    public String updateTodo(int id, boolean done) {
        Todo todoToUpdate = todoRepository.findById(id).orElse(null);
        if (!todoToUpdate.equals(null)) {
            todoToUpdate.setDone(done);
            todoRepository.save(todoToUpdate);
            return "State of Todo is updated";
        }
        else
            return "Failed to update";
    }

    public String deleteTodo(int id) {
        todoRepository.deleteById(id);
        return "Todo of id " + id + " was successfully deleted";
    }

    public String deleteAllTodos() {
        todoRepository.deleteAll();
        return "Todos were removed";
    }
}
