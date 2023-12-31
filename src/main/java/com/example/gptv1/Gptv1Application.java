package com.example.gptv1;

import io.github.asleepyfish.annotation.EnableChatGPT;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableChatGPT//使用chatGPT插件
public class Gptv1Application {

    public static void main(String[] args) {
        SpringApplication.run(Gptv1Application.class, args);
    }

}
