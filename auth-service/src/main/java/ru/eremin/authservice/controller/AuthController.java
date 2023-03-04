package ru.eremin.authservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @PostMapping("/check")
    public Boolean isAuth(@RequestBody String token) {
        if ("good".equals(token)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}
