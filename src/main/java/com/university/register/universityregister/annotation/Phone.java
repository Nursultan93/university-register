package com.university.register.universityregister.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Pattern(regexp = "^\\+[1-9]\\d{11}$", message = "Mobil nomre formati duzgun deyil")
@Documented
@Constraint(validatedBy = {})
public @interface Phone {
    String message() default "Mobil nomre formati duzgun deyil";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
