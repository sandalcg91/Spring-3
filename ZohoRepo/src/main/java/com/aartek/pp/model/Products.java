package com.aartek.pp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Products {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="prodid")
	private Integer prodid;
	
	@Column(name="prodname")
	private String prodname;
	
	@Column(name="proddesc")
	private String proddesc;
	
	@Column(name="prodprice")
	private Integer prodprice;
	
	@Column(name="prodqty")
	private Integer prodqty;

	public Integer getProdid() {
		return prodid;
	}

	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public String getProddesc() {
		return proddesc;
	}

	public void setProddesc(String proddesc) {
		this.proddesc = proddesc;
	}

	public Integer getProdprice() {
		return prodprice;
	}

	public void setProdprice(Integer prodprice) {
		this.prodprice = prodprice;
	}

	public Integer getProdqty() {
		return prodqty;
	}

	public void setProdqty(Integer prodqty) {
		this.prodqty = prodqty;
	}
}