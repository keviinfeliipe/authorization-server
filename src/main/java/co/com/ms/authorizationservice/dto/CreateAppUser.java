package co.com.ms.authorizationservice.dto;


import java.util.List;

public record CreateAppUser (
    String username,
    String password,
    List<String> roles
){}

