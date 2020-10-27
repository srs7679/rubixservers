package com.rubix.farmersmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import com.rubix.farmersmarket.domain.Addresses;
import com.rubix.farmersmarket.domain.Profile;
import com.rubix.farmersmarket.repository.AddressesRepository;
import com.rubix.farmersmarket.repository.ProfileRepository;

/**
 * @author kausar
 * @class ProfileService 
 * This class used for service for profile management
 *
 */
@Service
public class ProfileService {
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private AddressesRepository addressRepository;
	@Autowired
	private Environment environment;

	/**
	 * This method used for signUp
	 * @method signUpProfile
	 * @param model
	 * @return ResponseEntity
	 */
	public ResponseEntity<Object> signUpProfile(Profile model) {

		Profile user = new Profile();
		if (profileRepository.findByEmailId(model.getEmailId()).isPresent()) {
			return ResponseEntity.badRequest().body(environment.getProperty("email.exist"));
		} else {

			user.setProfileId(user.getProfileId());
			user.setUsername(model.getUsername());
			user.setEmailId(model.getEmailId());
			user.setMobile(model.getMobile());
			user.setPassword(model.getPassword());
			user.setRole("customer");
			user.setVerified("true");

			Profile savedUser = profileRepository.save(user);
			// Set the dafault Address
			Long id = savedUser.getProfileId();
			Profile profile = profileRepository.findByProfileId(id);
			Addresses addresses  = new Addresses();
			addresses.setAddress(model.getAddresses().get(0).getAddress());
			addresses.setName(model.getUsername());
			addresses.setCity(model.getAddresses().get(0).getCity());
			addresses.setState(model.getAddresses().get(0).getState());
			addresses.setZipCode(model.getAddresses().get(0).getZipCode());
			addresses.setFriendlyName(model.getUsername());
			addresses.setContactNumber(model.getMobile());
			addresses.setDefault(true);
			addresses.setProfile(profile);
			addressRepository.save(addresses);

			if (profileRepository.findById(savedUser.getProfileId()).isPresent())
				return ResponseEntity.ok(environment.getProperty("signUpProfileSuccess"));
			else
				return ResponseEntity.unprocessableEntity().body(environment.getProperty("signUpProfileFailure"));
		}
	}

	/**
	 * This method used for signin validation
	 * @method signInProfile
	 * @param profile
	 * @return ResponseEntity
	*/
	public ResponseEntity<Long> signInProfile(Profile profile) {
		String email = profile.getEmailId();
		String pass = profile.getPassword();
		System.out.println(email+" "+pass);
		Profile pro = null;
		if (email != null && pass != null) {
			pro = profileRepository.findByEmailIdAndPassword(email, pass);
			
		} else
			return new ResponseEntity<Long>(HttpStatus.BAD_REQUEST);
		if (pro != null) {
			long id=profileRepository.findProfileIdByEmailIdAndPassword(email, pass);
			return new ResponseEntity<Long>(id,HttpStatus.OK);
		}
		else
			return new ResponseEntity<Long>(HttpStatus.UNPROCESSABLE_ENTITY);
	
	
	}
}