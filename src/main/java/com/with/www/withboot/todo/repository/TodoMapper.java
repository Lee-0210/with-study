package com.with.www.withboot.todo.repository;

import com.with.www.withboot.home.dto.Home;
import com.with.www.withboot.todo.dto.Todo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {

    List<Todo> getTodos() throws Exception;

    int saveTodos(Todo todo) throws Exception;

    int deleteTodos(Todo todo) throws Exception;
}
