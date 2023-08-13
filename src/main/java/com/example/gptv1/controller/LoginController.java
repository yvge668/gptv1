package com.example.gptv1.controller;

import com.example.gptv1.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @PostMapping("login")
    public Result login(String id ,String password){

        String username0 = "美羊羊";
        String password0 = "123";

        if(username0.equals(id)&&password0.equals(password))
        {
            return Result.success("登陆成功");
        }else {
            return Result.success("登录失败");
        }




    }
}

