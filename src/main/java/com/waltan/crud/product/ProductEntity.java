package com.waltan.crud.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;


@Entity
@Table(name = "product_tbl")
public class ProductEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9017494357559118015L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	@Column(unique = true)

	@NotNull
	private String productCode;

	@NotNull
	private String productName;

	@NotNull
	private Double sellingPrice;
	
	public ProductEntity(Long productId, @NotNull String productCode, @NotNull String productName,
			@NotNull Double sellingPrice) {
	
		this.productId = productId;
		this.productCode = productCode;
		this.productName = productName;
		this.sellingPrice = sellingPrice;
	}
	public ProductEntity() {
		
	}
	public ProductEntity(Long productId) {
	
		this.productId = productId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
