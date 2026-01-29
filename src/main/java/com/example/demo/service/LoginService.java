package com.example.demo.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.LoginRequest;
import com.example.demo.model.LoginResponse;
import com.example.demo.model.User;

@Service
public class LoginService {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // “Banco fake” em memória
    private final User fakeUser = new User(
            "roger",
            // hash da senha "123456" (gerado na hora, ver Passo 3)
            "$2a$10$TROQUE_ESSE_HASH_AQUI"
    );

    public LoginResponse login(LoginRequest request) {

        if (!fakeUser.getUsername().equals(request.getUsername())) {
            return new LoginResponse(false, "Username ou senha inválidos");
        }

        boolean ok = encoder.matches(request.getPassword(), fakeUser.getPasswordHash());
        if (ok) {
            return new LoginResponse(true, "Login realizado com sucesso");
        }

        return new LoginResponse(false, "Username ou senha inválidos");
    }
}
