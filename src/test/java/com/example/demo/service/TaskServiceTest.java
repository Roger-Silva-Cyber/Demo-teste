package com.example.demo.service;

import com.example.demo.model.LoginRequest;
import com.example.demo.model.LoginResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {

    @Test
    void login_quandoCredenciaisCorretas_retornaSuccessTrue() {
        // Arrange
        LoginService service = new LoginService();

        LoginRequest req = new LoginRequest();
        req.setUsername("roger");
        req.setPassword("123456");

        // Act
        LoginResponse resp = service.login(req);

        // Assert
        assertNotNull(resp);
        assertTrue(resp.isSuccess());
        assertEquals("Login realizado com sucesso", resp.getMessage());
    }

    @Test
    void login_quandoCredenciaisIncorretas_retornaSuccessFalse() {
        // Arrange
        LoginService service = new LoginService();

        LoginRequest req = new LoginRequest();
        req.setUsername("roger");
        req.setPassword("errada");

        // Act
        LoginResponse resp = service.login(req);

        // Assert
        assertNotNull(resp);
        assertFalse(resp.isSuccess());
        assertEquals("Username ou senha inválidos", resp.getMessage());
    }
}
