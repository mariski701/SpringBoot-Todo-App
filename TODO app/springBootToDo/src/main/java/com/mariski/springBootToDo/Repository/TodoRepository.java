package com.mariski.springBootToDo.Repository;

import com.mariski.springBootToDo.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
