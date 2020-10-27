package com.rubix.farmersmarket.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rubix.farmersmarket.repository.FarmersRepository;
import com.rubix.farmersmarket.repository.FarmersProductRepository;
import com.rubix.farmersmarket.domain.Farmers;
import com.rubix.farmersmarket.domain.FarmersProduct;
import com.rubix.farmersmarket.exception.*;

@Service
public class FarmersProductService {
	@Autowired
	private FarmersRepository farmersRepository;
	@Autowired
	private FarmersProductRepository productsRepository;

	public FarmersProduct findByProductId(Long productId) {
		FarmersProduct product=new FarmersProduct();
		product=productsRepository.findByProductId(productId);
		return product;
	}
	
	public List<FarmersProduct> findProductsByFarmersId(Long farmersId) {
		List<FarmersProduct> product = new ArrayList<>();
		product = productsRepository.getProductsByFarmerId(farmersId);
		return product;
	}

	public List<FarmersProduct> getAllProducts() {
		return productsRepository.findAll();
	}

	public ResponseEntity<Object> addProducts(long farmerId, FarmersProduct products) throws Exception {
		Farmers farmer = farmersRepository.findByFarmerId(farmerId);
		if (farmer == null) {
			throw new IdNotFoundException("Farmer ID not Found");
		} else {
			FarmersProduct product = new FarmersProduct();
			BeanUtils.copyProperties(products, product, "farmers");
			product.setFarmers(farmer);
			FarmersProduct savedProduct = productsRepository.save(product);
			FarmersProduct productExist = productsRepository.findByProductId(savedProduct.getProductId());
			if (productExist != null)
				return ResponseEntity.ok("Product Added");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to add Product");
		}
	}

	@Transactional
	public ResponseEntity<Object> updateProducts(FarmersProduct products, long farmerId, long productId) throws Exception {
		Farmers farmer = farmersRepository.findByFarmerId(farmerId);
		FarmersProduct product = productsRepository.findByProductId(productId);
		if (farmer == null || product == null) {
			throw new IdNotFoundException(" FarmersData or Product not found with this ID");
		} else {

			BeanUtils.copyProperties(products, product,"productId", "farmers");
			product.setProductId(productId);
			product.setFarmers(farmer);
			FarmersProduct savedProduct = productsRepository.save(product);
			FarmersProduct productExist = productsRepository.findByProductId(savedProduct.getProductId());
			if (productExist != null)
				return ResponseEntity.ok("Product Updated");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to update Product");
		}
	}

	public ResponseEntity<?> deleteProducts(long farmerId, long productId) throws Exception {

		FarmersProduct product = productsRepository.findByFarmerIdAndProductId(farmerId, productId);
		if (product == null) {
			throw new IdNotFoundException("No Farmer ID found with Product ID");
		} else {

			productsRepository.delete(product);
			return ResponseEntity.ok("Product Deleted");
		}
	}

}
