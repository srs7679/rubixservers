package com.rubix.farmersmarket.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rubix.farmersmarket.domain.Farmers;
import com.rubix.farmersmarket.domain.FarmersDeliveryqueries;
import com.rubix.farmersmarket.exception.IdNotFoundException;
import com.rubix.farmersmarket.repository.FarmersRepository;
import com.rubix.farmersmarket.repository.FarmersDeliveryqueriesRepository;

@Service
public class FarmersDeliveryqueriesService {

	@Autowired
	private FarmersRepository farmersRepository;
	@Autowired
	private FarmersDeliveryqueriesRepository deliveryqueriesRepository;

	public List<FarmersDeliveryqueries> findQueriesByFarmersId(Long farmersId) {
		List<FarmersDeliveryqueries> query = new ArrayList<>();
		query  = deliveryqueriesRepository.getQueriesByFarmerId(farmersId);
		return query ;
	}

	public List<FarmersDeliveryqueries> getAllQueries() {
		return deliveryqueriesRepository.findAll();
	}

	public ResponseEntity<Object> addQueries(long farmerId, FarmersDeliveryqueries queries) throws Exception {
		Farmers farmer = farmersRepository.findByFarmerId(farmerId);
		if (farmer == null) {
			throw new IdNotFoundException("Farmer ID not Found");
		} else {
			FarmersDeliveryqueries query = new FarmersDeliveryqueries();
			BeanUtils.copyProperties(queries, query, "farmers");
			query.setFarmers(farmer);
			FarmersDeliveryqueries savedQuery = deliveryqueriesRepository.save(query);
			FarmersDeliveryqueries queryExist = deliveryqueriesRepository.findByQueryId(savedQuery.getQueryId());
			if (queryExist != null)
				return ResponseEntity.ok("Delivery Query Added ");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to add Delivery Query");
		}
	}

	@Transactional
	public ResponseEntity<Object> updateQueries(FarmersDeliveryqueries queries, long farmerId, long queryId) throws Exception {
		Farmers farmer = farmersRepository.findByFarmerId(farmerId);
		FarmersDeliveryqueries query = deliveryqueriesRepository.findByQueryId(queryId);
		if (farmer == null ||  query == null) {
			throw new IdNotFoundException(" FarmersData or Query not found with this ID");
		} else {

			BeanUtils.copyProperties(queries, query, "farmers");
			query.setQueryId(queryId);
			query.setFarmers(farmer);
			FarmersDeliveryqueries savedQuery = deliveryqueriesRepository.save(query);
			FarmersDeliveryqueries queryExist = deliveryqueriesRepository.findByQueryId(savedQuery.getQueryId());
			if (queryExist != null)
				return ResponseEntity.ok("Delivery Query Updated ");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to update Delivery Query");
		}
	}

	public ResponseEntity<?> deleteQueries(long farmerId, long queryId) throws Exception {

		FarmersDeliveryqueries query = deliveryqueriesRepository.findByFarmerIdAndQueryId(farmerId, queryId);
		if (query == null) {
			throw new IdNotFoundException("No Farmer ID found with Query ID");
		} else {

			deliveryqueriesRepository.delete(query);
			return ResponseEntity.ok("Query Deleted");
		}
	}

}