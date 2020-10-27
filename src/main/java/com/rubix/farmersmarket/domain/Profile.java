package com.rubix.farmersmarket.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "profile", schema = "public")
/**
 * @author kausar
 * @class profile 
 * This class used for profile entity
 *
 */
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// Initialize the profileId variable
	private long profileId;
	@Column(name = "username", nullable = false)
	// Initialize the username variable
	private String username;
	@Column(name = "emailId", nullable = false)
	// Initialize the emailId variable
	private String emailId;
	@Column(name = "mobile", nullable = false)
	// Initialize the mobile variable
	private String mobile;
	@Column(name = "password", nullable = false)
	// Initialize the password variable
	private String password;

	@Column(name = "role", nullable = false)
	// Initialize the role variable
	private String role;
	@Column(name = "verified", nullable = false)
	// Initialize the verified variable
	private String verified;

	@JsonManagedReference
	@OneToMany(mappedBy = "profile", cascade = CascadeType.REMOVE)
	private List<Addresses> addresses;

	public Profile() {

	}

	public Profile(long profileId, String username, String emailId, String mobile, String password, String role,
			String verified) {
		super();
		this.profileId = profileId;
		this.username = username;
		this.emailId = emailId;
		this.mobile = mobile;
		this.password = password;
		this.role = role;
		this.verified = verified;
	}

	/**
	 * * getProfileId
     * @return long
	 */

	public long getProfileId() {
		return profileId;
	}

	/**
	 * @param profileId
	 */

	public void setProfileId(long profileId) {
		this.profileId = profileId;
	}

	/**
	 * getUsername
	 * @return String
	 */

	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @param username
	 */

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * getEmailId
	 * @return String
	 */

	public String getEmailId() {
		return emailId;
	}

	/**
	 * 
	 * 
	 * @param emailId
	 */

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * getMobile
	 * @return String
	 */

	public String getMobile() {
		return mobile;
	}

	/**
	 * *
	 * @param mobile
	 */

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * getMobile
	 * @return String
	 */

	public String getPassword() {
		return password;
	}

	/**
	 * *
	 * @param password
	 */

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * getRole
	 * @return String
	 */

	public String getRole() {
		return role;
	}

	/**
	 * 
	 * @param role
	 */

	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * getVerified
	 * @return String
	 */
	public String getVerified() {
		return verified;
	}

	/**
	 * 
	 * @param verified
	 */
	public void setVerified(String verified) {
		this.verified = verified;
	}

	/**
	 * getAddresses
	 * @return
	 */
	public List<Addresses> getAddresses() {
		return addresses;
	}

	/**
	 *  @param addresses
	 */
	public void setAddresses(List<Addresses> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", username=" + username + ", email=" + emailId + ",mobile=" + mobile
				+ ",password=" + password + ",role=" + role + ",verified=" + verified + "]";
	}

}