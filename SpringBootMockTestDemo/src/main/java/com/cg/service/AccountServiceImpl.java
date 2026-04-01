package com.cg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Account;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InsufficientFundException;
import com.cg.repo.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepo repo;

	@Override
	public boolean transferFund(Integer from, Integer to, Double amt) {

	    Optional<Account> optFrom = repo.findById(from);
	    Optional<Account> optTo = repo.findById(to);

	   
	    if (optFrom.isEmpty()) {
	        throw new AccountNotFoundException("From account not found");
	    }

	    if (optTo.isEmpty()) {
	        throw new AccountNotFoundException("To account not found");
	    }

	    Account fromAcc = optFrom.get();
	    Account toAcc = optTo.get();

	    if (fromAcc.getAmt() < amt) {
	        throw new InsufficientFundException("Insufficient balance");
	    }

	    fromAcc.setAmt(fromAcc.getAmt() - amt);
	    toAcc.setAmt(toAcc.getAmt() + amt);

	    repo.save(fromAcc);
	    repo.save(toAcc);

	    return true;
	}
}