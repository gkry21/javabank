package com.javabank.controllers;

import javax.swing.JOptionPane;

import com.javabank.domains.AccountBean;
import com.javabank.services.AccountService;
import com.javabank.serviesImpl.AccountServiceImpl;

//void createAccount(int money);
//public String createAccountNum();
//// 계좌번호 생성(1234-5678)
//AccountBean[] findAll();
//AccountBean findByAccountNum(String accountNum);
//int countAccounts();
//boolean existAccountNum(String accountNum);
//String findDate(); // 오늘날짜, 현재시간(분까지) 반환
//void depositMoney(AccountBean param);
//void withdrawMoney(AccountBean param);
//void deleteAccountNum(String accountNum);
//



public class AdminSontroller {
	
	public static void main(String[] args) {

		AccountBean accountBean = null;
		AccountService as = new AccountServiceImpl();
		
		while (true) {
			
			switch (JOptionPane.showInputDialog(
					"00.종료"
							+ "\n-------관리자 기능---------\n"
							+ "01. 계좌 생성 \n "
							+ "02. 계좌 정보 보기 \n  "
							+ "03. 계좌번호 조회하기 \n "
							+ "04. 계좌 수 확인  \n"
							+ "05. 존재하는 계좌 확인 \n"
							+ "06. 예금 \n"
							+ "07. 인출 \n"
							+ "08. 계좌 삭제 \n")) {
			case "00": JOptionPane.showMessageDialog(null, "종료합니다.");
				
				return;
			case "01":
				as.createAccount(JOptionPane.showInputDialog("개설할 계좌의 금액을 입력하세요"));
				
				break;
			case "02":
				JOptionPane.showMessageDialog(null,as.findAll());
				break;
			case "03":
				JOptionPane.showMessageDialog(null, as.findByAccountNum(JOptionPane.showInputDialog("계좌번호를 입력하세요")));
				break;
			case "04":
				JOptionPane.showMessageDialog( null, String.format("계좌는 총 %d입니다 ", as.countAccounts()) );
				
				break;
			case "05":
				JOptionPane.showMessageDialog(null, ""+as.findByAccountNum(JOptionPane.showInputDialog("계좌번호를 입력하세요")));
				break;
			case "06":
				
				String[] arr =JOptionPane.showInputDialog("계좌번호, 개설할 계좌의 금액을 입력하세요").split(","); 
				accountBean = new AccountBean();
				accountBean.setAccountNum(arr[0]);
				accountBean.setMoney(arr[1]);
				as.depositMoney(accountBean);
				break;
			case "07":
				String[] arr1 =JOptionPane.showInputDialog("계좌번호, 개설할 계좌의 금액을 입력하세요").split(","); 
				accountBean = new AccountBean();
				accountBean.setAccountNum(arr1[0]);
				accountBean.setMoney(arr1[1]);
				as.depositMoney(accountBean);
				break;
			case "08":
				as.deleteAccountNum(JOptionPane.showInputDialog("계좌번호를 입력하세요"));
				break;

			}
			
			
		}
	}//main

}
