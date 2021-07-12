package com.mariski.springBootToDo.Service;

import com.mariski.springBootToDo.Model.Todo;
import com.mariski.springBootToDo.Repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoService;

    public static final Logger log = LoggerFactory.getLogger(TodoService.class);


}
