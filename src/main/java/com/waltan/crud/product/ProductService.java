package com.waltan.crud.product;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	public void saveProduct(ProductEntity productEntity) {
		// TODO Auto-generated method stub
		productDao.saveEntity(productEntity);
	}

	public List<ProductEntity> getAllProducts(Class<ProductEntity> productEnt) {
		// TODO Auto-generated method stub
		return productDao.findAll(productEnt);
	}



	public ProductEntity getProductById(Long id) {
		// TODO Auto-generated method stub
		ProductEntity productEntity= new ProductEntity();
		productEntity=productDao.getProductById(id);
		return productEntity;
	}

}
