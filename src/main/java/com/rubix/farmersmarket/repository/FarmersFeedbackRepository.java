package com.rubix.farmersmarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rubix.farmersmarket.domain.FarmersFeedback;

@Repository
public interface FarmersFeedbackRepository extends JpaRepository<FarmersFeedback, Long> {
	@Query(value = "SELECT * from Feedback  WHERE  farmer_id=:id", nativeQuery = true)
	List<FarmersFeedback> getFeedbacksByFarmerId(@Param("id") Long FarmerId);

	FarmersFeedback findByFeedbackId(Long feedbackId);

	@Query(value = "SELECT * from Feedback  WHERE  farmer_id=:id and feedback_id=:feedbackId", nativeQuery = true)
	FarmersFeedback findByFarmerIdAndFeedbackId(@Param("id") Long farmerId, @Param("feedbackId") Long feedbackId);
}
