package com.consumer.hystrix;

import com.consumer.client.ComputeClient;
import com.consumer.model.User;
import org.springframework.stereotype.Component;

@Component
public class ComputeClientHystrix implements ComputeClient {

    @Override
    public Integer add(Integer a, Integer b) {
        return -9999;
    }

    @Override
    public Object getUser() {
        return null;
    }

    @Override
    public User user(User user) {
        return null;
    }
}
