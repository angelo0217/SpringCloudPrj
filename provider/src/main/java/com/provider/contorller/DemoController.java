package com.provider.contorller;

import com.provider.vo.User;
import org.springframework.web.bind.annotation.*;

/**
 * Created on 2019/1/20
 *
 * @author dean
 * @email loveangelo0217@gmail.com
 * @since 1.0
 */
@RestController
public class DemoController {
//    @Autowired
//    private DiscoveryClient client;

    @GetMapping("/add")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
//        ServiceInstance instance = client.getInstances("provider-service");
        Integer r = a + b;
//        System.out.println("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }
    @GetMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setNamee("Dean");
        user.setAge(30);
        return user;
    }
    @PostMapping("/user")
    public User user(@RequestBody User user) {
        user.setAge(30);
        return user;
    }
}
