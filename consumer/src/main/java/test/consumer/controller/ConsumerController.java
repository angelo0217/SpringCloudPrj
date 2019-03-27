package test.consumer.controller;

import test.consumer.client.ComputeClient;
import test.consumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
