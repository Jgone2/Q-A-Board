package com.board.qnaboard.validator.phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhonePatternValidator implements ConstraintValidator<PhonePattern, String> {
    @Override
    public void initialize(PhonePattern constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("^010-\\d{3,4}-\\d{4}$");
    }
}
