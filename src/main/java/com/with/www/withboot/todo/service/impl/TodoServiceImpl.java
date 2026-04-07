package com.with.www.withboot.todo.service.impl;

import com.with.www.withboot.todo.dto.Todo;
import com.with.www.withboot.todo.repository.TodoMapper;
import com.with.www.withboot.todo.service.TodoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoMapper mapper;

    @Override
    public List<Todo> getTodos() throws Exception {
        return mapper.getTodos();
    }

    @Override
    public boolean saveTodos(Todo todo) throws Exception {
        boolean success = false;
        try {
            success = mapper.saveTodos(todo) > 0;
        } catch(Exception e) {
            throw new RuntimeException("등록 중 오류가 발생하였습니다.");
        }

        return success;
    }

    @Override
    public boolean deleteTodos(Todo todo) throws Exception {
        boolean success = false;
        try {
            success = mapper.deleteTodos(todo) > 0;
        } catch(Exception e) {
            throw new RuntimeException("삭제 중 오류가 발생하였습니다.");
        }

        return success;
    }
}
