package com.example.gptv1.controller;


import com.example.gptv1.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("chat")
public class GPTv1Controller {


    private  Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("{num}")//传路径参数
    public String hello(@PathVariable int num){

        return "我接收到了: "+num;
    }

    @GetMapping
    public String hello1(@RequestParam String parameter){
        return "我接收到了: "+parameter;
    }


    @PostMapping
    public String hello3(@RequestBody Map<String, String> user){
        //通过key获取 值
        String id = user.get("id");
        String name = user.get("name");
        return "我接收到了: "+id+name;
    }


    @PostMapping("user")
    public String hello4(@RequestBody User user){
        return "我接收到了"+user.toString();
    }



}
