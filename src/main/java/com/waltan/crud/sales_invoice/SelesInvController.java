package com.waltan.crud.sales_invoice;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.waltan.crud.invoice_details.SalesInvoiceDetails;
import com.waltan.crud.product.ProductEntity;
import com.waltan.crud.product.ProductService;

@Controller
public class SelesInvController {

	private static final Logger logger = LoggerFactory.getLogger(SelesInvController.class);
	@Autowired
	private SaleInvService saleInvService;

	@Autowired
	private ProductService productService;

	@PostMapping("/savesalesinv")

	private void saveSaleInv(@RequestBody @Valid SalesInvoiceDto salesInvoice, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {

			logger.info("Validation errors while submitting form.");

		}

		saleInvService.saveSalesInv(salesInvoice);

	}
	
	
	

	@PostMapping("/salesinvoice")
	private void listSaleInv() {

		saleInvService.findInvDetails(1L);

	}

	@RequestMapping(value = "/sale", method = RequestMethod.GET)
	public String createProductView(Model model) {

		SalesInvoiceDto obj = new SalesInvoiceDto();

		List<ProductEntity> productList = productService.getAllProducts(ProductEntity.class);
		model.addAttribute("plist", productList);
		model.addAttribute("saleinvObj", obj);

		return "sales_invoice/saleinv";
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProductEntity> getProducts() {

		return productService.getAllProducts(ProductEntity.class);
	}
	
	@GetMapping("/salesinvoicelist")
	private String listAllSaleInv(Model model) {

		List<ResponseDto> responseDto=new ArrayList<>();
		
		responseDto=saleInvService.findAllInvoice();
		model.addAttribute("plist", responseDto);
	
		System.err.println();
		return "sales_invoice/saleinvoicelist";
	}
	
	
	
	
	
	
	@GetMapping("/sales/view/{id}")

	public ModelAndView productView(@PathVariable Long id, Model model) {
		ModelAndView modelAndView = new ModelAndView("/sales_invoice/salesview");

		List<SalesInvoiceDetails> salesDtls = saleInvService.getProductListById(id);
		modelAndView.addObject("slist", salesDtls);

		return modelAndView;

	}

	
	
	@GetMapping("/sales/products/view/{id}")

	public ModelAndView productViewList(@PathVariable Long id, Model model) {
		ModelAndView modelAndView = new ModelAndView("/sales_invoice/sales_products_view");
		List<SalesInvoiceDetails> salesDtls = saleInvService.getProductListById(id);
		
		
		
		modelAndView.addObject("slist", salesDtls);

		return modelAndView;

	}
	
	

}
