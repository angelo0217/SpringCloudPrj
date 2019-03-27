package test.consumer.security.resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created on 2019/1/21
 *
 * @author dean
 * @email loveangelo0217@gmail.com
 * @since 1.0
 */
//@EnableAutoConfiguration
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RestController
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 配置add访问控制，必须认证后才可以访问
                .antMatchers("/add*").authenticated();
    }

    @GetMapping("/getPrinciple")
    public OAuth2Authentication getPrinciple(OAuth2Authentication oAuth2Authentication, Principal principal, Authentication authentication) {
        System.out.println(oAuth2Authentication.getUserAuthentication().getAuthorities().toString());
        System.out.println(oAuth2Authentication.toString());
        System.out.println("principal.toString() " + principal.toString());
        System.out.println("principal.getName() " + principal.getName());
        System.out.println("authentication: " + authentication.getAuthorities().toString());

        return oAuth2Authentication;
    }
}