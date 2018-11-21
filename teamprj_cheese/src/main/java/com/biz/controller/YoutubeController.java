package com.biz.controller;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//error
//import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.biz.common.YoutubeSearch;
import com.biz.service.BoardService;
import com.biz.vo.BoardReplyVO;
import com.biz.vo.BoardVO;
import com.biz.vo.YoutubeVO;
import com.google.gson.Gson;

@Controller
public class YoutubeController {
	
	private static final Logger logger = LoggerFactory.getLogger(YoutubeController.class);

	@RequestMapping(value = "/search", method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView list(@RequestParam(value="searchStr", defaultValue = "" ) String searchStr) {
		System.out.println("Controller ......");
		
		
		//---------------------구글 Youtube 검색 API 호출 com.biz.common.YoutubuSearch.java -------------------------------- 
		YoutubeSearch svc = new YoutubeSearch();
	
		ArrayList<YoutubeVO> list =  new ArrayList<YoutubeVO>();  
		if(!searchStr.equals("")) {
			list = svc.search(searchStr);
//			for (int i = 0; i < list.size(); i++) 
//				System.out.println(list.get(i).getImgurl() + "," + list.get(i).getTitle() + "," + "https://www.youtube.com/watch?v="+list.get(i).getVideoId());
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("LVL_LIST", list);
		mav.setViewName("youtube/list");
		return mav;
	}
	
	
}