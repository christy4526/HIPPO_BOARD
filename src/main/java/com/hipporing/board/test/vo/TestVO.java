package com.hipporing.board.test.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//data를 받는 틀
@Getter
@Setter
@ToString
public class TestVO {
	private int key;
	private String param1;
	private String param2;
	private String param3;
	private String regId;
	private Date regDtt;
}
