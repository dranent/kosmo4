package com.biz.controller;

import java.io.IOException;



import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mortbay.jetty.servlet.AbstractSessionManager.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.social.connect.Connection;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.google.api.plus.Person;
import org.springframework.social.google.api.plus.PlusOperations;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.biz.service.MemberInterestService;
import com.biz.service.MemberService;

import com.biz.vo.CategoryVO;
import com.biz.vo.InterestVO;
import com.biz.vo.MemberInterestVO;
import com.biz.vo.MemberVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.util.DateTime;

@Controller
public class LoginController {

	@Autowired
	private GoogleConnectionFactory googleConnectionFactory;
	@Autowired
	private OAuth2Parameters googleOAuth2Parameters;

	
	@Autowired
	MemberService MemberServiceImpl;
	@Autowired
	MemberInterestService MemberInterestServiceImpl;

	private OAuth2Operations oauthOperations;

	/**
	 * 스텝1 ::: 구글 인증창을 오픈하기 위한 URL 생성해서 로그인 화면으로 가기 
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/sign_in")
	public String googleJoin(HttpServletResponse response, Model model) {

		oauthOperations = googleConnectionFactory.getOAuthOperations();
		//  oauthOperations.
		String url = oauthOperations.buildAuthenticateUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
		System.out.println("/googleLogin, url : " + url);
		model.addAttribute("google_url", url);

		return "user/sign_in";
	}

	/**
	 * 스텝2 ::: 스텝1을 거쳐 구글 로그인 시 구글 서버가 호출할 콜백 URL(/oauth2callback)
	 *      ::: 구글은 해당 URL에 code를 보내준다.
	 *      ::: code를 사용해 -> access_token -> plus.person 정보를 꺼낸다.
	 *      ::: <회원가입1단계> person 정보를 member 테이블에 insert한 후 select_interest.jsp 화면으로 이동한다.
	 *      ::: <회원가입2단계> select_interest.jsp 에서 birthday(yyyy-mm-dd), pw, +관심분야 입력받아 회원가입을 완료한다.
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/oauth2callback")
	public String doSessionAssignActionPage(HttpServletRequest request, HttpServletResponse response){
		oauthOperations = googleConnectionFactory.getOAuthOperations();
		
		String code = request.getParameter("code");
		AccessGrant accessGrant = oauthOperations.exchangeForAccess(code , googleOAuth2Parameters.getRedirectUri(),null);
		String accessToken = accessGrant.getAccessToken();
		
		System.out.println("code:::"+code);
		System.out.println("accessToken:::"+accessToken);
		
		//		Long expireTime = accessGrant.getExpireTime();
		//		if (expireTime != null && expireTime < System.currentTimeMillis()) {
		//			accessToken = accessGrant.getRefreshToken();
		//			System.out.printf("accessToken is expired. refresh token = {}", accessToken);
		//		}
		Connection<Google> connection = googleConnectionFactory.createConnection(accessGrant);
		Google google = connection == null ? new GoogleTemplate(accessToken) : connection.getApi();

		PlusOperations plusOperations = google.plusOperations();
		Person person = plusOperations.getGoogleProfile();
		Person person2 = plusOperations.getPerson("me");
		//System.out.println(person2.getAccountEmail());	//return String
		//System.out.println(person.getEmailAddresses());	//return array

		System.out.println("==========================================================================================================");
		System.out.println(person.getDisplayName());	//이름
		System.out.println(person2.getAccountEmail());	//이메일
		System.out.println(person.getImageUrl());		//이미지 저장
		System.out.println(person.getGender());			//성별
		//System.out.println(person.getBirthday());		//생년월일(나이)
		//생년월일, 비밀번호는 추가 화면에서 받아 update....................................

		HttpSession session = request.getSession();
		session.setAttribute("email", person2.getAccountEmail());
		session.setAttribute("img", person.getImageUrl());
		session.setAttribute("joinroute", "google");
		
		if(session==null) {
			return "redirect:/sign_in";
		}
		
		

		
		//<회원가입1단계> person 정보를 member 테이블에 insert한 후 select_interest.jsp 화면으로 이동
		MemberVO mvo= new MemberVO();
		
		mvo.setEmail(person2.getAccountEmail());
		mvo.setJoinroute("google");
		mvo.setProfileimg(person.getImageUrl());
		mvo.setName(person.getDisplayName());
		mvo.setGender(person.getGender());
		
		
		//birthday, pw 2단계 가입에서 받아서 update
		MemberServiceImpl.serviceSetMember(mvo);
		
		return "user/select_interest";
	}

	
	/**
	 * 스텝2 ::: 스텝1을 거쳐 구글 로그인 시 구글 서버가 호출할 콜백 URL(/oauth2callback)
	 *      ::: 구글은 해당 URL에 code를 보내준다.
	 *      ::: code를 사용해 -> access_token -> plus.person 정보를 꺼낸다.
	 *      ::: <회원가입1단계> person 정보를 member 테이블에 insert한 후 select_interest.jsp 화면으로 이동한다.
	 *      ::: <회원가입2단계> select_interest.jsp 에서 birthday(yyyy-mm-dd), pw, +관심분야 입력받아 회원가입을 완료한다.
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/addMemberInfo")
	public String addMemberInfo(HttpServletRequest request, 
			@RequestParam("birthday") String birthday,
			@RequestParam("pw") String pw,
			@RequestParam("checkarr") String checkarr){
		
//		<회원가입2단계> select_interest.jsp 에서 birthday(yyyy-mm-dd), pw, +관심분야 입력받아 회원가입을 완료
		HttpSession session = request.getSession();
		
		
		String email = session.getAttribute("email").toString();
	    MemberVO mvo= new MemberVO();
	   
		mvo.setEmail(email);
		mvo.setBirthday(birthday);
		mvo.setPw(pw);
	    MemberServiceImpl.serviceAddMember(mvo);   
	    session.setAttribute("SESS_SEQ" , mvo.getMseq() );//mseq 세션 값 담은데 여기다...
	    System.out.println("메일:"+email+"생년월일:"+birthday+"비밀번호:"+pw);
	    
	   
	   
	    
//		관심분야 등록  {1,2,3,4}	    
	    MemberInterestVO mivo = new MemberInterestVO(); 
		String[] iseqArr = checkarr.split(",");
		 //방금 업데이트한 mseq가 들어있음.
		mivo.setMseq(mvo.getMseq());
		for(int i=0; i<iseqArr.length; i++) {
			
			mivo.setIseq(Integer.parseInt(iseqArr[i]));
			System.out.println("MSEQ : "+mivo.getMseq());
			System.out.println("ISEQ : "+mivo.getIseq());
			MemberInterestServiceImpl.serviceSetMemberInterest(mivo);
			
		}
 
	   //				
//		관심분야 등록  {1,2,3,4}
//		String[] iseqArr = checkarr.split(",");
//		InterestVO ivo = new InterestVO();
//		ivo.setMseq(mvo.getMseq()); //방금 업데이트한 mseq가 들어있음.
//		for(int i=0; i<iseqArr.length; i++) {
//			ivo.setIseq(i);
//			MemberServiceImpl.insertIntestCheck(ivo);
//		}
		
		return "redirect:/main"; //????
	}
	
//구글 로그인 
	
	
//	@RequestMapping(value = "/naver_login")
//	public String navesr() {  
//
//		return "naverLogin";
//	}
//	@RequestMapping(value = "/naver_callback")
//	public String naverCallBack() {  
//
//		return "user/naverCallBack";
//	}
//	@RequestMapping(value = "/naveruser")
//	public String naverUser(HttpServletRequest request,
//			@RequestParam("id") String id,
//			@RequestParam("email") String email,
//			@RequestParam("profileImage") String profileImage ) {  
//		System.out.println("id:::"+id);
//		System.out.println("email:::"+email);
//		System.out.println("profileImage:::"+profileImage);
//
//
//		HttpSession session =  request.getSession();
//		session.setAttribute("id", id);
//		session.setAttribute("email", email);
//		session.setAttribute("img", profileImage);
//		session.setAttribute("joinroute", "naver");
//
//		return "redirect:/selectinterest";
//	}


	@RequestMapping(value = "/selectinterest")
	@ResponseBody
	//	public ArrayList<CategoryVO>  selectinterest(HttpServletResponse response) {  
	public ModelAndView  selectinterest(HttpServletResponse response) {  
		//CategoryServiceImpl categoryServiceImpl= new CategoryServiceImpl();
		System.out.println("selectinterest");
		//ArrayList<CategoryVO> categoryVOList = categoryServiceImpl.serviceGetCategory();
		System.out.println("selectinterest complete");
		//		return categoryVOList;
		//		ArrayList<InterestVO> list = categoryVO.getInterests();
		//		PrintWriter out;
		//		try {
		//			out = response.getWriter();
		//			out.print(list);
		//		} catch (IOException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}

		//		String listToJson="";
		//		ObjectMapper mapper = new ObjectMapper();
		//		try {
		//			listToJson=mapper.writeValueAsString(categoryVOList);
		//		} catch (JsonProcessingException e) {
		//			e.printStackTrace();
		//		}

		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.addObject("IVL_LIST", categoryVOList);
		modelAndView.setViewName("user/select_interest");
		System.out.println(modelAndView);
		return modelAndView;
	}

	@RequestMapping(value = "/selectcomplete")
	public String selectcomplete(@ModelAttribute MemberInterestVO target,HttpServletRequest request) {  

		HttpSession session =  request.getSession();
		Object obj=target;
		try {
			for (Field field : obj.getClass().getDeclaredFields()){
				field.setAccessible(true);
				Object value;
				value = field.get(obj);
				System.out.println(field.getName()+","+value);
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "user/select_interest";
	}


	@RequestMapping(value="/comdo")
	public void selectsdsd(@RequestParam("musics") String musics,
			@RequestParam("books") String books,
			@RequestParam("videos") String videos,
			@RequestParam("outdoors") String outdoors,
			@RequestParam("indoors") String indoors,
			@RequestParam("excepts") String Excepts) {
		System.out.println(musics);
		System.out.println(books);
		System.out.println(videos);
		System.out.println(outdoors);
		System.out.println(indoors);
		System.out.println(Excepts);


	}


}
