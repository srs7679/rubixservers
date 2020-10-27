package com.rubix.farmersmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rubix.farmersmarket.domain.ProductFeedback;
import com.rubix.farmersmarket.domain.Product;
import com.rubix.farmersmarket.exception.IdNotFoundException;
import com.rubix.farmersmarket.repository.ProductFeedbackRepository;
import com.rubix.farmersmarket.service.ProductFeedbackService;
import com.rubix.farmersmarket.service.ProductService;

/**
 * @author kausar
 * @class ProductController This class used for rest api controller for product
 *        management
 *
 */
//@CrossOrigin(origins="https://rubixfarm.herokuapp.com")
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductFeedbackRepository feedbackRepository;
	@Autowired
	private ProductFeedbackService feedbackService;
	@Autowired
	private ProductService productService;
	@Autowired
	private Environment environment;

	/**
	 * list all product values
	 * 
	 * @return
	 */
	@GetMapping("/getProduct")

	public List<Product> getAll(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "100") Integer pageSize) {
		return productService.findAllProduct(pageNo, pageSize);

	}

	/**
	 * This method used for add product
	 * 
	 * @method addProduct
	 * @param product
	 * @return ResponseEntity
	 * @throws IdNotFoundException,Exception
	 */
	@PostMapping("/saveProduct")
	public ResponseEntity<Object> addProduct(@RequestBody Product product) {

		System.out.println("add address");
		return productService.addProduct(product);
	}

	/**
	 * This method used for update Product
	 * 
	 * @method updateProduct
	 * @param productId
	 * @param product
	 * @return ResponseEntity
	 * @throws IdNotFoundException,Exception
	 */
	@PutMapping("/updateProduct/{proId}")
	public ResponseEntity<Object> updateProduct(@PathVariable(value = "proId") Long productId,
			@RequestBody Product product) {

		System.out.println("update product");
		return productService.updateProduct(productId, product);
	}

	/**
	 * This method used for delete product
	 * 
	 * @method deleteProduct
	 * @param productId
	 * @return ResponseEntity
	 * @throws IdNotFoundException
	 */
	@DeleteMapping("deleteProduct/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "productId") Long productId) throws Exception {
		return productService.deleteProduct(productId);

	}

	/**
	 * list all feedback values
	 * 
	 * @return
	 */
	@GetMapping("/getFeedback")
	public List<ProductFeedback> getAllFeedback() {
		System.out.println("get feedback");
		return feedbackRepository.findAll();

	}

	/**
	 * This method id used for add feedback
	 * 
	 * @param feedbackId
	 * @param feedback
	 * @return ResponseEntity
	 * @throws Exception
	 * @throws IdNotFoundException,Exception
	 */
	@PostMapping("/saveFeedback/{proId}")
	public ResponseEntity<Object> addFeedback(@PathVariable(value = "proId") Long productId,
			@RequestBody ProductFeedback feedback) throws Exception {
		System.out.println("Add Feedback");
		return feedbackService.addFeedback(productId, feedback);

	}

	/**
	 * This method is used for update Feedback
	 * 
	 * @param feedbackId
	 * @param productId
	 * @param feedback
	 * @return ResponseEntity
	 * @throws IdNotFoundException,Exception
	 */
	@PutMapping("/updateFeedback/{proId}/{fbId}")
	public ResponseEntity<Object> updateComments(@PathVariable(value = "proId") Long productId,
			@PathVariable(value = "fbId") Long feedbackId, @RequestBody ProductFeedback feedback) throws Exception {

		System.out.println("update feedback");
		return feedbackService.updateFeedback(productId, feedbackId, feedback);
	}

	/**
	 * This method is used for delete Feedback
	 * 
	 * @param productId
	 * @param feedbackId
	 * @return ResponseEntity
	 * @throws IdNotFoundException
	 */
	@DeleteMapping("/deleteFeedback/{productId}/{feedbackId}")
	public ResponseEntity<?> deleteFeedback(@PathVariable(value = "productId") Long productId,
			@PathVariable(value = "feedbackId") Long feedbackId) throws IdNotFoundException {
		System.out.println("delete feedback");
		return feedbackService.deleteFeedback(productId, feedbackId);

	}

	/**
	 * This method used for environment details
	 * 
	 * @method envdetails
	 * @return String
	 */
	@GetMapping("/envdetails")
	public String envdetails() {
		return environment.toString();
	}
}
