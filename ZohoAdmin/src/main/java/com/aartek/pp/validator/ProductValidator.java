package com.aartek.pp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.pp.model.Products;

@Component
public class ProductValidator implements Validator {

	public boolean supports(Class<?> cg) {
		return Products.class.isAssignableFrom(cg);
	}

	public void validate(Object target, Errors errors) {

		Products product = (Products) target;
		ValidationUtils.rejectIfEmpty(errors, "prodname", "", "Product name is mandatory");
		ValidationUtils.rejectIfEmpty(errors, "proddesc", "", "Product desc is mandatory");
		ValidationUtils.rejectIfEmpty(errors, "prodprice", "", "Product price is mandatory");
		ValidationUtils.rejectIfEmpty(errors, "prodqty", "", "Product quantity is mandatory");
	}
}