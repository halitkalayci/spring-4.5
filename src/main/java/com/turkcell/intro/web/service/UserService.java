package com.turkcell.intro.web.service;

import com.turkcell.intro.web.core.exception.type.BusinessException;
import com.turkcell.intro.web.dto.user.request.LoginRequest;
import com.turkcell.intro.web.dto.user.request.RegisterRequest;
import com.turkcell.intro.web.dto.user.response.LoginResponse;
import com.turkcell.intro.web.dto.user.response.RegisteredResponse;
import com.turkcell.intro.web.entity.User;
import com.turkcell.intro.web.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository  userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisteredResponse register(RegisterRequest request)
    {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // ASLA plain-text olarak yazmıyoruz.

        userRepository.save(user);

        RegisteredResponse response = new RegisteredResponse();
        response.setUsername(user.getUsername());
        return response;
    }

    public LoginResponse login(LoginRequest request)
    {
        // RFC-1234

        // Username Enumeration
        User user = userRepository
                .findByUsername(request.getUsername())
                .orElseThrow(() -> new BusinessException("Wrong username or password."));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword()))
            throw new BusinessException("Wrong username or password.");

        LoginResponse response = new LoginResponse();
        response.setToken("abc123");
        return response;
    }
}
