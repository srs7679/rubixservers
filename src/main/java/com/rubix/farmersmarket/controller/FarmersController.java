package com.rubix.farmersmarket.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.rubix.farmersmarket.domain.FarmersDeliveryqueries;
import com.rubix.farmersmarket.domain.Farmers;
import com.rubix.farmersmarket.domain.FarmersProduct;
import com.rubix.farmersmarket.domain.FarmersFeedback;
import com.rubix.farmersmarket.service.*;
@CrossOrigin(origins="https://rubixproducts.herokuapp.com")
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/farmersData")
public class FarmersController {
	
	@Autowired
	private FarmersProductService productsService;
	@Autowired
	private FarmersService farmersService;
	@Autowired
	private FarmersFeedbackService feedbackService;
	@Autowired
	private FarmersDeliveryqueriesService deliveryqueriesService;
	@Autowired
	private PhonesService phonesService;
	
	@GetMapping("/getFarmersDataAll")
	public List<Farmers> getAll(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "100") Integer pageSize) {
		return farmersService.findAllFarmersData(pageNo, pageSize);

	}
	@GetMapping("/getFarmersDataById/{farmerId}")
	public Farmers getByProduct(@PathVariable(value = "farmerId") Long farmerId) throws Exception{
		return farmersService.findByFarmersId(farmerId);
	}
	@PostMapping("/saveFarmersData")
	public ResponseEntity<Object> addFarmerData(@RequestBody Farmers farmer) throws Exception {
		return farmersService.addFarmersData(farmer);
	}
	@PutMapping("/updateFarmersData/{farmerId}")
	public ResponseEntity<Object> updateFarmersData(@RequestBody  Farmers farmer,
			@PathVariable(value = "farmerId") Long farmerId) throws Exception {
		return farmersService.updateFarmersData(farmer, farmerId);
	}

	
	@DeleteMapping("/deleteFarmersData/{farmerId}")
	public ResponseEntity<?> deleteFarmersData(@PathVariable(value = "farmerId") Long farmerId) throws Exception {
		return farmersService.deleteFarmersData(farmerId);

	}

	@GetMapping("/getProductAll")
	public List<FarmersProduct> getAllProducts() {
		return productsService.getAllProducts();
	}

	@GetMapping("/getProductsByFarmerId/{farmerId}")
	public List<FarmersProduct> getProductsByFarmerId(@PathVariable(value = "farmerId", required = true) Long farmerId) {
		return productsService.findProductsByFarmersId(farmerId);
	}
	@GetMapping("/getProductByProductId/{productId}")
	public FarmersProduct getProductByProductId(@PathVariable(value = "productId", required = true) Long productId) {
		return productsService.findByProductId(productId);
	}

	
	@PostMapping("/saveProducts/{farmerId}")
	public ResponseEntity<Object> addProducts(@RequestBody FarmersProduct product,
			@PathVariable(value = "farmerId", required = true) Long farmerId) throws Exception {
		return productsService.addProducts(farmerId, product);
	}

	
	@PutMapping("/updateProduct/{farmerId}/{productId}")
	public ResponseEntity<Object> updateProduct(@RequestBody FarmersProduct product,
			@PathVariable(value = "farmerId", required = true) Long farmerId,
			@PathVariable(value = "productId", required = true) Long productId) throws Exception {
		return productsService.updateProducts(product, farmerId, productId);
	}

	@DeleteMapping("/deleteProduct/{farmerId}/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "farmerId") Long farmerId,
			@PathVariable(value = "productId") Long productId) throws Exception {
		return productsService.deleteProducts(farmerId, productId);

	}
	@GetMapping("/getFeedbackAll")
	public List<FarmersFeedback> getAllFeedback() {
		return feedbackService.getAllFeedbacks();
	}

	@GetMapping("/getFeedbacksByFarmerId")
	public List<FarmersFeedback> getFeedbacksByFarmerId(@RequestParam(value = "farmerId", required = true) Long farmerId) {
		return feedbackService.findFeedbackByFarmersId(farmerId);
	}

	
	@PostMapping("/saveFeedbacks")
	public ResponseEntity<Object> addFeedback(@RequestBody FarmersFeedback feedback,
			@RequestParam(value = "farmerId", required = true) Long farmerId) throws Exception {
		return feedbackService.addFeedbacks(farmerId, feedback);
	}

	
	@PutMapping("/updateFeedbacks")
	public ResponseEntity<Object> updateFeedback(@RequestBody FarmersFeedback feedback,
			@RequestParam(value = "farmerId", required = true) Long farmerId,
			@RequestParam(value = "feedbackId", required = true) Long feedbackId) throws Exception {
		return feedbackService.updateFeedback(feedback, farmerId, feedbackId);
	}

	@DeleteMapping("/deleteFeedback/{farmerId}/{feedbackId}")
	public ResponseEntity<?> deleteFeedback(@PathVariable(value = "farmerId") Long farmerId,
			@PathVariable(value = "feedbackId") Long feedbackId) throws Exception {
		return  feedbackService.deleteProducts(farmerId, feedbackId);

	}
	@GetMapping("/getDeliveryQueriesAll")
	public List<FarmersDeliveryqueries> getAllDeliveryQueries() {
		return deliveryqueriesService.getAllQueries();
	}

	@GetMapping("/getDeliveryqueriesByFarmerId")
	public List<FarmersDeliveryqueries> getDeliveryqueriessByFarmerId(@RequestParam(value = "farmerId", required = true) Long farmerId) {
		return deliveryqueriesService.findQueriesByFarmersId(farmerId);
	}

	
	@PostMapping("/saveDeliveryqueries")
	public ResponseEntity<Object> addDeliveryqueries(@RequestBody  FarmersDeliveryqueries queries,
			@RequestParam(value = "farmerId", required = true) Long farmerId) throws Exception {
		return deliveryqueriesService.addQueries(farmerId, queries);
	}

	
	@PutMapping("/updateDeliveryqueries")
	public ResponseEntity<Object> updateDeliveryqueries(@RequestBody FarmersDeliveryqueries queries,
			@RequestParam(value = "farmerId", required = true) Long farmerId,
			@RequestParam(value = "queryId", required = true) Long queryId) throws Exception {
		return deliveryqueriesService.updateQueries(queries, farmerId, queryId);
	}

	@DeleteMapping("/deleteDeliveryqueries/{farmerId}/{queryId}")
	public ResponseEntity<?> deleteDeliveryqueries(@PathVariable(value = "farmerId") Long farmerId,
			@PathVariable(value = "queryId") Long queryId) throws Exception {
		return  deliveryqueriesService.deleteQueries(farmerId, queryId);
	}
	
	@DeleteMapping("/deletePhones/{phoneId}")
	public ResponseEntity<?> deletePhone(@PathVariable(value = "phoneId") Long phoneId) throws Exception {
		return  phonesService.deletePhones(phoneId);
	}

}
