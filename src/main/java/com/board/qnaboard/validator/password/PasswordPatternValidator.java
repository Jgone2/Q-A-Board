package com.board.qnaboard.validator.password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordPatternValidator implements ConstraintValidator<PasswordPattern, String> {
    @Override
    public void initialize(PasswordPattern constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    /**
     * ^ : 문자열의 시작을 나타냅니다.
     * (?=.*[A-Za-z]) : 적어도 하나의 알파벳이 포함되어야 함을 나타냅니다.
     * (?=.*\d) : 적어도 하나의 숫자가 포함되어야 함을 나타냅니다.
     * (?=.*[\W]) : 적어도 하나의 특수 문자가 포함되어야 함을 나타냅니다.
     * [A-Za-z\d\W]{8,16} : 알파벳, 숫자, 특수문자를 포함한 8~16자리의 문자열을 나타냅니다.
     * $ : 문자열의 끝을 나타냅니다.
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[\\W])[A-Za-z\\d\\W]{8,16}$");
    }
}
