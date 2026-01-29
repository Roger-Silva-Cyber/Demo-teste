package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desliga o CSRF para o POST funcionar
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated() // Exige senha para tudo
            )
            .httpBasic(basic -> {})
            .formLogin(form -> {}); // <--- ADICIONE ESSA LINHA PARA A TELA VOLTAR!

        return http.build();
    }
}