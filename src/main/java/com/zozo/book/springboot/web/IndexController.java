package com.zozo.book.springboot.web;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zozo.book.springboot.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
//        결과를 posts - index.mustache로 전달역할하는 저장 객체(==Model)
        return "index";
    }
}
