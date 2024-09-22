package com.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception{

        security.cors(AbstractHttpConfigurer::disable);
        security.csrf(AbstractHttpConfigurer::disable);
//        security.authorizeHttpRequests( request -> request.anyRequest().permitAll());
        security.authorizeHttpRequests( request ->
                request.requestMatchers("/api/v1/**").authenticated()
                .anyRequest().permitAll());
        security.oauth2ResourceServer(authServer -> authServer.jwt(Customizer.withDefaults()));

        return security.build();
    }
}
