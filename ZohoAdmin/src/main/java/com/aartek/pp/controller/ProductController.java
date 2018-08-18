package com.aartek.pp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.pp.model.Products;
import com.aartek.pp.service.ProductService;
import com.aartek.pp.validator.ProductValidator;

@Controller
public class ProductController {

	private static final Logger log = Logger.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductValidator productValidator;

	@RequestMapping(value = "/product", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveProduct(@ModelAttribute("prodMap") Products prod, BindingResult result, /*Map<String, Object> map*/ Model model,
			HttpServletRequest request) {
	//	log.info("Inside Product Controller");
		System.out.println("Inside product Controller");
	//	map.put("prodList", productService.getProductDetails(prod));
		model.addAttribute("prodList", productService.getProductDetails(prod));
		if ("post".equals(request.getMethod().toLowerCase())) {
			productValidator.validate(prod, result);
			if (result.hasErrors()) {
				return "product";
			} else {
				productService.checkProduct(prod);
	//			map.put("prodList", productService.getProductDetails(prod));
				model.addAttribute("prodList", productService.getProductDetails(prod));
				return "product";
			}
		}
//		map.put("prodMap", prod);
		model.addAttribute("prodMap", prod);
		return "product";
	}
}