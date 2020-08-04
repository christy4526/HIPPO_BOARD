package com.hipporing.board.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hipporing.board.core.base.BaseService;
import com.hipporing.board.test.dao.LoginDao;
import com.hipporing.board.test.vo.LoginVO;

@Service
public class LoginService extends BaseService {
	
	@Autowired
	private LoginDao loginDao;
	
	// TestVO의 값을 받아오는 함수를 TestDao에서 호출하도록 하는 함수
	// private TestDao testDao = new TestDao();
	// component를 bean이라고 함
	public boolean checkLogin(LoginVO login) {
		return (this.loginDao.checkLogin(login) > 0);
	}
	

}
