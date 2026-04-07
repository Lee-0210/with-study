package com.with.www.withboot.todo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Todo {

    private Long id;
    private String title;
    private String content;
    private String status;
    private String priority;
    private LocalDate dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
