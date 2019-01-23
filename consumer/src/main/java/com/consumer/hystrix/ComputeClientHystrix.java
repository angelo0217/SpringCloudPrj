package com.consumer.hystrix;

import com.consumer.client.ComputeClient;
import com.consumer.model.User;
import feign.hystrix.FallbackFactory;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class ComputeClientHystrix implements ComputeClient {

    @Override
    public Integer add(Integer a, Integer b) {
        return -9999;
    }

    @Override
    public Object getUser() {
        User user = new User();
        user.setNamee("get user fail");
        return user;
    }

    @Override
    public User user(User user) {
        return user;
    }
}
