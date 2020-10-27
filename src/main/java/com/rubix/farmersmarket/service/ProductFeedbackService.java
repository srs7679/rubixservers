package com.rubix.farmersmarket.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rubix.farmersmarket.domain.ProductFeedback;
import com.rubix.farmersmarket.constants.ProductConstants;
import com.rubix.farmersmarket.domain.Product;
import com.rubix.farmersmarket.exception.IdNotFoundException;
import com.rubix.farmersmarket.repository.ProductFeedbackRepository;
import com.rubix.farmersmarket.repository.ProductRepository;


/**
 * @author kausar
 * @class CommentService 
 *This class used for service for product management
 */

@Service
@PropertySource("classpath:messages.properties")
public class ProductFeedbackService {
	@Autowired
	private ProductFeedbackRepository feedbackRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private Environment environment;
	
	/**
	 * @param productId
	 * @param feedback
	 * @return ResponseEntity
	 * @throws IdNotFoundException,Exception
	 */
	public ResponseEntity<Object> addFeedback(Long productId, ProductFeedback feedbacks)
			throws Exception {
		if (!productRepository.existsById(productId)) {
			throw new IdNotFoundException(environment.getProperty(ProductConstants.PRODUCTID_NOTFOUND));
		}
		Product product = productRepository.findByProductId(productId);
		ProductFeedback feedback=new ProductFeedback();
		BeanUtils.copyProperties(feedbacks, feedback,"product");
		feedback.setProduct(product);
		ProductFeedback savedFeedbacks= feedbackRepository.save(feedback);
		
		ProductFeedback feedbackExists=feedbackRepository.findByFeedbackId(savedFeedbacks.getFeedbackId());
		if (feedbackExists!=null)
			return ResponseEntity.ok(environment.getProperty(ProductConstants.ADD_FEEDBACK_SUCCESS));
		else
			return ResponseEntity.unprocessableEntity().body(environment.getProperty(ProductConstants.ADD_FEEDBACK_FAILURE));

	}
		
	

	/**
	 * @param productId
	 * @param addressId
     * @param feedback
	 * @return ResponseEntity
	 * @throws IdNotFoundException,Exception
	 * 
	 */
	@Transactional
	public ResponseEntity<Object> updateFeedback(Long productId, Long feedbackId, ProductFeedback feedbacks)
			throws Exception {

		if (!productRepository.existsById(productId)) {
			throw new IdNotFoundException(environment.getProperty(ProductConstants.PRODUCTID_NOTFOUND));
		}
		 
		if (!feedbackRepository.existsById(feedbackId)) {
			throw new IdNotFoundException(environment.getProperty(ProductConstants.FEEDBACKID_NOTFOUND));
		}
		Product product = productRepository.findByProductId(productId);
		
		ProductFeedback feedback=new ProductFeedback();
		BeanUtils.copyProperties(feedbacks, feedback,"product","feedbackId");
		feedback.setFeedbackId(feedbackId);
		feedback.setProduct(product);
		ProductFeedback savedFeedbacks= feedbackRepository.save(feedback);

		ProductFeedback feedbackExists=feedbackRepository.findByFeedbackId(savedFeedbacks.getFeedbackId());
		if (feedbackExists!=null)
			return ResponseEntity.ok(environment.getProperty(ProductConstants.UPDATE_FEEDBACK_SUCCESS));
		else
			return ResponseEntity.unprocessableEntity().body(environment.getProperty(ProductConstants.UPDATE_FEEDBACK_FAILURE));
	}
	/**
	 * @param productId
	 * @param feedbackId
	 * @return ResponseEntity
	 * @throws IdNotFoundException,Exception
	 */
	public ResponseEntity<?> deleteFeedback(Long productId, Long feedbackId) throws IdNotFoundException {
		ProductFeedback feedback = feedbackRepository.findByFeedbackIdAndProductProductId(feedbackId,productId);
		if (feedback == null) {
			throw new IdNotFoundException(environment.getProperty(ProductConstants.FEEDBACKIDPRODUCTID_NOTFOUND));
		}

		feedbackRepository.delete(feedback);
		return ResponseEntity.ok(environment.getProperty(ProductConstants.DELETE_FEEDBACK_SUCCESS));
	}

}
