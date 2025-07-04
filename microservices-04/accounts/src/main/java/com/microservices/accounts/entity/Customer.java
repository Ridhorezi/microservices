package com.microservices.accounts.entity;

import jakarta.persistence.*;

/**
 * @author Ridho Suhaebi Arrowi
 */

@Entity
public class Customer extends BaseEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
	private Long customerId;

	private String name;
	
	private String email;

	@Column(name = "mobile_number")
	private String mobileNumber;

	public Customer() {
	}

	public Customer(Long customerId, String name, String email, String mobileNumber) {
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", mobileNumber="
				+ mobileNumber + ", getCustomerId()=" + getCustomerId() + ", getName()=" + getName() + ", getEmail()="
				+ getEmail() + ", getMobileNumber()=" + getMobileNumber() + ", getCreatedAt()=" + getCreatedAt()
				+ ", getCreatedBy()=" + getCreatedBy() + ", getUpdatedAt()=" + getUpdatedAt() + ", getUpdatedBy()="
				+ getUpdatedBy() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}
}
