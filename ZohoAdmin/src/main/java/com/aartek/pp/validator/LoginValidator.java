package com.aartek.pp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.pp.model.User;

@Component
public class LoginValidator implements Validator {

	public boolean supports(Class<?> cg) {
		return User.class.isAssignableFrom(cg);
	}

	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmpty(errors, "email", "errors.email", "Please Enter Valid Email");
		ValidationUtils.rejectIfEmpty(errors, "password", "errors.password", "Please Enter valid password");
	}
}