package com.javabank.serviesImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.javabank.domains.AccountBean;
import com.javabank.services.AccountService;

public class AccountServiceImpl implements AccountService{
	
	private AccountBean[] accounts;
	private SimpleDateFormat sdf;
	private Date dt;
	private int count;
	
	
	public AccountServiceImpl() {
		accounts = new AccountBean[10];
		count=0;
	}

	@Override
	public void createAccount(String money) {
		AccountBean acc = new AccountBean();
		acc.setAccountNum(createAccountNum());
		acc.setMoney(money+"");
		acc.setToday(findDate());
		
		accounts[count] = acc;
		count++;
	}

	@Override
	public String createAccountNum() {
		
		Random  rd = new Random();
		String temp = (rd.nextInt(100000000))+"";
		String accountNum =temp.substring(0, 4) +"-" + temp.substring(4, 8);
		return accountNum;
	}

	@Override
	public AccountBean[] findAll() {
		
		return accounts;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		
		AccountBean acountBean = new AccountBean();
		for (int i = 0; i < count; i++) {
			if (accountNum.equals(accounts[i].getAccountNum())) {
				acountBean = accounts[i];
				break;
			}	
		}
		return acountBean;
	}

	@Override
	public int countAccounts() {
		return count;
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		boolean result = false;
		
		for (int i = 0; i < count; i++) {
			if (accountNum.equals(accounts[i].getAccountNum())) {
				result = true;
				break;
			}	
		}
		return result;
	}

	@Override
	public String findDate() {
		
		dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String nowday = sdf.format(dt);
		return nowday;
	}

	@Override
	public void depositMoney(AccountBean param) {

		String accNum = param.getAccountNum();
		String money = param.getMoney();
		
		for (int i = 0; i < count; i++) {
			if (accNum.equals(accounts[i].getAccountNum())) {
				String accmoney =String.valueOf(Integer.parseInt(accounts[i].getMoney())+ Integer.parseInt(money));
				accounts[i].setMoney(accmoney);
				accounts[i].setToday(findDate());
				break;
			}
		}
		
	}

	@Override
	public void withdrawMoney(AccountBean param) {
		

		String accNum = param.getAccountNum();
		String money = param.getMoney();
		
		for (int i = 0; i < count; i++) {
			if (accNum.equals(accounts[i].getAccountNum())) {
				String accmoney =String.valueOf(Integer.parseInt(accounts[i].getMoney())- Integer.parseInt(money));
				accounts[i].setMoney(accmoney);
				accounts[i].setToday(findDate());
				break;
			}
		}
		
		
		
	}

	@Override
	public void deleteAccountNum(String accountNum) {
		
		for (int i = 0; i < count; i++) {
			if (accountNum.equals(accounts[i].getAccountNum())) {
				accounts[i] = null;
				break;
			}
		}
		
				
	}

}
