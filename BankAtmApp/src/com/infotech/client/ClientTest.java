package com.infotech.client;

import com.infotech.model.Account;
import com.infotech.worker.AccountHolder;

public class ClientTest {
	
	public static void main(String[] args) {
		Account account  = new Account();
		AccountHolder accountholder = new AccountHolder(account);
		Thread t1 = new Thread(accountholder);
		Thread t2 = new Thread(accountholder);
		t1.setName("Jack");
		t2.setName("Joya");
		
		t1.start();
		t2.start();
	}

}
