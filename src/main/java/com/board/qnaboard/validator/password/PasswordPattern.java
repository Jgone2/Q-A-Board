package com.board.qnaboard.validator.password;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Constraint(validatedBy = {PasswordPatternValidator.class})
public @interface PasswordPattern {
    String message() default "{pattern.password}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}