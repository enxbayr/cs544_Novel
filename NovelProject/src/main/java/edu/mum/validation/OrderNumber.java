package edu.mum.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

 
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.OverridesAttribute;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

 
@NotEmpty( )
@Size
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@ReportAsSingleViolation
@Documented
public @interface OrderNumber {
	String message() default "Validation for an Order number field failed.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	@OverridesAttribute(constraint=Size.class, name="value")
    int value() default 15;
}
