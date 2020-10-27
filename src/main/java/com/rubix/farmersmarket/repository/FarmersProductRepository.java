package com.rubix.farmersmarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rubix.farmersmarket.domain.FarmersProduct;

@Repository
public interface FarmersProductRepository extends JpaRepository<FarmersProduct, Long> {

	@Query(value = "SELECT * from Products  WHERE  farmer_id=:id", nativeQuery = true)
	List<FarmersProduct> getProductsByFarmerId(@Param("id") Long FarmerId);

	FarmersProduct findByProductId(Long productId);

	@Query(value = "SELECT * from Products  WHERE  farmer_id=:id and product_id=:productId", nativeQuery = true)
	FarmersProduct findByFarmerIdAndProductId(@Param("id") Long farmerId, @Param("productId") Long productId);
}
