package com.consumer.hystrix;

import com.consumer.client.ComputeClient;
import com.consumer.model.User;
import feign.hystrix.FallbackFactory;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created on 2019/1/23
 *
 * @author dean
 * @email loveangelo0217@gmail.com
 * @since 1.0
 */
@Component
public class ComputeClientFallBack implements FallbackFactory<ComputeClient> {
    @Override
    public ComputeClient create(Throwable throwable) {
        boolean auth = false;
        String msg = throwable == null ? "" : throwable.getMessage();
        if (!StringUtils.isEmpty(msg)) {
            System.out.println(msg);
            if(msg.contains("unauthorized")){
                auth = true;
            }
        }
        return new ComputeClient() {
            @Override
            public Integer add(Integer a, Integer b) {
                return -8888;
            }

            @Override
            public Object getUser() {
                if(true){
                    return "權限錯誤";
                }else {
                    return "暫時不通";
                }
            }

            @Override
            public User user(User user) {
                user.setNamee("get user fail");
                return user;
            }
        };
    }
}
