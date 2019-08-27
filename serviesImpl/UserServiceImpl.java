package com.javabank.serviesImpl;

import com.javabank.domains.*;
import com.javabank.services.UserService;

public class UserServiceImpl implements UserService {

	private AdminBean[] abs;
	private CustomerBean[] cbs;
	private int aCount;
	private int cCount;


	public UserServiceImpl(){
		abs = new AdminBean[10];
		cbs = new CustomerBean[10];
		aCount=0;
		cCount=0;
	}

	@Override
	public String join(CustomerBean param) {
		String result ="가입에 성공하였습니다.";
		cbs[cCount] = param;
		cCount++;
		
		return result;
	}

	@Override
	public CustomerBean[] findAll() {

		return cbs;
	}

	@Override
	public UserBean[] findByName(String name) {
		int cCnt = 0;
		int aCnt = 0;

		// CustomerBean 탐색
		for (int i = 0; i < cCount; i++) {
			if(name.equals(cbs[i].getName())) {
				cCnt++;
			}
		}
		//AdminBean 탐색
		for (int i = 0; i < aCount; i++) {
			if (name.equals(abs[i].getName())) {
				aCnt++;
			}
		}

		//CustomerBean과 AdminBean에서 찾은 이름 수 만큼의 UserBean을 생성한다.
		UserBean[] userBean = new UserBean[cCnt+aCnt];
		//CustomerBean에서 이름 탐색하여 입력
		for (int i = 0; i < cCount; i++) {
			if(name.equals(cbs[i].getName())) {
				userBean[cCnt-1] = cbs[i];
				if ((userBean.length-aCnt)==cCnt ) {  //CustomerBean에서 찾은 이름 수만큼 찾은 후 종료  
					break;
				}
				cCnt++;
			}
		}
		//AdminBean에서 탐색하여 입력
		for (int i = 0; i < aCount ; i++) {
			if(name.equals(abs[i].getName())) {
				userBean[cCnt+aCnt-1] = abs[i];
				if ((userBean.length-cCnt)==aCnt ) { //AdminBean에서 찾은 이름 수만큼 찾은 후 종료 
					break;
				}
				aCnt++;
			}
		}

		return userBean;
	}

	@Override
	public UserBean findById(String id) {
		

		UserBean ub = new UserBean();
		for (int i=0; i < cCount; i++) {
			if (id.equals(cbs[i].getId())) {
				ub = cbs[i];
				break;
			} 
		}
		
		for (int i=0; i < aCount; i++) {
			if (id.equals(abs[i].getId())) {
				ub = abs[i];
				break;
			} 
		}

		return ub;
	}

	@Override
	public boolean login(UserBean param) {

		boolean result = false;
		String userId = param.getId();
		String userPw = param.getPass();

		for (int i = 0; i < cCount; i++) {
			if (userId.equals(cbs[i].getId())) {

				if(userPw.equals(cbs[i].getPass())) {
					result = true;
					break;
				}
			}
		}
		
		for (int i = 0; i < aCount; i++) {
			if (userId.equals(abs[i].getId())) {
				
				if(userPw.equals(abs[i].getPass())) {
					result = true;
					break;
				}
			}
		}

		return result;
	}

	@Override
	public int countMembers() {

		return cCount;
	}

	@Override
	public boolean existId(String id) {
		boolean result = false;

		for (int i = 0; i < cCount; i++) {
			if (id.equals(cbs[i].getId())) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public void updatePass(CustomerBean param) {

		String id = param.getId();
		String oldPw = param.getPass().substring(0, 4);
		String newPW= param.getPass().substring(4, 8);

		for (int i = 0; i < cCount; i++) {
			if(id.equals(cbs[i].getId()) && oldPw.equals(cbs[i].getPass())) {
				cbs[i].setPass(newPW);
				break;
			}
		}
	}

	@Override
	public void deleteMember(CustomerBean param) {

		String userId = param.getId();
		String userPw = param.getPass();

		for (int i = 0; i < cCount; i++) {
			if(userId.equals(cbs[i].getId())){
				if(userPw.equals(cbs[i].getPass())) {
					//회원 탈퇴 프로세스 진행   
					cbs[i] = null;
					for (int j = i; j < cCount; j++) {
						cbs[j] = cbs[j+1];
					}
					cbs[cbs.length-1] = null;
					cCount-- ;

					break;
				}
				break;
			}
		}

	}

	@Override
	public AdminBean[] findAllAdmins() {
		return abs;
	}

	@Override
	public int countAdmins() {
		return aCount;
	}

}
