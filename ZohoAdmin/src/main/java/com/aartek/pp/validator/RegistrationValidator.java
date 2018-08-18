package com.aartek.pp.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.pp.model.User;
import com.aartek.pp.repository.RegistrationRepository;

@Component
public class RegistrationValidator implements Validator {

	@Autowired
	private RegistrationRepository registrationRepository;
	
	public boolean supports(Class<?> cg) {
		return User.class.isAssignableFrom(cg);
		// return User.class.equals(cg);
	}

	static Pattern psw = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})");

	public static boolean validatePassword(String un) {

		Matcher mtch = psw.matcher(un);
		if (mtch.matches()) {
			return true;
		}
		return false;
	}

	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmpty(errors, "firstname", "errors.firstname", "Please Enter Firstname");
		ValidationUtils.rejectIfEmpty(errors, "lastname", "errors.lastname", "Please Enter lastname");
		ValidationUtils.rejectIfEmpty(errors, "email", "errors.email", "Please Enter Valid Email");
		ValidationUtils.rejectIfEmpty(errors, "password", "errors.password", "Please Enter valid password");
		ValidationUtils.rejectIfEmpty(errors, "mobileNo", "errors.mobileNo", "Please Enter mobile Number");

		if(user.getFirstname()!=null && user.getFirstname().trim().length() > 20) {
			errors.rejectValue("firstname", "", "Firstname should be less than 20 character");
		}
		
		if (user.getLastname()!=null && user.getLastname().trim().length() > 20) {
			errors.rejectValue("lastname", "", "Lastname should be less than 20 character");
		}
		
		if (user.getEmail()!=null) {
			if(user.getEmail().contains("@") != true && user.getEmail().contains(".com") != true)
			{
				errors.rejectValue("email", null, "Email should contains @ and . Symbols");
			}
			else
			{
				String email = registrationRepository.checkEmailId(user.getEmail());
				System.out.println(email);
				if(email == null)
				{
					errors.rejectValue("email", "pp", "Email already exist");
				}
			}
		}
		
		if (user.getPassword()!=null && validatePassword(user.getPassword()) != true) {
			errors.rejectValue("password", "", "Password should contains 1 Lower case, 1 Upper case, 1 Numeric and 1 special character");
		}
		
		/*if (user.getMobileNo()!=null && user.getMobileNo().toString().length() > 9 || user.getMobileNo().toString().length() < 11) {
			errors.rejectValue("mobileNo", "", "Mobile number should b1 10 digits");
		}*/
	}
}