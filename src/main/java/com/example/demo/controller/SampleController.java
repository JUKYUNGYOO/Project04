package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
    /*
    화면에 담을 데이터 정보, model = map
     */

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name","주경");
        return "hello";
    }
}
