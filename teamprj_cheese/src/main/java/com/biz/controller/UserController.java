package com.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
//@Controller
import org.springframework.stereotype.Controller;

//interface Controller
//import org.springframework.web.servlet.mvc.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.service.UserService;
import com.biz.vo.UserVO;

@Controller
//1. @Controller 
//   (new=bean, extends/implements ###Controller

public class UserController { // implements Controller {
	@Autowired
	private UserService userService;
	@Autowired
	private UserVO vo;
	
	@RequestMapping(value = "/login") //, method = RequestMethod.POST)
	
	//@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		vo.setId(request.getParameter("id"));
		vo.setPw(request.getParameter("pw"));
		
		vo = userService.getUser(vo);
		
		//3. DB 연동 로직 구현(USERDAO 객체 사용)
		String viewName="";
		if(!vo.getName().equals("")) {
			HttpSession session = request.getSession();
			session.setAttribute("SESS_ID", vo.getId());
			System.out.println(vo.getId());
			session.setAttribute("SESS_NAME", vo.getName());
			mav.setViewName("user/main");
		} else {
			mav.setViewName("user/login");
		} 
		return mav;
	}

	
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		session.invalidate();
		mav.setViewName("user/login");
		return mav;
	}

}
