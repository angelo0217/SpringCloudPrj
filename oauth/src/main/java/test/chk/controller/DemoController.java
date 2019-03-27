package test.chk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
