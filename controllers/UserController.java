package com.javabank.controllers;

import javax.swing.JOptionPane;

import com.javabank.domains.CustomerBean;
import com.javabank.services.UserService;
import com.javabank.serviesImpl.UserServiceImpl;

public class UserController {

	public static void main(String[] args) {

		CustomerBean cb = null;
		UserService us = new UserServiceImpl();


		while (true) {

			switch (JOptionPane.showInputDialog(
					"00.종료"
							+ "\n-------사용자 기능 ---------\n"
							+ "01.회원가입 \n "
							+ "02. 회원 리스트 \n  "
							+ "03. 이름 찾기 \n  "
							+ "04. 아이디 찾기 \n "
							+ "05. 로그인  \n"
							+ "06. 회원 수 확인 \n"
							+ "07. 아이디확인 \n"
							+ "08. 비밀번호 변경 \n"
							+ "09. 회원탈퇴 \n")) {
							case "00": JOptionPane.showMessageDialog(null, "종료합니다");

							return;
							case "01": 
								cb = new CustomerBean();
								String[] arr1 = JOptionPane.showInputDialog("아이디, 비번 , 이름, 주민번호를 입력하세요  ").split(",");
								cb.setId(arr1[0]);
								cb.setPass(arr1[1]);
								cb.setName(arr1[2]);
								cb.setSsn(arr1[3]);

								JOptionPane.showMessageDialog(null, us.join(cb));

								break;
							case "02":
								JOptionPane.showMessageDialog(null, us.findAllCustomers());

								break;
							case "03":
								JOptionPane.showMessageDialog(null, us.findByName(JOptionPane.showInputDialog("이름을 입력하세요")));

								break;
							case "04":
								JOptionPane.showMessageDialog(null, us.findById(JOptionPane.showInputDialog("아이디를 입력하세요")));

								break;
							case "05":
								cb = new CustomerBean();
								String[] arr = JOptionPane.showInputDialog("아이디, 비번을 입력하세요").split(",");
								cb.setId(arr[0]);
								cb.setPass(arr[1]);
								System.out.println(us.login(cb));

								if(us.login(cb)) {
									JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다.");
								}else {
									JOptionPane.showMessageDialog(null, "로그인 실패");
								}

								break;
							case "06":
								JOptionPane.showMessageDialog(null, String.format("회원수는 %s명입니다.", us.countMembers()));
								break;

							case "07":
								if(us.existId(JOptionPane.showInputDialog("아이디를 입력하세요"))) {
									JOptionPane.showMessageDialog(null, "존재하는 아이디 입니다");
								}else {
									JOptionPane.showMessageDialog(null, "존재하지 않는 아이디 입니다");
								}
								break;
							case "08":
								cb = new CustomerBean();
								arr = JOptionPane.showInputDialog("아이디, 이전 비번 , 새로 변경할 비번을 입력하세요").split(",");
								cb.setId(arr[0]);
								cb.setPass(arr[1]+arr[2]);

								us.updatePass(cb);

								break;
							case "09":
								cb = new CustomerBean();
								arr = JOptionPane.showInputDialog("삭제할 아이디와 비번을 입력하세요").split(",");
								cb.setId(arr[0]);
								cb.setPass(arr[1]);
								us.deleteMember(cb);

								break;
			}//switch
		}//while
	}

}
