package com.provider.security;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.context.request.RequestContextListener;

/**
 * Created on 2019/1/21
 *
 * @author dean
 * @email loveangelo0217@gmail.com
 * @since 1.0
 */
@EnableOAuth2Client
@EnableConfigurationProperties
@Configuration
public class OAuth2ClientConfig {

    @Bean
//    @ConfigurationProperties(prefix = "security.oauth2.client")//可以不用
    public ClientCredentialsResourceDetails clientCredentialsResourceDetails() {

        return new ClientCredentialsResourceDetails();
    }

    @Bean
    public OAuth2RestTemplate clientCredentialsRestTemplate() {
        return new OAuth2RestTemplate(clientCredentialsResourceDetails());
    }

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
}

