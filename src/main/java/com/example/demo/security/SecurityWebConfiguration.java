package com.example.demo.security;

import com.example.demo.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityWebConfiguration {

    @Autowired
    JwtTokenUtils jwtTokenUtils;
    @Autowired
    AppUserRepo appUserRepo;
    @Value("${appUser.login.type}")
    private String loginTypeValue;
    @Value("${login.expiration.time.in.minutes}")
    private Integer tokenExpirationTime;

    private final String[] PUBLIC_RESOURCE_AND_URL = {"/",
           "/api/v1/user/save",
            "/api/v1/user/sign-in"
    };


    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(a->a.anyRequest().authenticated())
                .exceptionHandling(e->e.accessDeniedHandler(accessDeniedHandler()))
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenUtils, appUserRepo, loginTypeValue, tokenExpirationTime), BasicAuthenticationFilter.class)   //token method
                .addFilterBefore(new CustomCORSFilter(), ChannelProcessingFilter.class);
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.debug(true)
                .ignoring()
                .requestMatchers(PUBLIC_RESOURCE_AND_URL);

    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }


}
