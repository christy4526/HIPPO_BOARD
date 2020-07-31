package com.hipporing.board.test.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hipporing.board.test.vo.LoginVO;

//값을 불러옴
@Repository
public class LoginDao {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	//TestVO의 값들을 받아오는 함수
	//보통 이런식으로 DB에서 값을 받아옴 sqlSession.selectOne("test.test.getTest", param);
	
	public int checkLogin(LoginVO login) {
		return sqlSession.selectOne("login.checkLogin", login);
	}
}
