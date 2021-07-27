package com.waltan.crud.sales_invoice;

import java.util.List;

public class SalesInvoiceDto {


	private String customerName;
	private String invoiceNumber;
    private Double totalAmount;
    private Long invoiceId;
    private List<SalesInvoiceDetailDto> salesInvDetails = null;
	
	
	public Long getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public List<SalesInvoiceDetailDto> getSalesInvDetails() {
		return salesInvDetails;
	}
	public void setSalesInvDetails(List<SalesInvoiceDetailDto> salesInvDetails) {
		this.salesInvDetails = salesInvDetails;
	}

	

	
	
}
