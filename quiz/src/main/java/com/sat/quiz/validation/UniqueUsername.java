package com.sat.quiz.validation;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {UniqueUsernameValidator.class} )
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUsername {
    String message() default "{Eyni username olmaz}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

