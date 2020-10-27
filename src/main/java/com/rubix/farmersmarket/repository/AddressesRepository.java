package com.rubix.farmersmarket.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.rubix.farmersmarket.domain.Addresses;

/**
 * @author kausar
 * The AddressesRepository is used as a interface 
 * where JpaRepository is extended which helps to use CRUD operations
 *
 */
@Repository
public interface AddressesRepository extends JpaRepository<Addresses, Long> {
	@Query(value = "SELECT * from Address  WHERE  profile_id=:id order by address_Id asc", nativeQuery = true)
	List<Addresses> findByProfileId(@Param("id")Long profileId);

	Addresses findByAddressIdAndProfileProfileId(Long addressId, Long profileId);
	
	@Query(value = "SELECT * from Address  WHERE  profile_id=:id and is_default=true", nativeQuery = true)
	List<Addresses> findByDefault(@Param("id") Long profileId);

	@Query(value = "SELECT * from Address  WHERE  profile_id=:id and is_default=true", nativeQuery = true)
	Addresses findByDefaultAndId(@Param("id") Long profileId);
}
