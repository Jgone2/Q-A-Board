package com.board.qnaboard.member.dto;

import com.board.qnaboard.audit.Auditable;
import com.board.qnaboard.validator.password.PasswordPattern;
import com.board.qnaboard.validator.phone.PhonePattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class MemberDto extends Auditable {

    @Getter
    @AllArgsConstructor
    public static class Post {
        @NotBlank
        @Email
        private String email;

        @NotBlank(message = "이름은 공백이 아니어야 합니다.")
        private String name;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch {
        @NotBlank(message = "회원 이름은 공백이 아니어야 합니다")
        private String name;

        @NotBlank
        @PasswordPattern
        private String password;

        @NotBlank(message = "휴대폰 번호는 공백이 아니어야 합니다")
        @PhonePattern
        private String phone;
    }
}
