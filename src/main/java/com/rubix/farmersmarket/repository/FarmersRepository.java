package com.rubix.farmersmarket.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.rubix.farmersmarket.domain.Farmers;

@Repository
public interface FarmersRepository extends PagingAndSortingRepository<Farmers, Long> {
	
	@Query(value = "SELECT * from Farmers  WHERE  farmer_id=:id", nativeQuery = true)
	Farmers getByFarmerId(@Param("id") Long farmersId);

	Optional<Farmers> findByAddress(String address);
	
	Farmers findByFarmerId(Long farmersId);
}
