package test.consumer.client;


import test.consumer.hystrix.ComputeClientFallBack;
import test.consumer.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(name = "provider-service" , fallback = ComputeClientHystrix.class)// configuration = FeifnOauth2Interceptor.class)
@FeignClient(name = "provider-service" , fallbackFactory = ComputeClientFallBack.class)
public interface ComputeClient {
    @GetMapping("/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

    @GetMapping("/getUser")
    Object getUser();

    @PostMapping("/user")
    User user(@RequestBody User user);

}