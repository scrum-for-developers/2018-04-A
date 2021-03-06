package de.codecentric.psd.worblehat.web.validation;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.ISBNValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ISBNConstraintValidator implements ConstraintValidator<ISBN, String> {

	@Override
	public void initialize(ISBN constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// Don't validate null, empty and blank strings, since these are validated by @NotNull, @NotEmpty and @NotBlank
		String valueWithoutDashes = value.replaceAll("-", "");
		if(StringUtils.isNotBlank(valueWithoutDashes)) {
			return ISBNValidator.getInstance().isValidISBN10(valueWithoutDashes) || ISBNValidator.getInstance().isValidISBN13(valueWithoutDashes);
		}
		return true;
	}

}
