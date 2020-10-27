package com.rubix.farmersmarket.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rubix.farmersmarket.domain.Farmers;
import com.rubix.farmersmarket.domain.FarmersFeedback;
import com.rubix.farmersmarket.exception.IdNotFoundException;
import com.rubix.farmersmarket.repository.FarmersRepository;
import com.rubix.farmersmarket.repository.FarmersFeedbackRepository;

@Service
public class FarmersFeedbackService {
	@Autowired
	private FarmersRepository farmersRepository;
	@Autowired
	private FarmersFeedbackRepository feedbackRepository;

	public List<FarmersFeedback> findFeedbackByFarmersId(Long farmersId) {
		List<FarmersFeedback> feedback = new ArrayList<>();
		feedback = feedbackRepository.getFeedbacksByFarmerId(farmersId);
		return feedback;
	}

	public List<FarmersFeedback> getAllFeedbacks() {
		return feedbackRepository.findAll();
	}

	public ResponseEntity<Object> addFeedbacks(long farmerId, FarmersFeedback feedbacks) throws Exception {
		Farmers farmer = farmersRepository.findByFarmerId(farmerId);
		if (farmer == null) {
			throw new IdNotFoundException("Farmer ID not Found");
		} else {
			FarmersFeedback feedback = new FarmersFeedback();
			BeanUtils.copyProperties(feedbacks, feedback, "farmers");
			feedback.setFarmers(farmer);
			FarmersFeedback savedFeedback = feedbackRepository.save(feedback);
			FarmersFeedback feedbackExist = feedbackRepository.findByFeedbackId(savedFeedback.getFeedbackId());
			if (feedbackExist != null)
				return ResponseEntity.ok("Feedback Added");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to add Feedback");
		}
	}

	@Transactional
	public ResponseEntity<Object> updateFeedback(FarmersFeedback feedbacks, long farmerId, long feedbackId) throws Exception {
		Farmers farmer = farmersRepository.findByFarmerId(farmerId);
		FarmersFeedback feedback = feedbackRepository.findByFeedbackId(feedbackId);
		if (farmer == null || feedback == null) {
			throw new IdNotFoundException(" FarmersData or feedback not found with this ID");
		} else {

			BeanUtils.copyProperties(feedbacks, feedback,"feedbackId", "farmer");
			feedback.setFeedbackId(feedbackId);
			feedback.setFarmers(farmer);
			FarmersFeedback savedFeedback = feedbackRepository.save(feedback);
			FarmersFeedback feedbackExist = feedbackRepository.findByFeedbackId(savedFeedback.getFeedbackId());
			if (feedbackExist != null)
				return ResponseEntity.ok("Feedback updated");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to update Feedback");
		}
	}

	public ResponseEntity<?> deleteProducts(long farmerId, long feedbackId) throws Exception {

		FarmersFeedback feedback = feedbackRepository.findByFarmerIdAndFeedbackId(farmerId, feedbackId);
		if (feedback == null) {
			throw new IdNotFoundException("No Farmer ID found with Feedback ID");
		} else {

			feedbackRepository.delete(feedback);
			return ResponseEntity.ok("Feedback Deleted");
		}
	}

}
