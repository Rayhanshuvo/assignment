package com.waltan.crud.sales_invoice;

public class SalesInvoiceDetailDto {

	private Long salesInvDetailsId;
	private Integer lineNumber;
	private String productName;
	private Double quantity;
	private Double unitPrice;
	private double amount;

	private Long salesInvoiceId;
	private Long productId;
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
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
}
