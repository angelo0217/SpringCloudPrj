package com.consumer.client;


import com.consumer.hystrix.ComputeClientHystrix;
import com.consumer.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "provider-service", fallback = ComputeClientHystrix.class)
public interface ComputeClient {
    @GetMapping("/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

    @GetMapping("/getUser")
    Object getUser();

    @PostMapping("/user")
    User user(@RequestBody User user);
}