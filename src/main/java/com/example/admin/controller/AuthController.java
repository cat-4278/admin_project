package com.example.admin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.admin.dto.AuthDTO.LoginRequest;
import com.example.admin.dto.AuthDTO.LoginResponse;
import com.example.admin.dto.AuthDTO.MessageResponse;
import com.example.admin.dto.AuthDTO.SignupRequest;
import com.example.admin.dto.AuthDTO.UserResponse;
import com.example.admin.security.JwtTokenProvider;
import com.example.admin.user.User;
import com.example.admin.user.UserRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;

    // ─── 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        // UsernamePasswordAuthenticationToken의 principal = userId
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getUserId(),
                loginRequest.getPassword()
            )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);

        User user = userRepository.findByUserId(loginRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다"));

        return ResponseEntity.ok(LoginResponse.builder()
            .token(jwt)
            .type("Bearer")
            .userId(user.getUserId())
            .email(user.getEmail())
            .userNm(user.getUserNm())
            .role(user.getRole().name())
            .build());
    }

    // ─── 회원가입
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest signupRequest) {
        if (userRepository.existsByUserId(signupRequest.getUserId())) {
            return ResponseEntity.badRequest()
                .body(new MessageResponse("이미 사용 중인 사용자ID입니다"));
        }

        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity.badRequest()
                .body(new MessageResponse("이미 사용 중인 이메일입니다"));
        }

        User user = new User();
        user.setUserId(signupRequest.getUserId());
        user.setEmail(signupRequest.getEmail());
        user.setUserNm(signupRequest.getUserNm());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setRole(User.Role.USER);
        user.setIsActive(true);

        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("회원가입이 완료되었습니다"));
    }

    // ─── 현재 로그인 사용자 조회
    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // principal = userId (CustomUserDetailsService에서 설정)
        String userId = authentication.getName();

        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다"));

        return ResponseEntity.ok(UserResponse.builder()
            .userId(user.getUserId())
            .email(user.getEmail())
            .userNm(user.getUserNm())
            .role(user.getRole().name())
            .isActive(user.getIsActive())
            .build());
    }
}
