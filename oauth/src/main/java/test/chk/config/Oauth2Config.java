package test.chk.config;

import test.chk.Const;
import test.chk.service.impl.UserServiceImpl;
import test.chk.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * Created on 2018-12-19
 *
 * @author dean
 * @email loveangelo0217@gmail.com
 * @since 1.0
 */
@Configuration
@EnableResourceServer
@EnableAuthorizationServer
public class Oauth2Config extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserServiceImpl userService;

//    @Autowired
//    DemoClientDetailService demoClientDetailService;

//    @Autowired
//    @Qualifier("tokenRedis")
//    RedisConnectionFactory redisConnectionFactory;

    /**
     *  配置token獲取合驗證時的策略
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

        security.allowFormAuthenticationForClients();
//        security
//                .tokenKeyAccess("permitAll()")
//                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.withClientDetails(demoClientDetailService);
        clients.inMemory()
                .withClient("admin")
                .authorizedGrantTypes("password")
                .authorities("ROLE_ADMIN")
                .scopes("all")
                .resourceIds(Const.DEMO_RESOURCE_ID)
                .secret(EncryptUtil.getSecurityPwd("abc123"))
                .accessTokenValiditySeconds(360)
                .and()

                .withClient("client_r")
                .authorizedGrantTypes("password","refresh_token")
                .authorities("ROLE_CLIENT")
                .scopes("read")
                .resourceIds(Const.DEMO_RESOURCE_ID)
                .secret(EncryptUtil.getSecurityPwd("secret"))
                .accessTokenValiditySeconds(360)
                .and()

                .withClient("client_w")
                .authorizedGrantTypes("password","refresh_token")
                .authorities("ROLE_CLIENT")
                .scopes("write")
                .resourceIds(Const.DEMO_RESOURCE_ID)
                .secret(EncryptUtil.getSecurityPwd("secret"))
                .accessTokenValiditySeconds(360);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // 配置tokenStore
        endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
                .authenticationManager(authenticationManager)
                .userDetailsService(userService)
//                .tokenStore(new MyRedisTokenStore(redisConnectionFactory));
                .tokenStore(memoryTokenStore());
    }
    @Bean
    public TokenStore memoryTokenStore() {
        return new InMemoryTokenStore();
    }
//    @Bean
//    public TokenStore redisTokenStore() {
//        MyRedisTokenStore redis = new MyRedisTokenStore(redisConnectionFactory);
//        return redis;
//    }
}
