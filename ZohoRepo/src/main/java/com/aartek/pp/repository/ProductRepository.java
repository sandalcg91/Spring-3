package com.aartek.pp.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.pp.model.Products;

@Repository
public class ProductRepository {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void checkProduct(Products prod)
	{
		System.out.println("Inside product Repository");
		System.out.println(prod.getProdname());
		System.out.println(prod.getProddesc());
		System.out.println(prod.getProdprice());
		System.out.println(prod.getProdqty());
		hibernateTemplate.save(prod);
	}
	public List getProductDetails(Products prod)
	{
		System.out.println("Inside product Repository");
		List list = hibernateTemplate.find("from Products");
		Iterator itr = list.iterator();
		while(itr.hasNext())
		{
			Products product = (Products)itr.next();
			System.out.println(product.getProdname()+" "+product.getProddesc()+" "+product.getProdprice()+" "+product.getProdqty());
		}
		return list;
	}
}