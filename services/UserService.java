package com.javabank.services;

import com.javabank.domains.*;

public interface UserService {

	String join(CustomerBean param);
	CustomerBean[] findAllCustomers();
	AdminBean[] findAllAdmins();	
	UserBean[] findByName(String name);
	UserBean findById(String id);
	boolean login(UserBean param);
	int countMembers();
	int countAdmins(); // 직원수
	boolean existId(String id);
	void updatePass(CustomerBean param);
	void deleteMember(CustomerBean param);

	
}
