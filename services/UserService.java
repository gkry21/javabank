package com.javabank.services;

import com.javabank.domains.CustomerBean;
import com.javabank.domains.UserBean;

public interface UserService {

	String join(CustomerBean param);
	CustomerBean[] findAll();
	UserBean[] findByName(String name);
	CustomerBean findById(String id);
	boolean login(CustomerBean param);
	int countMembers();
	boolean existId(String id);
	void updatePass(CustomerBean param);
	void deleteMember(CustomerBean param);
	
	
}
