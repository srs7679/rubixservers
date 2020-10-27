package com.rubix.farmersmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.rubix.farmersmarket.domain.Phones;
import com.rubix.farmersmarket.exception.IdNotFoundException;
import com.rubix.farmersmarket.repository.FarmersRepository;
import com.rubix.farmersmarket.repository.PhonesRepository;
import org.springframework.stereotype.Service;

@Service
public class PhonesService {

	@Autowired
	private FarmersRepository farmersRepository;
	@Autowired
	private PhonesRepository phonesRepository;

	public ResponseEntity<?> deletePhones(long phoneId) throws Exception {

		Phones phone = phonesRepository.findByPhoneId(phoneId);
		if (phone == null) {
			throw new IdNotFoundException("Phone ID doesnt Exist");
		} else {

			phonesRepository.delete(phone);
			return ResponseEntity.ok("phone no Deleted");
		}
	}

}
