package com.with.www.withboot.home.dto;

import lombok.Data;

/**
 * index 페이지 DTO
 */
@Data
public class Home {
    private String title;
    private String content;

    public Home(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
