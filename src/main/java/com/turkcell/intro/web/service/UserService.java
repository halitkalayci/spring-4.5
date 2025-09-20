package com.turkcell.intro.web.service;

import com.turkcell.intro.web.dto.user.request.RegisterRequest;
import com.turkcell.intro.web.dto.user.response.RegisteredResponse;
import com.turkcell.intro.web.entity.User;
import com.turkcell.intro.web.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository  userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RegisteredResponse register(RegisterRequest request)
    {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword()); // ASLA plain-text olarak yazmıyoruz.
    }
}
