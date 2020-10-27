package com.rubix.farmersmarket.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rubix.farmersmarket.domain.Farmers;
import com.rubix.farmersmarket.domain.Phones;
import com.rubix.farmersmarket.domain.FarmersProduct;
import com.rubix.farmersmarket.domain.FarmersFeedback;
import com.rubix.farmersmarket.domain.FarmersDeliveryqueries;
import com.rubix.farmersmarket.repository.FarmersRepository;
import com.rubix.farmersmarket.repository.FarmersFeedbackRepository;
import com.rubix.farmersmarket.repository.FarmersProductRepository;
import com.rubix.farmersmarket.repository.FarmersDeliveryqueriesRepository;
import com.rubix.farmersmarket.repository.PhonesRepository;
import com.rubix.farmersmarket.exception.*;

@Service
public class FarmersService {
	@Autowired
	private FarmersRepository farmersRepository;
	@Autowired
	private FarmersProductRepository productsRepository;
	@Autowired
	private FarmersFeedbackRepository feedbackRepository;
	@Autowired
	private FarmersDeliveryqueriesRepository deliveryqueriesRepository;
	@Autowired
	private PhonesRepository phonesRepository;

	public List<Farmers> findAllFarmersData(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Farmers> pagedResult = farmersRepository.findAll(paging);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Farmers>();
		}
	}

	public Farmers findByFarmersId(Long farmersId) throws Exception {
		Farmers farmer = new Farmers();
		farmer = farmersRepository.getByFarmerId(farmersId);
		if (farmer == null)
			throw new IdNotFoundException("  FarmersData not found with this ID");
		else
			return farmer;
	}

	public ResponseEntity<Object> addFarmersData(Farmers farmers) throws Exception {

		Farmers farmer = new Farmers();
		BeanUtils.copyProperties(farmers, farmer, "products", "feedback");
		if (farmersRepository.findByAddress(farmer.getAddress()).isPresent()) {
			throw new AlreadyExistsException("Address already exists");
		} else {
			Farmers savedfarmer = farmersRepository.save(farmer);
			List<Phones> phones = farmers.getPhones();
			
			if(phones!=null) {
			for (Phones phone : phones) {
			BeanUtils.copyProperties(phones, phone,"phoneId", "farmers");
				//phone.setPhoneId(phone.getPhoneId());
				//phone.setMobileno(phones.get(i).);
				phone.setFarmers(savedfarmer);
				phonesRepository.save(phone);
			}
			}
			List<FarmersProduct> products = farmers.getProducts();
			if(products!=null) {
			for (FarmersProduct product : products) {
				BeanUtils.copyProperties(products, product, "farmers");
				product.setFarmers(savedfarmer);
				productsRepository.save(product);
			}
			}
			List<FarmersFeedback> feedbacks = farmers.getFeedback();
			if(feedbacks!=null) {
			for (FarmersFeedback feedback : feedbacks) {
				BeanUtils.copyProperties(feedbacks, feedback, "farmers");
				feedback.setFarmers(savedfarmer);
				feedbackRepository.save(feedback);
			}
			}
			List<FarmersDeliveryqueries> queries = farmers.getDeliveryqueries();
			if(queries!=null){
			for (FarmersDeliveryqueries query : queries) {
				BeanUtils.copyProperties(queries, query, "farmers");
				query.setFarmers(savedfarmer);
				deliveryqueriesRepository.save(query);
			}
			}
			long id = savedfarmer.getFarmerId();
			Farmers farmerExist = farmersRepository.findByFarmerId(id);
			if (farmerExist != null)
				return ResponseEntity.ok("FarmersData Added");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to add FarmersData");

		}
	}

	@Transactional
	public ResponseEntity<Object> updateFarmersData(Farmers farmers, Long farmerId) throws Exception {
		Farmers farmer = new Farmers();
		farmer = farmersRepository.findByFarmerId(farmerId);
		if (farmer == null) {
			throw new IdNotFoundException("  FarmersData not found with this ID");
		} else {
			BeanUtils.copyProperties(farmers, farmer, "products", "feedback", "farmerId");
			farmer.setFarmerId(farmerId);
			Farmers savedfarmer = farmersRepository.save(farmer);
			//Long [] phId=phonesRepository.getByFarmersId(farmerId);
			List<Phones> phones = farmers.getPhones();
			long count=phones.size();
			if(phones!=null) {
				for(int i=0;i<count;i++) {	
			for (Phones phone : phones) {
				BeanUtils.copyProperties(phones, phone,"phoneId","farmers");
				long id=phones.get(i).getPhoneId();
				if(id!=0) {
					phone.setPhoneId(phones.get(i).getPhoneId());
				}
				phone.setFarmers(savedfarmer);
				phonesRepository.save(phone);
			}
			}
			}
			List<FarmersProduct> products = farmers.getProducts();
			if(products!=null) {
			for (FarmersProduct product : products) {
				BeanUtils.copyProperties(products, product, "farmers");
				product.setFarmers(savedfarmer);
				productsRepository.save(product);
			}
			}

			List<FarmersFeedback> feedbacks = farmers.getFeedback();
			if(feedbacks!=null) {
			for (FarmersFeedback feedback : feedbacks) {
				BeanUtils.copyProperties(feedbacks, feedback, "farmers");
				feedback.setFarmers(savedfarmer);
				feedbackRepository.save(feedback);
			}
			}
			List<FarmersDeliveryqueries> queries = farmers.getDeliveryqueries();
			if(queries!=null){
			for (FarmersDeliveryqueries query : queries) {
				BeanUtils.copyProperties(queries, query, "farmers");
				query.setFarmers(savedfarmer);
				deliveryqueriesRepository.save(query);
			}
			}
			long id = savedfarmer.getFarmerId();
			Farmers farmerExist = farmersRepository.findByFarmerId(id);
			if (farmerExist != null)
				return ResponseEntity.ok("FarmersData Updated");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to update FarmersData");

		}
	}

	public ResponseEntity<?> deleteFarmersData(long farmerId) throws Exception {

		Farmers farmer = farmersRepository.findByFarmerId(farmerId);
		if (farmer == null) {
			throw new IdNotFoundException("No FarmersData found with this ID");
		} else {
			farmersRepository.delete(farmer);
			return ResponseEntity.ok("FarmersData Deleted");
		}
	}

}
