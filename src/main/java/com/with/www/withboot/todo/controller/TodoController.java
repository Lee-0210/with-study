package com.with.www.withboot.todo.controller;

import com.with.www.withboot.home.service.HomeService;
import com.with.www.withboot.todo.dto.Todo;
import com.with.www.withboot.todo.service.TodoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/todos")
public class TodoController {

    private static final String folder = "/todo";

    private final TodoService todoService;

    @Autowired
    public TodoController(
        TodoService todoService
    ) {
        this.todoService = todoService;
    }

    @GetMapping({"/", ""})
    public String getTodos(
        ModelMap model
    ) throws Exception {

        model.addAttribute("todoList", todoService.getTodos());

        return folder + "/todo";
    }

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> saveTodos(
        @RequestBody Todo requestDto
    ) throws Exception {

        todoService.saveTodos(requestDto);

        return ResponseEntity.ok().body("등록되었습니다.");
    }

    @DeleteMapping("/")
    @ResponseBody
    public ResponseEntity<?> deleteTodos(
        @RequestBody Todo requestDto
    ) throws Exception {

        todoService.deleteTodos(requestDto);

        return ResponseEntity.ok().body("삭제되었습니다.");
    }
}
