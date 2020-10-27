package com.rubix.farmersmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rubix.farmersmarket.domain.Addresses;
import com.rubix.farmersmarket.domain.Profile;
import com.rubix.farmersmarket.exception.IdNotFoundException;
import com.rubix.farmersmarket.repository.AddressesRepository;
import com.rubix.farmersmarket.repository.ProfileRepository;

/**
 * @author kausar
 * @class AddressesService 
 *This class used for service for profile management
 *
 */

@Service
@PropertySource("classpath:messages.properties")
public class AddressesService {
	@Autowired
	private AddressesRepository addressRepo;
	@Autowired
	private ProfileRepository profileRepo;
	
	@Autowired
	private Environment environment;
	
	/**
	 * @param profileId
	 * @param model
	 * @return ResponseEntity
	 * @throws ResourceNotFoundException,Exception
	 */
	public Addresses getAddressByProfileId(Long profileId,Long addressId) {
		Addresses address=addressRepo.findByAddressIdAndProfileProfileId(addressId, profileId);
		return address;
	}
	public ResponseEntity<Object> addAddress(Long profileId, Addresses model)
			throws IdNotFoundException, Exception {
		if (!profileRepo.existsById(profileId)) {
			throw new IdNotFoundException("profileId.NotFound");
		}
		Profile pro = profileRepo.findByProfileId(profileId);

		model.setProfile(pro);
		model.setName(model.getName());
		model.setAddress(model.getAddress());
		model.setCity(model.getCity());
		model.setState(model.getState());
		model.setZipCode(model.getZipCode());
		model.setFriendlyName(model.getFriendlyName());
		model.setContactNumber(model.getContactNumber());
		model.setDefault(model.isDefault());
		boolean flag = model.isDefault();
		List<Addresses> addres = addressRepo.findByDefault(profileId);
		int count = addres.size();
		if (count == 1 && flag == true) {
			Addresses addrr = addressRepo.findByDefaultAndId(profileId);
				addrr.setDefault(false);
				 addressRepo.save(addrr);
		}
		Addresses addr = addressRepo.save(model);
		if (addressRepo.findById(addr.getAddressId()).isPresent())
			
			return ResponseEntity.ok(environment.getProperty("addAddressSuccess"));
		else
			return ResponseEntity.unprocessableEntity().body(environment.getProperty("addAddressFailure"));

	}


	/**
	 * @param profileId
	 * @param addressId
	 * @param model
	 * @return ResponseEntity
	 * @throws ResourceNotFoundException,Exception
	 * 
	 */
	@Transactional
	public ResponseEntity<Object> updateAddress(Long profileId, Long addressId, Addresses model)
			throws IdNotFoundException, Exception {

		if (!profileRepo.existsById(profileId)) {
			throw new IdNotFoundException(environment.getProperty("profileId.NotFound"));
		}
		if (!addressRepo.existsById(addressId)) {
			throw new IdNotFoundException(environment.getProperty("AddressId.NotFound"));
		}
		Profile profile = profileRepo.findByProfileId(profileId);

		model.setAddressId(addressId);
		model.setProfile(profile);
		model.setName(model.getName());
		model.setAddress(model.getAddress());
		model.setCity(model.getCity());
		model.setState(model.getState());
		model.setZipCode(model.getZipCode());
		model.setFriendlyName(model.getFriendlyName());
		model.setContactNumber(model.getContactNumber());
		model.setDefault(model.isDefault());
		boolean flag = model.isDefault();
		List<Addresses> addres = addressRepo.findByDefault(profileId);
		int count = addres.size();
		if (count == 1 && flag == true) {
			Addresses addrr = addressRepo.findByDefaultAndId(profileId);
			long addrId = addrr.getAddressId();
			if (addrId != addressId)
			{
				addrr.setDefault(false);
				 addressRepo.save(addrr);
				
			}
		}
		Addresses addr = addressRepo.save(model);

		if (addressRepo.findById(addr.getAddressId()).isPresent())
			return ResponseEntity.ok(environment.getProperty("updateAddressSuccess"));
		else
			return ResponseEntity.unprocessableEntity().body(environment.getProperty("updateAddressFailure"));
	}
	/**
	 * @param profileId
	 * @param addressId
	 * @return ResponseEntity
	 * @throws ResourceNotFoundException,Exception
	 */
	public ResponseEntity<?> deleteAddress(Long profileId, Long addressId) throws IdNotFoundException {
		Addresses addre = addressRepo.findByAddressIdAndProfileProfileId(addressId, profileId);
		if (addre == null) {
			throw new IdNotFoundException(
					environment.getProperty("addressIdProfileId.NotFound"));
		}

		addressRepo.delete(addre);
		return ResponseEntity.ok(environment.getProperty("deleteAddressSuccess"));

	}
}
