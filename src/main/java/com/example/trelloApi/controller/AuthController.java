package com.example.trelloApi.controller;

import com.example.trelloApi.dto.auth.LoginRequestDto;
import com.example.trelloApi.dto.auth.UserDto;
import com.example.trelloApi.dto.auth.UserCreateDto;
import com.example.trelloApi.dto.jwt.JwtResponseDto;
import com.example.trelloApi.dto.jwt.RefreshTokenRequest;
import com.example.trelloApi.service.auth.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 11:55 AM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping(value = "/login", produces = "application/json")
    public ResponseEntity<JwtResponseDto> login(@RequestBody LoginRequestDto loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@Valid @RequestBody UserCreateDto dto) {
        return ResponseEntity.ok(userService.register(dto));
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<JwtResponseDto> refreshToken(@RequestBody RefreshTokenRequest request) {
        return ResponseEntity.ok(userService.refreshToken(request));
    }
//    @PostMapping("/update/{id}")
//    public ResponseEntity<Void> updateUser(@PathVariable Long userId,@RequestBody UserUpdateDto){
//
//    }

}
