package com.rubix.farmersmarket.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.rubix.farmersmarket.domain.FarmersDeliveryqueries;


@Repository
public interface FarmersDeliveryqueriesRepository extends JpaRepository<FarmersDeliveryqueries, Long> {
	
	@Query(value = "SELECT * from Deliveryqueries  WHERE  farmer_id=:id", nativeQuery = true)
	List<FarmersDeliveryqueries> getQueriesByFarmerId(@Param("id") Long FarmerId);

	FarmersDeliveryqueries findByQueryId(Long queryId);

	@Query(value = "SELECT * from Deliveryqueries  WHERE  farmer_id=:id and query_id=:queryId", nativeQuery = true)
	FarmersDeliveryqueries findByFarmerIdAndQueryId(@Param("id") Long farmerId, @Param("queryId") Long queryId);
	
}
