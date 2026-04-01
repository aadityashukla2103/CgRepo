package com.cg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id
	private Integer accountId;
	private String custName;
	private Double amt;

	public Account() {
	}
	

	public Account(Integer accountId, String custName, Double amt) {
		super();
		System.out.println("Constr done ");
		this.accountId = accountId;
		this.custName = custName;
		this.amt = amt;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Double getAmt() {
		return amt;
	}

	public void setAmt(Double amt) {
		this.amt = amt;
	}
}
