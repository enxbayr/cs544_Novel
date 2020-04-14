package edu.mum.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import edu.mum.validation.EmptyOrSize;

/*
 * @JsonIdentityInfo USED with UserCredentials [also has @JsonIdentityInfo]
 * ALSO INSTEAD could use:
 * @JsonBackReference() uncomment on UserCredentials below
 * AND uncomment @JsonManagedReference() on Member in  UserCredentials.java
 * 
 *  @JsonIgnoreProperties(value="member") USED on Addresses
 */

@Entity
@Table(name = "USER")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 16)
	@NotEmpty(message = "{NotEmpty}")
	private String firstName;

	@Column(length = 16)
	@EmptyOrSize(min = 6, max = 16, message = "{Size.name.validation}")
	private String lastName;

	@Column(length = 32)
	@Size(min = 6, max = 32, message = "{Size.name.validation}")
	private String title;

	private LocalDate dob;

	@Email(message = "{EmailValid}")
	private String email;

	@NotNull(message = "{NotNull}")
	private Integer userNumber;

	@Valid
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
// 	@JsonManagedReference()               // Works with JsonBackReference in UserCredentials
//	 @JsonIgnoreProperties(value="member")
	UserCredentials userCredentials;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JsonIgnoreProperties(value = "user")
	// @JsonManagedReference()
	@Valid
	private List<Address> addresses = new ArrayList<Address>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public UserCredentials getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public void addAddress(Address address) {
		this.addresses.add(address);
		address.setMember(this);
	}

	public Integer getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(Integer userNumber) {
		this.userNumber = userNumber;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
