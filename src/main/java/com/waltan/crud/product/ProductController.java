package com.waltan.crud.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String createProductView(Model model) {

		ProductEntity obj = new ProductEntity();

		model.addAttribute("productObj", obj);

		return "product/create_product";
	}

	@PostMapping("/product/create")
	public String userStatus(@Valid ProductEntity productEntity, BindingResult result, Model model) {

		if (result.hasErrors()) {

			logger.info("Validation errors while submitting form.");

			model.addAttribute("productObj", productEntity);

			return "product/create_product";
		}

		productService.saveProduct(productEntity);
		model.addAttribute("productObj", productEntity);

		return "redirect:/product";
	}

	@GetMapping("/product/list")
	public String showList(Model model) {
		List<ProductEntity> productList = productService.getAllProducts(ProductEntity.class);
		model.addAttribute("plist", productList);
		return "product/productslist";
	}

	@GetMapping("/product/edit/{id}")

	public ModelAndView productEdit(@PathVariable Long id, Model model) {
		ModelAndView modelAndView = new ModelAndView("/product/editproduct");

		ProductEntity productEntity = productService.getProductById(id);
		modelAndView.addObject("products", productEntity);

		return modelAndView;

	}

	@GetMapping("/product/view/{id}")

	public ModelAndView productView(@PathVariable Long id, Model model) {
		ModelAndView modelAndView = new ModelAndView("/product/product_view");

		ProductEntity productEntity = productService.getProductById(id);
		modelAndView.addObject("plist", productEntity);

		return modelAndView;

	}

}
