package ru.eremin.uiservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eremin.common.request.RegistrationRequest;
import ru.eremin.uiservice.business.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> registration(@RequestBody RegistrationRequest request) {
        userService.registration(request);
        return ResponseEntity.ok("OK");
    }

}
