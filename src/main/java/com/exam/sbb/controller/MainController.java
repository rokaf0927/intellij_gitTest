package com.exam.sbb.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class MainController{

    private int increaseNo = -1;
    
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

    @GetMapping("/plus")
    public int showPlus(int a, int b){
        return a + b;
    }

    @GetMapping("/plus2")
    public void showPlus2(HttpServletRequest req, HttpServletResponse res) throws IOException
    {
        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));

        res.getWriter().append(a+b+"");

    }

    @GetMapping("/mbti/{name}")
    public String showMbti(@PathVariable String name)
    {
        return switch (name){
            case "홍길동" -> "INFP";
            case "홍길순" -> "INFP";
            case "임꺽정" -> "INFP";
            case "박상원" -> "INFP";
            default -> "모름";
        };

    }

    @GetMapping("/minus")
    public int showMinus(int a, int b){
        return a - b;
    }

    @GetMapping("/increase")
    public int showIncrease(){
//        int no = 0;
        increaseNo++;
        return increaseNo;
    }

    @GetMapping("/gugudan")
    public String showGugudan(int dan, int limit){

//        String rs = "";
//        for(int i=1 ; i<=limit ; i++){
//            rs += "%d * %d = %d<br>\n".formatted(dan, i, dan * i);
//        }
//        return rs;
        return IntStream.rangeClosed(1,limit)
                .mapToObj(i -> "%d * %d = %d".formatted(dan, i, dan * i))
                .collect(Collectors.joining("<br>"));
    }
}
