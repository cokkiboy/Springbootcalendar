package com.app.sharedcalendar.controller;


import jakarta.persistence.Column;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class IndexController {



    @GetMapping("/index")
    public String joinForm() {
        return "/index";
    }
}
