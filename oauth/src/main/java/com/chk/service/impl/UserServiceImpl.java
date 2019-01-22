package com.chk.service.impl;

import com.chk.Const;
import com.chk.util.EncryptUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Vector;

/**
 * Created on 2018-12-19
 *
 * @author dean
 * @email loveangelo0217@gmail.com
 * @since 1.0
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new Vector<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ADMIN"));

        return new User("user", EncryptUtil.getSecurityPwd("12345"), authorities);
    }

}
