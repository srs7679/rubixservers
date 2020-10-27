package com.rubix.farmersmarket.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rubix.farmersmarket.domain.Phones;


@Repository
public interface PhonesRepository extends JpaRepository<Phones, Long> {
	@Query(value = "SELECT Phone_id from Phones  WHERE  farmer_id=:id", nativeQuery = true)
	Long[]  getByFarmersId(@Param("id") Long farmersId);
	@Query(value = "SELECT * from Phones  WHERE  farmer_id=:id", nativeQuery = true)
	List<Phones>  getPhonesByFarmersId(@Param("id") Long farmersId);
	
	Phones findByPhoneId(Long phoneId);
}
