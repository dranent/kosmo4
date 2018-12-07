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
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ddf.EscherColorRef.SysIndexProcedure;
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

import com.biz.common.InterestRandom;
import com.biz.common.YoutubeSearch;
import com.biz.service.BoardService;
import com.biz.service.MemberInterestService;
import com.biz.service.MemberService;
import com.biz.service.UserService;
import com.biz.vo.BoardReplyVO;
import com.biz.vo.BoardVO;
import com.biz.vo.CartVO;
import com.biz.vo.CategoryVO;
import com.biz.vo.InterestVO;
import com.biz.vo.MemberInterestVO;
import com.biz.vo.MemberVO;
import com.biz.service.YoutubeService;
import com.biz.service.impl.MemberServiceImpl;
import com.biz.vo.UserVO;
import com.biz.vo.YoutubeVO;
import com.google.gson.Gson;

@Controller
public class YoutubeController {
	@Autowired
	private YoutubeService ysv;
	@Autowired
	private MemberInterestService msv;
	@Autowired
	private MemberService membersv;
	
	
	private static final Logger logger = LoggerFactory.getLogger(YoutubeController.class);

		
	@RequestMapping(value = "/main", method = {RequestMethod.POST,RequestMethod.GET })
	public ModelAndView VedioList( 
			HttpServletRequest request,
			@RequestParam(value="searchVideo", defaultValue = "" ) String searchVideo, 
	        @RequestParam(value="searchMusic", defaultValue = "" ) String searchMusic) {
	
	                                                         
		System.out.println("Controller ......");

		//--------------------- YoutubeAPI : com.biz.common.YoutubuSearch.java -------------------------------- 
		//session mseq 받아오기
		int mseq=0;
		HttpSession session = request.getSession();
		mseq = (Integer) session.getAttribute("SESS_SEQ");
		
		MemberInterestVO memberInterestVO= new MemberInterestVO();
		memberInterestVO.setMseq(mseq);
		System.out.println("                " );
		System.out.println("유튜브 컨트롤 검색된 MSEQ : " + memberInterestVO.getMseq());
		System.out.println("                " );
		

		//session mseq 가 없는 경우 이걸로 검색 해라 
		if(session.getAttribute("SESS_SEQ") != null) {
			String mseqStr = session.getAttribute("SESS_SEQ").toString();
			mseq = 23; 
			memberInterestVO.setMseq(mseq);
		}

// 비디오   =====================================================================================================================		
		
        // 	멤버별 비디오 리스트 가져오기 
		ArrayList<MemberInterestVO> memberInterestVideoList =msv.serviceGetVideoCheckList(memberInterestVO);
		ArrayList VideoList= new ArrayList();
		String interestVideo=null;
		for (MemberInterestVO mivo : memberInterestVideoList) {
			for (InterestVO ivo : mivo.getInterest()) {	
				VideoList.add(ivo.getInterest());
				interestVideo=ivo.getInterest();
			}	
		}
		 String RandoVideo=null;
		 String VideoListR =null;
		 System.out.println("interestVideo :"+interestVideo);
		 if(interestVideo==null) {
				InterestRandom IRandom=new InterestRandom(); 
				RandoVideo=IRandom.RandomVideo();
				System.out.println("체크리스트 없음 랜덤 뮤직 :"+RandoVideo+"담음");
			 }else {
				 VideoListR = VideoList.get(0).toString();
			
			 System.out.println("회원 동영상 관심사 원본 "+VideoList);
			 Collections.shuffle(VideoList);
			 System.out.println("회원 동영상 관심사 랜덤"+VideoList);
			 System.out.println("동영상 검색어 : "+VideoListR);
			 
			 }
		
			//  멤버별 비디오 리스트 비디오  검색 해주기	
			YoutubeSearch svc = new YoutubeSearch();
			ArrayList<YoutubeVO> video =  new ArrayList<YoutubeVO>(); 
		
			if(!searchMusic.equals(VideoListR+"동영상")) {
				video = svc.search(VideoListR+"동영상");
			}if(VideoListR==null){
				video = svc.search(RandoVideo+"동영상");
			}
	
		
// 뮤직   =====================================================================================================================		
      
		// 	멤버별 뮤직 리스트 가져오기 
		ArrayList<MemberInterestVO> memberInteresMusicList =msv.serviceGetMusicCheckList(memberInterestVO);
		ArrayList MusicList= new ArrayList();
		String Interest=null;
		for (MemberInterestVO mivo : memberInteresMusicList) {
			for (InterestVO ivo : mivo.getInterest()) {	
				MusicList.add(ivo.getInterest());
				Interest=ivo.getInterest();
		  }	
		}
		
		
		 String RandoMmusic=null;
		 String MusicListR =null;
		 System.out.println("Interest :"+Interest);
		 
		 //체크리스트가 있으면~~ 없으면~~~
		 if(Interest==null) {
			InterestRandom IRandom=new InterestRandom(); 
			RandoMmusic=IRandom.RandomMusic();
			System.out.println("체크리스트 없음 랜덤 뮤직 :"+RandoMmusic+"담음");
		 }else {
		  MusicListR = MusicList.get(0).toString();
		
		 System.out.println("회원 음악 관심사 원본 "+MusicList);
		 Collections.shuffle(MusicList);
		 System.out.println("회원 음악 관심사 랜덤"+MusicList);
		 System.out.println(" 음악 검색어 : "+MusicListR);
		 
		 }

		
	//  멤버별 뮤직 리스트  검색 해주기		
		ArrayList<YoutubeVO> music =  new ArrayList<YoutubeVO>(); 

		if(!searchMusic.equals(MusicListR+"음악")) {
			music = svc.search(MusicListR+"음악");
		}if(MusicListR==null){
			music = svc.search(RandoMmusic+"음악");
		}
		
		
		//-------------------------------------------------------담기!------------------------------------------------------------------			
		ModelAndView mav = new ModelAndView();
		//mav.addObject("INT_LIST", memberInterestList);
		mav.addObject("VVL_LIST", video);
		mav.addObject("MVL_LIST", music);
		mav.setViewName("main/mainpage");
		return mav;
	}
	

}
