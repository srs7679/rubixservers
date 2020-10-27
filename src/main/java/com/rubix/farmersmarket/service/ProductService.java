package com.rubix.farmersmarket.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rubix.farmersmarket.exception.*;

import com.rubix.farmersmarket.domain.ProductFeedback;
import com.rubix.farmersmarket.constants.ProductConstants;
import com.rubix.farmersmarket.domain.Product;
import com.rubix.farmersmarket.repository.ProductFeedbackRepository;
import com.rubix.farmersmarket.repository.ProductRepository;


/**
 * @author kausar
 * @class ProfileService This class used for service for profile management
 */
@PropertySource("classpath:messages.properties")
@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
    private Environment environment;
	@Autowired
	private ProductFeedbackRepository feedbacksRepository;
	
	public List<Product> findAllProduct(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Product> pagedResult = productRepository.findAll(paging);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Product>();
		}
	}

	/**
	 * @param product
	 * @return
	 */
	public ResponseEntity<Object> addProduct(Product product) {
	    Product products = new Product();
	    BeanUtils.copyProperties(product, products, "feedbacks");
		Product savedProduct = productRepository.save(products);
		List<ProductFeedback> feedbacks=product.getFeedbacks();
		if(feedbacks!=null) {
		for (ProductFeedback feedback : feedbacks) {
			BeanUtils.copyProperties(feedbacks, feedback,"product");
			feedback.setProduct(savedProduct);
			feedbacksRepository.save(feedback);			
			}
		}
		Product productExists=productRepository.findByProductId(savedProduct.getProductId());
		if (productExists!=null)
			return ResponseEntity.ok(environment.getProperty(ProductConstants.ADD_PRODUCT_SUCCESS));
		else
			return ResponseEntity.unprocessableEntity().body(environment.getProperty(ProductConstants.ADD_PRODUCT_FAILURE));
	}

	/**
	 * @param productId
	 * @param commentId
	 * @param product
	 * @return ResponseEntity
	 */
	@Transactional
	public ResponseEntity<Object> updateProduct(Long productId,Product product) {
		if (productRepository.findById(productId).isPresent()) {
			Product products = productRepository.findByProductId(productId);
			BeanUtils.copyProperties(product, products, "feedbacks","productId");
			products.setProductId(productId);
			Product savedProduct = productRepository.save(products);
			
			List<ProductFeedback> feedbacks=product.getFeedbacks();
			if(feedbacks!=null) {
			for (ProductFeedback feedback : feedbacks) {
				BeanUtils.copyProperties(feedbacks, feedback,"product");
				feedback.setProduct(savedProduct);
				feedbacksRepository.save(feedback);			
				}
			}

			Product productExists=productRepository.findByProductId(savedProduct.getProductId());
			if (productExists!=null)
				return ResponseEntity.ok(environment.getProperty(ProductConstants.UPDATE_PRODUCT_SUCCESS));
			else
				return ResponseEntity.unprocessableEntity().body(environment.getProperty(ProductConstants.UPDATE_PRODUCT_FAILURE));
		} else
			return ResponseEntity.unprocessableEntity().body(environment.getProperty(ProductConstants.PRODUCTID_NOTFOUND));
	}

	/**
	 * @param userId
	 * @param addressId
	 * @return
	 */
	public ResponseEntity<?> deleteProduct(Long productId) throws Exception {
		Product products = productRepository.findByProductId(productId);
		if (products == null) {
			throw new IdNotFoundException(environment.getProperty(ProductConstants.PRODUCTID_NOTFOUND));
		} else {
			productRepository.delete(products);
			return ResponseEntity.ok(environment.getProperty(ProductConstants.DELETE_PRODUCT_SUCCESS));
		}
	}

}
