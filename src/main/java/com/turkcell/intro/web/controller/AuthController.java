package com.turkcell.intro.web.controller;

import com.turkcell.intro.web.dto.auth.request.LoginRequest;
import com.turkcell.intro.web.dto.auth.request.RegisterRequest;
import com.turkcell.intro.web.dto.auth.response.LoginResponse;
import com.turkcell.intro.web.dto.auth.response.RegisteredResponse;
import com.turkcell.intro.web.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/auth")
@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("register")
    public RegisteredResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
