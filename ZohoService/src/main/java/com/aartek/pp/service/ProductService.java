package com.aartek.pp.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.pp.model.Products;
import com.aartek.pp.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public void checkProduct(Products prod)
	{
		System.out.println("Inside product Service");
		System.out.println(prod.getProdname());
		System.out.println(prod.getProddesc());
		System.out.println(prod.getProdprice());
		System.out.println(prod.getProdqty());
		productRepository.checkProduct(prod);
	}
	
	public List getProductDetails(Products prod)
	{
		System.out.println("Inside product Service");
		List list = productRepository.getProductDetails(prod);
		Iterator itr = list.iterator();
		while(itr.hasNext())
		{
			Products product = (Products)itr.next();
			System.out.println(product.getProdname()+" "+product.getProddesc()+" "+product.getProdprice()+" "+product.getProdqty());
		}
		return list;
	}
}