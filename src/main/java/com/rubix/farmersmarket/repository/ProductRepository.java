package com.rubix.farmersmarket.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rubix.farmersmarket.domain.Product;

/**
 * @author kausar The ProductRepository is used as a interface where
 *         JpaRepository is extended which helps to use CRUD operations
 */
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

	@Query(value = "SELECT * from Product  WHERE  Product_id=:id", nativeQuery = true)
	public Product getByProductId(@Param("id") Long productId);

	Product findByProductId(Long productId);

}