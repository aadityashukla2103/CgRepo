package com.cg;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.cg.entity.Account;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InsufficientFundException;
import com.cg.repo.AccountRepo;
import com.cg.service.AccountService;

@SpringBootTest
public class AccountTransferfundTest {

	private Optional<Account> optAcc1, optAcc2, optAcc3;

	@MockitoBean
	private AccountRepo repo;

	@Autowired
	private AccountService service;

	@BeforeEach
	public void beforeEach() {

		Account acc1 = new Account(1001, "ram", 5000.0);
		Account acc2 = new Account(1002, "tom", 7000.0);

		optAcc1 = Optional.ofNullable(acc1);
		optAcc2 = Optional.ofNullable(acc2);
		optAcc3 = Optional.empty();

	}

	@Test
	public void testTransferFund1() {

		Mockito.when(repo.findById(1001)).thenReturn(optAcc1);
		Mockito.when(repo.findById(1002)).thenReturn(optAcc2);
		Mockito.when(repo.save(Mockito.any(Account.class))).thenReturn(new Account());
		assertTrue(service.transferFund(1001, 1002, 2000.0));
		Mockito.verify(repo).findById(1001);
		Mockito.verify(repo).findById(1002);
        Mockito.verify(repo).save(Mockito.any(Account.class));
	}

	@Test
	public void testTransferFund2() {
		Mockito.when(repo.findById(1001)).thenReturn(optAcc1);
		Mockito.when(repo.findById(1003)).thenReturn(optAcc3);

		assertThrows(AccountNotFoundException.class, () -> {
			service.transferFund(1001, 1003, 2000.0);
		});
	}

	@Test
	public void testTransferFund3() {
		Mockito.when(repo.findById(1001)).thenReturn(optAcc1);
		Mockito.when(repo.findById(1002)).thenReturn(optAcc2);

		assertThrows(InsufficientFundException.class, () -> {
			service.transferFund(1001, 1002, 7000.0);
		});
	}
	
	
	
	
	Mokito.verify(drepo).findById();

}