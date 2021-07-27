package com.waltan.crud.sales_invoice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waltan.crud.invoice_details.SalesInvoiceDetails;
import com.waltan.crud.product.ProductEntity;

@Service
public class SaleInvService {

	@Autowired
	private SaleInvDao saleInvDao;

	public void saveSalesInv(SalesInvoiceDto salesInvoiceDto) {
		// TODO Auto-generated method stub
		
		List<SalesInvoiceDetails> saleInvDet = new ArrayList<>();

		Date date = java.util.Calendar.getInstance().getTime();
		SalesInvoiceEntity salesInvoiceEntity = new SalesInvoiceEntity();
		salesInvoiceEntity.setCustomerName(salesInvoiceDto.getCustomerName());
		salesInvoiceEntity.setInvoiceDate(date);
		salesInvoiceEntity.setInvoiceNumber(salesInvoiceDto.getInvoiceNumber());
		salesInvoiceEntity.setTotalAmount(salesInvoiceDto.getTotalAmount());

		for (SalesInvoiceDetailDto details : salesInvoiceDto.getSalesInvDetails()) {
			SalesInvoiceDetails salesInvoiceDetails = new SalesInvoiceDetails();
			ProductEntity productEntity = new ProductEntity();
			productEntity.setProductId(details.getProductId());
			salesInvoiceDetails.setAmount(details.getAmount());
			salesInvoiceDetails.setLineNumber(details.getLineNumber());
			salesInvoiceDetails.setProductEntity(productEntity);
			salesInvoiceDetails.setProductName(details.getProductName());
			salesInvoiceDetails.setQuantity(details.getQuantity());
			salesInvoiceDetails.setSalesInvoiceId(details.getSalesInvoiceId());
			salesInvoiceDetails.setUnitPrice(details.getUnitPrice());
			saleInvDet.add(salesInvoiceDetails);

		}

		salesInvoiceEntity.setSalesInvDetailsId(saleInvDet);
	  
	    
	    saleInvDao.saveEnt(salesInvoiceEntity);

		/*
		 * String invoiceNumber=salesInvoiceEntity.getInvoiceNumber(); Date
		 * date=java.util.Calendar.getInstance().getTime();
		 * 
		 * Double totalAmount=0.0; List<SalesInvoiceDetails> salesInventoryListDetails=
		 * salesInvoiceEntity.getSalesInvDetailsId(); for(SalesInvoiceDetails
		 * det:salesInventoryListDetails ) { totalAmount=totalAmount+det.getAmount();
		 * 
		 * }
		 * 
		 * salesInvoiceEntity.setTotalAmount(totalAmount);
		 * salesInvoiceEntity.setInvoiceDate(date);
		 * salesInvoiceEntity.setInvoiceNumber(invoiceNumber+1);
		 * saleInvDao.saveEntity(salesInvoiceEntity);
		 */
	}

	public void findInvDetails(Long i) {
		// TODO Auto-generated method stub
		saleInvDao.getSaleId(i);

	}

	public List<ResponseDto> findAllInvoice() {

		List<ResponseDto> responseDto = new ArrayList<>();

		// TODO Auto-generated method stub
		List<SalesInvoiceEntity> salesInvoiceEntities = saleInvDao.findAllInvoice();

		for (SalesInvoiceEntity salesInvoiceEntity : salesInvoiceEntities) {
			ResponseDto responseDt = new ResponseDto();
			responseDt.setCustomerName(salesInvoiceEntity.getCustomerName());
			responseDt.setInvoiceId(salesInvoiceEntity.getSalesInvId());
			responseDt.setTotalAmount(salesInvoiceEntity.getTotalAmount());
			responseDt.setInvoiceNumber(salesInvoiceEntity.getInvoiceNumber());
			responseDt.setDate(salesInvoiceEntity.getInvoiceDate());
		 
			
			responseDto.add(responseDt);
		}

		return responseDto;
	}

	public SalesInvoiceDetails getSellDetailsById(Long id) {
		// TODO Auto-generated method stub
		
		return saleInvDao.getSellDetailsById(id);
	}

	public List<SalesInvoiceDetails> getProductListById(Long id) {
		// TODO Auto-generated method stub
		List<SalesInvoiceDetails> slsInvDts=saleInvDao.getSellEntById(id);
		return slsInvDts;
		
		//return null;
	}

}
