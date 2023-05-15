package com.board.qnaboard.validator.phone;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Constraint(validatedBy = {PhonePatternValidator.class})
public @interface PhonePattern {
    String message() default "{pattern.phone_number}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
