package com.zozo.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
