package com.rubix.farmersmarket.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.rubix.farmersmarket.domain.Profile;

/**
 * @author kausar The ProfileRepository is used as a interface where
 *         JpaRepository is extended which helps to use CRUD operations
 *
 */

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
	
	Optional<Profile> findByEmailId(String email);

	public Profile findByEmailIdAndPassword(String Email, String password);

	@Query(value = "SELECT * from Profile  WHERE  Profile_id=:id", nativeQuery = true)
	public Profile findByProfileId(@Param("id") Long userId);
	

	@Query(value = "SELECT profile_id from Profile  WHERE  email_id=:email and password=:pass", nativeQuery = true)
	long  findProfileIdByEmailIdAndPassword(@Param("email") String email,@Param("pass")String passsword);

	
}