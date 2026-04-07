package com.with.www.withboot.home.controller;

import com.with.www.withboot.home.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final HomeService homeService;

    @Autowired
    public HomeController(
        HomeService homeService
    ) {
        this.homeService = homeService;
    }

    @GetMapping("/")
    public String home(
        ModelMap model
    ) throws Exception {

        return "index";
    }
}
