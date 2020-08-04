package com.hipporing.board.core.base;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class BaseDao {

	protected final Logger log = LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	protected SqlSession sqlSession;
	//TestVO의 값들을 받아오는 함수
	//보통 이런식으로 DB에서 값을 받아옴 sqlSession.selectOne("test.test.getTest", param);
	
}
