package com.exam.sbb.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    
    @RequestMapping("/sbb")
    public String index(){
//        System.out.println("first start");
        return "안녕하세요abcde";
    }

    @GetMapping("/page1")
    public String showGet(){

        return """
                <form method="POST" action="/page2" />
                    <input type="number" name="age" placeholder="나이입력" />
                    <input type="submit" value="page2로 POST 방식으로 이동" />
                </form>
                """;
    }

    @PostMapping("/page2")
    public String showPage2Post(@RequestParam(defaultValue = "0") int age){

        return """
                <h1>입력된 나이: %d</h1>
                <h1>안녕하세요. POST 방식으로 오신걸 환영합니다.</h1>
                """.formatted(age);
    }

    @GetMapping("/page2")
    public String showGet(@RequestParam(defaultValue = "0") int age){

        return """
                <h1>입력된 나이: %d</h1>
                <h1>안녕하세요. GET 방식으로 오신걸 환영합니다.</h1>
                """.formatted(age);
    }
}
