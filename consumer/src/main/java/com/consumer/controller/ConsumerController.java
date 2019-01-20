package com.consumer.controller;

import com.consumer.client.ComputeClient;
import com.consumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConsumerController{
    @Autowired
    ComputeClient computeClient;

    @GetMapping("/add")
    public @ResponseBody Integer add() {
        System.out.println(">>>>>>>>>>>>>");
        return computeClient.add(10, 20);
    }
    @GetMapping("/getUser")
    public @ResponseBody Object getUser(){
        return  computeClient.getUser();
    }
    @PostMapping("/user")
    public @ResponseBody User user() {
        User u = new User();
        u.setNamee("Dean");
        u.setAge(10);
        return computeClient.user(u);
    }
}
