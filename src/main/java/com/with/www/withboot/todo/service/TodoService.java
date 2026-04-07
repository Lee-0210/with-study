package com.with.www.withboot.todo.service;

import com.with.www.withboot.home.dto.Home;
import com.with.www.withboot.todo.dto.Todo;
import java.util.List;

public interface TodoService {

    /**
     * todo 페이지 데이터 조회
     */
    List<Todo> getTodos() throws Exception;

    boolean saveTodos(Todo todo) throws Exception;

    boolean deleteTodos(Todo todo) throws Exception;
}
