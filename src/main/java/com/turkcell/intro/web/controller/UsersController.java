package com.turkcell.intro.web.controller;

import com.turkcell.intro.web.dto.user.request.RegisterRequest;
import com.turkcell.intro.web.dto.user.response.RegisteredResponse;
import com.turkcell.intro.web.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/users")
@RestController
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public RegisteredResponse register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }
}
