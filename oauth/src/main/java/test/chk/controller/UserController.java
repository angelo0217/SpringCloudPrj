package test.chk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created on 2019/1/21
 *
 * @author dean
 * @email loveangelo0217@gmail.com
 * @since 1.0
 */
@RestController
public class UserController {

    @GetMapping("/user")
    public Principal getUser(Principal principal) {
        System.out.println("=============get Oauth User start");
        System.out.println(principal.toString());
        System.out.println(principal.getName());
        return principal;
    }
}
