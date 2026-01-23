package com.example.demo.controller;

import com.example.demo.model.LoginRequest;
import com.example.demo.model.LoginResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public LoginResponse login(@RequestBody LoginRequest request) {

        if ("roger@email.com".equals(request.getEmail())
                && "123456".equals(request.getSenha())) {

            return new LoginResponse(true, "Login realizado com sucesso");
        }

        return new LoginResponse(false, "Email ou senha inválidos");
    }
}
