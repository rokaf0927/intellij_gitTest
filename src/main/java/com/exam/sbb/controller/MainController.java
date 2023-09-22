package com.exam.sbb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    
    @RequestMapping("/sbb")
    public void index(){
        System.out.println("first start");
    }
}
