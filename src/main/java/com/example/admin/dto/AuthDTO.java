package com.example.admin.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class AuthDTO {

    // ─── 로그인 요청
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginRequest {
        @NotBlank(message = "사용자ID은 필수입니다")
        private String userId;

        @NotBlank(message = "비밀번호는 필수입니다")
        private String password;
    }

    // ─── 회원가입 요청
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SignupRequest {
        @NotBlank(message = "사용자ID은 필수입니다")
        @Size(min = 3, max = 50)
        private String userId;

        @NotBlank(message = "이메일은 필수입니다")
        @Email(message = "올바른 이메일 형식이 아닙니다")
        private String email;

        @NotBlank(message = "비밀번호는 필수입니다")
        @Size(min = 6, max = 40)
        private String password;

        private String userNm;
    }

    // ─── 로그인 응답
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginResponse {
        private String token;
        private String type = "Bearer";
        private String userId;
        private String email;
        private String userNm;
        private String role;
    }

    // ─── 현재 사용자 조회 응답
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserResponse {
        private String userId;
        private String email;
        private String userNm;
        private String role;
        private Boolean isActive;
    }

    // ─── 단순 메시지 응답
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MessageResponse {
        private String message;
    }
}
