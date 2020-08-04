package com.hipporing.board.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hipporing.board.core.base.BaseController;
import com.hipporing.board.test.service.LoginService;
import com.hipporing.board.test.service.TestService;
import com.hipporing.board.test.vo.LoginVO;
import com.hipporing.board.test.vo.TestVO;

@Controller
@RequestMapping(value = "") //어노테이션
public class WebController extends BaseController {
	
	@Autowired
	private TestService testService;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/", method = {RequestMethod.GET})
	public String index(Model model) { //접근지정자 반환형  메소드명 (파라미터명)
		
		List<TestVO> tests = this.testService.getTests();
		model.addAttribute("tests", tests);   //(String=key, Object=value)
		
//		for(TestVO test : tests) {
//			System.out.println(test.getKey());
//		}
//		
//		this.log.trace("TRACE");
//		this.log.debug("DEBUG");
//		this.log.info("INFO");
//		this.log.warn("WARN");
//		this.log.error("ERROR");
//		
		return "web/index";
	}
	
	@RequestMapping(value="/write", method = {RequestMethod.GET})
	public String write() {
		return "web/write";
	}
	
	@RequestMapping(value="/write", method = {RequestMethod.POST})
	public String postWrite(TestVO test,
			HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		
		test.setRegId(id);
		
		this.log.debug(test.toString());
		
		this.testService.insertTest(test);
		
		return "redirect:/"; //redirecting할 때는 url, /는 상대경로
	}
	
	@RequestMapping(value="/detail/{key}", method = {RequestMethod.GET})
	public String detail(@PathVariable(name = "key", required = true) int key
			, Model model
			, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		model.addAttribute("userId", id);
		
		TestVO test = this.testService.getTest(key);
		model.addAttribute("test", test);
		return "web/detail";
	}
	
	@RequestMapping(value="/delete", method = {RequestMethod.POST})
	public String delete(TestVO test) {
		
		this.testService.deleteTest(test.getKey());
		return "redirect:/";
	}
	
	@RequestMapping(value = "/update/{key}", method= {RequestMethod.GET})
	public String update(@PathVariable(name = "key", required = true) int key
			, Model model) {
		
		TestVO test = this.testService.getTest(key);
		model.addAttribute("test", test);
		
		return "web/update";
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST})
	public String postUpdate(TestVO test) {
		
		this.testService.updateTest(test);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login", method = {RequestMethod.GET})
	public String login() {
		
		return "web/login";
	}
	
	@RequestMapping(value = "/login", method = {RequestMethod.POST})
	public String postLogin(LoginVO login
			, HttpServletRequest req) {
		
		if (this.loginService.checkLogin(login)){
			HttpSession session = req.getSession();
			session.setAttribute("id", login.getId());
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/logout", method = {RequestMethod.GET})
	public String logout(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		return "redirect:/";
	} 
}
