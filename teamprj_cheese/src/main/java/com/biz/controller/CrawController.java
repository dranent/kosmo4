package com.biz.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.biz.common.WebCraw;
import com.biz.service.CartService;
import com.biz.vo.CrawVO;

@Controller
public class CrawController {
	@Autowired
	private CartService cartService;
	
	//--------------------------------------------------------
	// 기상청  : 일기예보 크롤링 
	//--------------------------------------------------------
	@RequestMapping(value = "/weather", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> weather(
			@RequestParam(value="x", required=false, defaultValue="67") int x ,
			@RequestParam(value="y", required=false, defaultValue="123") int y) {
		
		String url = "http://www.weather.go.kr/weather/forecast/digital_forecast.jsp?x="+x+"&y="+y;
		WebCraw craw = new WebCraw();
		HashMap<String, String> resMap = craw.getWeather(url);
		System.out.println(resMap.get("key_temp"));
		System.out.println(resMap.get("key_weather"));
		return resMap;  //{"key_temp":17, ""key_weather":"맑음"}
	}
	
	
	//--------------------------------------------------------
	// YTN  : YTN뉴스 크롤링
	//--------------------------------------------------------
	@RequestMapping(value = "/ytn", method = RequestMethod.GET)
	public ModelAndView ytnList( ) {
		WebCraw craw = new WebCraw();
		ArrayList<CrawVO> list = craw.getYtnNews();
		ModelAndView mav = new ModelAndView();
		mav.addObject("LVL_LIST", list);
		mav.setViewName("news/list_ytn");
		return mav;
	}
	
	//--------------------------------------------------------
	// 알라딘  : 베스트북 크롤링 
	//--------------------------------------------------------
	@RequestMapping(value = "/aladin", method = RequestMethod.GET)
	public ModelAndView aladinList( ) {
		WebCraw craw = new WebCraw();
		ArrayList<CrawVO> alaList = craw.getAladinBookList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("LVL_LIST", alaList);
		mav.setViewName("book/list_aladin");
		return mav;
	}
	
}
