package test.consumer.hystrix;

import test.consumer.client.ComputeClient;
import test.consumer.model.User;
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
