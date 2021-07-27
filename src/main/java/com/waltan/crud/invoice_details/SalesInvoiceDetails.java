package com.waltan.crud.invoice_details;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


import com.waltan.crud.product.ProductEntity;
import com.waltan.crud.sales_invoice.SalesInvoiceEntity;


@Entity
public class SalesInvoiceDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6346405458835192963L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="INV_DETAILS_ID")
	private Long salesInvDetailsId;
	private Integer lineNumber;
	private String productName;
	private Double quantity;
	private Double unitPrice;
	private double amount;

	private Long salesInvoiceId;
	@OneToOne
	private ProductEntity productEntity;
	public SalesInvoiceDetails(Long salesInvDetailsId, Integer lineNumber, String productName, Double quantity,
			Double unitPrice, double amount, Long salesInvoiceId, ProductEntity productEntity) {

		this.salesInvDetailsId = salesInvDetailsId;
		this.lineNumber = lineNumber;
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.amount = amount;
		this.salesInvoiceId = salesInvoiceId;
		this.productEntity = productEntity;
	}
	public SalesInvoiceDetails() {
	
	}
	public SalesInvoiceDetails(Long salesInvDetailsId) {
		
		this.salesInvDetailsId = salesInvDetailsId;
	}
	public Long getSalesInvDetailsId() {
		return salesInvDetailsId;
	}
	public void setSalesInvDetailsId(Long salesInvDetailsId) {
		this.salesInvDetailsId = salesInvDetailsId;
	}
	public Integer getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Long getSalesInvoiceId() {
		return salesInvoiceId;
	}
	public void setSalesInvoiceId(Long salesInvoiceId) {
		this.salesInvoiceId = salesInvoiceId;
	}
	public ProductEntity getProductEntity() {
		return productEntity;
	}
	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}
	
}
