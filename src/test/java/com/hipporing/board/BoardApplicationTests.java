package com.hipporing.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hipporing.board.test.service.TestService;
import com.hipporing.board.test.vo.TestVO;


//Test 전용 유닛
@SpringBootTest //Test를 위해서 서버를 켜겠다
class BoardApplicationTests {
	@Autowired
	private TestService testService;

	@Test
	void contextLoads() {
		int key = 1;
		TestVO test = this.testService.getTest(key);

		System.out.println(test.toString());
	}

}
