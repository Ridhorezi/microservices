package com.microservices.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

/**
 * @author Ridho Suhaebi Arrowi
 */

@Schema(name = "Accounts", description = "Schema to hold Account information")
public class AccountsDto {

	@NotEmpty(message = "AccountNumber can not be a null or empty")
	@Schema(description = "Account Number of Bank account", example = "3454433243")
	private Long accountNumber;

	@NotEmpty(message = "AccountType can not be a null or empty")
	@Schema(description = "Account type of Bank account", example = "Savings")
	private String accountType;

	@NotEmpty(message = "BranchAddress can not be a null or empty")
	@Schema(description = "Bank branch address", example = "123 Jakarta")
	private String branchAddress;

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
}
