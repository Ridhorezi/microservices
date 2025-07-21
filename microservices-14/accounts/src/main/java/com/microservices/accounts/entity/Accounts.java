package com.microservices.accounts.entity;

import jakarta.persistence.*;

/**
 * @author Ridho Suhaebi Arrowi
 */

@Entity
public class Accounts extends BaseEntity {

	@Column(name = "customer_id")
	private Long customerId;

	@Id
	@Column(name = "account_number")
	private Long accountNumber;

	@Column(name = "account_type")
	private String accountType;

	@Column(name = "branch_address")
	private String branchAddress;

	@Column(name = "communication_sw")
	private Boolean communicationSw;

	public Accounts() {
	}

	public Accounts(Long customerId, Long accountNumber, String accountType, String branchAddress,
			Boolean communicationSw) {
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.branchAddress = branchAddress;
		this.communicationSw = communicationSw;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public Boolean getCommunicationSw() {
		return communicationSw;
	}

	public void setCommunicationSw(Boolean communicationSw) {
		this.communicationSw = communicationSw;
	}

	@Override
	public String toString() {
		return "Accounts [customerId=" + customerId + ", accountNumber=" + accountNumber + ", accountType="
				+ accountType + ", branchAddress=" + branchAddress + ", communicationSw=" + communicationSw
				+ ", getCustomerId()=" + getCustomerId() + ", getAccountNumber()=" + getAccountNumber()
				+ ", getAccountType()=" + getAccountType() + ", getBranchAddress()=" + getBranchAddress()
				+ ", getCommunicationSw()=" + getCommunicationSw() + ", getCreatedAt()=" + getCreatedAt()
				+ ", getCreatedBy()=" + getCreatedBy() + ", getUpdatedAt()=" + getUpdatedAt() + ", getUpdatedBy()="
				+ getUpdatedBy() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}
}
