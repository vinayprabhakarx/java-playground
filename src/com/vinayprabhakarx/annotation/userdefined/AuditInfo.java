package com.vinayprabhakarx.annotation.userdefined;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @Documented includes this annotation in generated Java documentation.
@Documented
// @Inherited allows child classes to inherit this annotation from a parent class.
@Inherited
// @Retention(RUNTIME) keeps this annotation available while the program runs.
@Retention(RetentionPolicy.RUNTIME)
// @Target defines where this annotation can be used.
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface AuditInfo {
    String createdBy();

    String description() default "No description";
}
