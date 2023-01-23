package com.sat.quiz.validation;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {UniquePromoCodeValidator.class} )
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniquePromoCode {
    String message() default "{Eyni PromoCode olmaz}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

