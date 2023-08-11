package com.example.gptv1.controller;

import io.github.asleepyfish.util.OpenAiUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class ChatController {

    @PostMapping("/chatTest")//提问题的接口
    public List<String> chatTest(@RequestParam String content) {
        return OpenAiUtils.createChatCompletion(content, "testUser");
    }

    //生成图片的接口
    @GetMapping("/downloadImage")
    public void downloadImage(@RequestParam String prompt, HttpServletResponse response) {
         OpenAiUtils.downloadImage(prompt, response);
    }

    @GetMapping("/streamChat")//流式回答输出到IDEA控制台
    public void streamChat(String content) {
        // OpenAiUtils.createStreamChatCompletion(content, System.out);
        // 下面的默认和上面这句代码一样，是输出结果到控制台
        OpenAiUtils.createStreamChatCompletion(content);
    }



    @GetMapping("/streamChatWithWeb")//流式回答输出到浏览器页面
    public void streamChatWithWeb(String content, HttpServletResponse response) throws IOException {
        // 需要指定response的ContentType为流式输出，且字符编码为UTF-8
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");
        OpenAiUtils.createStreamChatCompletion(content, response.getOutputStream());
    }

}
