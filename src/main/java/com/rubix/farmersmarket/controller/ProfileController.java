package com.rubix.farmersmarket.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rubix.farmersmarket.domain.Addresses;
import com.rubix.farmersmarket.domain.Profile;
import com.rubix.farmersmarket.exception.IdNotFoundException;
import com.rubix.farmersmarket.repository.AddressesRepository;
import com.rubix.farmersmarket.repository.ProfileRepository;
import com.rubix.farmersmarket.service.AddressesService;
import com.rubix.farmersmarket.service.ProfileService;

/**
 * @author kausar
 * @class ProfileController 
 * This class used for rest api controller for profile management
 *
 */
@CrossOrigin(origins="https://rubixfarm.herokuapp.com")
//@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private AddressesRepository addressRepository;
	@Autowired
	private ProfileService profileService;
	@Autowired
	private AddressesService addressService;

	@Autowired
	private Environment environment;
	
	
	/**
	 * This method used for signUp user 
	 * @method signUpUser
	 * @param profile
	 * @return ResponseEntity
	 */
	@PostMapping("/signUp")
	public ResponseEntity<Object> signUpUser(@RequestBody Profile profile) {
		return profileService.signUpProfile(profile);

	}

	/**
	 * This method used for signin user
	 * @method signInUser
	 * @param profile
	 * @return ResponseEntity
	 */
	@PostMapping("/signIn")
	public ResponseEntity<Long> signInUser(@RequestBody Profile profile) {
		return profileService.signInProfile(profile);

	}

	/**
	 * list all profile values
	 * @return
	 */
	@GetMapping("/getProfiles")
	public List<Profile> getAll() {
		return profileRepository.findAll();

	}

	/**
	 * list all address by id
	 * @param profileId
	 * @return 
	 */
	@GetMapping("/address/{id}")
	public List<Addresses> getAddressById(@PathVariable(value = "id") Long profileId) {
		return addressRepository.findByProfileId(profileId);
	}
	@GetMapping("/address/{id}/{addId}")
	public Addresses getAddressByProfileId(@PathVariable(value = "id") Long profileId,@PathVariable(value = "addId") Long addressId) {
		return addressService.getAddressByProfileId(profileId, addressId);
	}

	/**
	 * This method used for add address
	 * @method addAddress
	 * @param profileId
	 * @param address
	 * @return ResponseEntity
	 * @throws ResourceNotFoundException,Exception
	 */
	@PostMapping("/address/{id}")
	public ResponseEntity<Object> addAddress(@PathVariable(value = "id") Long profileId, @RequestBody Addresses address)
			throws IdNotFoundException, Exception {

		return addressService.addAddress(profileId, address);
	}

	/**
	 * This method used for update address
	 * @method updateAddress
	 * @method addAddress
	 * @param profileId
	 * @param addressId
	 * @param address
	 * @return ResponseEntity
	 * @throws ResourceNotFoundException,Exception
	 */
	@PutMapping("/address/{id}/{addId}")
	public ResponseEntity<Object> updateAddress(@PathVariable(value = "id") Long profileId,
			@PathVariable(value = "addId") Long addressId, @RequestBody Addresses address)
			throws IdNotFoundException, Exception {
		return addressService.updateAddress(profileId, addressId, address);
	}

	/**
	 * This method used for delete address
	 * @method deleteAddress
	 * @param profileId
	 * @param addressId
	 * @return ResponseEntity
	 * @throws ResourceNotFoundException
	 */
	@DeleteMapping("address/{id}/{addId}")
	public ResponseEntity<?> deleteAddress(@PathVariable(value = "id") Long profileId,
			@PathVariable(value = "addId") Long addressId) throws IdNotFoundException {
		return addressService.deleteAddress(profileId, addressId);

	}
	/**
	 * @method envdetails
	 * @return String
	 */
	@GetMapping("/envdetails")
	public String envdetails() {
		return environment.toString();
	}

}
