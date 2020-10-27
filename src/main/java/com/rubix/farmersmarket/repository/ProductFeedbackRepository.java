package com.rubix.farmersmarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rubix.farmersmarket.domain.ProductFeedback;

/**
 * @author kausar The FeedbackRepository is used as a interface where
 *         JpaRepository is extended which helps to use CRUD operations
 */
@Repository
public interface ProductFeedbackRepository extends JpaRepository<ProductFeedback, Long> {

	List<ProductFeedback> findByProductProductId(Long productId);

	@Query(value = "SELECT * from Feedbacks  WHERE  product_id=:id and feedback_id=:fid", nativeQuery = true)
	ProductFeedback findByFeedbackIdAndProductProductId(@Param("fid") Long feedbackId, @Param("id") Long productId);

	public ProductFeedback findByFeedbackId(long feedbackId);

}
