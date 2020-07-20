package com.hipporing.board.test.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hipporing.board.test.vo.TestVO;

//값을 불러옴
@Repository
public class TestDao {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	//TestVO의 값들을 받아오는 함수
	//보통 이런식으로 DB에서 값을 받아옴 sqlSession.selectOne("test.test.getTest", param);
	
	public TestVO getTest(int key) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("key", key);
		TestVO test = this.sqlSession.selectOne("test.getTest", param);
		return test;
	}
	
	public List<TestVO> getTests() {
		List<TestVO> test = this.sqlSession.selectList("test.getTests");
		return test;
	}
	
	public int insertTest(TestVO test) {
		return this.sqlSession.insert("test.insertTest", test);
	}
	
	public int deleteTest(int key) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("key", key);
		return this.sqlSession.delete("test.deleteTest", key);
	}
	
	public int updateTest(TestVO test) {
		return this.sqlSession.update("test.updateTest", test);
	}
}
