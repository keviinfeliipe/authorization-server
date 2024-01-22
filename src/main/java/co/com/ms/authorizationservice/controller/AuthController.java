package co.com.ms.authorizationservice.controller;

import co.com.ms.authorizationservice.dto.CreateAppUser;
import co.com.ms.authorizationservice.dto.Message;
import co.com.ms.authorizationservice.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/v1")
@RequiredArgsConstructor
public class AuthController {
    private final AppUserService service;

    @PostMapping("/create")
    public ResponseEntity<Message> createUser(@RequestBody CreateAppUser user){
        var appUser = service.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(appUser);
    }
}
