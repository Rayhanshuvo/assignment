package com.waltan.crud.sales_invoice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.waltan.crud.invoice_details.SalesInvoiceDetails;
import com.waltan.crud.product.ProductEntity;
import com.waltan.crud.utility.AbstractDao;

@Repository
public class SaleInvDao extends AbstractDao{

	

	public List<SalesInvoiceEntity> findAllInvoice() {
		// TODO Auto-generated method stub
		List<SalesInvoiceEntity> salesInvoiceEntities= null;
		salesInvoiceEntities= super.findAll(SalesInvoiceEntity.class);
		return salesInvoiceEntities;
		
	}

	
	public SalesInvoiceDetails getSellDetailsById(Long id) {
		// TODO Auto-generated method stub
		SalesInvoiceDetails salesInvoiceDetails= new SalesInvoiceDetails();
		salesInvoiceDetails=getSession().find(SalesInvoiceDetails.class, id);
		return salesInvoiceDetails;
	}


	public void getAllProductsBySellId(Long id) {
		// TODO Auto-generated method stub
		List<ProductEntity> productEntity= new ArrayList<>();
		productEntity=super.getProductsId(id);
		System.err.println();
		
	}
	
	
	
	public List<SalesInvoiceDetails> getSellEntById(Long id) {
		// TODO Auto-generated method stub
		SalesInvoiceEntity salesInvEnv= new SalesInvoiceEntity();
		salesInvEnv=getSession().find(SalesInvoiceEntity.class, id);
		if(salesInvEnv.getSalesInvDetailsId().get(0).getProductName()!=null) {
			return salesInvEnv.getSalesInvDetailsId();
		}
		return null;
	}


	public void saveEnt(SalesInvoiceEntity salesInvoiceEntity) {
		// TODO Auto-generated method stub
		
		super.saveEntity(salesInvoiceEntity);
		
	}





}
