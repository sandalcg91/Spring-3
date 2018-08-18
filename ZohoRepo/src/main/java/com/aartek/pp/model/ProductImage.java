package com.aartek.pp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prodimage")
public class ProductImage {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pimageid")
	private Integer pimageid;
	
	@Column(name="pimagename")
	private String pimagename;
	
	@Column(name="imagepath")
	private String imagepath;
}