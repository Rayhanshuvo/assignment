package com.waltan.crud.sales_invoice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.waltan.crud.invoice_details.SalesInvoiceDetails;

@Entity
public class SalesInvoiceEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6505030955101147584L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SALE_ID")
	private Long salesInvId;

	private String invoiceNumber;
	@DateTimeFormat(pattern = "dd.MM.yyyy hh:mm")
	private Date invoiceDate;
	private String customerName;
	private Double totalAmount;

	@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="salesInvoiceId",referencedColumnName = "SALE_ID")
	private List<SalesInvoiceDetails> salesInvDetailsId= new ArrayList<>();

	public SalesInvoiceEntity(Long salesInvId, String invoiceNumber, Date invoiceDate, String customerName,
			Double totalAmount, List<SalesInvoiceDetails> salesInvDetailsId) {

		this.salesInvId = salesInvId;
		this.invoiceNumber = invoiceNumber;
		this.invoiceDate = invoiceDate;
		this.customerName = customerName;
		this.totalAmount = totalAmount;
		this.salesInvDetailsId = salesInvDetailsId;
	}

	public SalesInvoiceEntity() {
	
	}

	public SalesInvoiceEntity(Long salesInvId) {
	
		this.salesInvId = salesInvId;
	}

	public Long getSalesInvId() {
		return salesInvId;
	}

	public void setSalesInvId(Long salesInvId) {
		this.salesInvId = salesInvId;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<SalesInvoiceDetails> getSalesInvDetailsId() {
		return salesInvDetailsId;
	}

	public void setSalesInvDetailsId(List<SalesInvoiceDetails> salesInvDetailsId) {
		this.salesInvDetailsId = salesInvDetailsId;
	}

	

}
