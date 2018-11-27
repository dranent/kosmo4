package com.biz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mortbay.jetty.servlet.AbstractSessionManager.Session;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.ModelAndView;

import com.biz.service.impl.CategoryServiceImpl;
import com.biz.vo.CategoryVO;
import com.biz.vo.InterestVO;
import com.biz.vo.MemberInterestVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class LoginController {

	@Autowired
	private GoogleConnectionFactory googleConnectionFactory;
	@Autowired
	private OAuth2Parameters googleOAuth2Parameters;
	
	private OAuth2Operations oauthOperations;
	
	@RequestMapping("/oauth2callback")
	public String doSessionAssignActionPage(HttpServletRequest request, HttpServletResponse response){
		oauthOperations = googleConnectionFactory.getOAuthOperations();
//		String url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
		//System.out.println("/member/googleSignIn, url : " + url);
		
		
//		PrintWriter out;
//		try {
//			out = response.getWriter();
//			out.write(url);
//			out.flush();
//			out.close();
//		} catch (IOException e) {
//			throw new RuntimeException(e.getMessage(), e);
//		}
		
		System.out.println("/googleSignInCallback");
		String code = request.getParameter("code");
		System.out.println("code:::"+code);
		AccessGrant accessGrant = oauthOperations.exchangeForAccess(code , googleOAuth2Parameters.getRedirectUri(),null);
		String accessToken = accessGrant.getAccessToken();
//		Long expireTime = accessGrant.getExpireTime();
//		if (expireTime != null && expireTime < System.currentTimeMillis()) {
//			accessToken = accessGrant.getRefreshToken();
//			System.out.printf("accessToken is expired. refresh token = {}", accessToken);
//		}
		Connection<Google> connection = googleConnectionFactory.createConnection(accessGrant);
		Google google = connection == null ? new GoogleTemplate(accessToken) : connection.getApi();
		
		
		PlusOperations plusOperations = google.plusOperations();
		Person person = plusOperations.getGoogleProfile();

		HttpSession session = request.getSession();
		
		String id=person.getId();
//		---------------------------------------------------------------------
//		Set<String> set=person.getEmailAddresses();
//		System.out.println("set"+set.toString());
//		System.out.println(person.getEmails());
//		System.out.println("toString::::"+person.getEmailAddresses());
//		
//		
//		String email=person.getEmailAddresses().toString();
		String profileImage=person.getImageUrl();
//		------------------------------------------------------------------
		System.out.println(person.getDisplayName());
		System.out.println(id);
		System.out.println(person.getEmailAddresses());
		System.out.println(person.getEmails());
		
		 session.setAttribute("id", id);
//		 session.setAttribute("email", email);
		 session.setAttribute("img", profileImage);
		 session.setAttribute("joinroute", "google");
		
		return "user/select_interest";
		/*System.out.println(person.getAccountEmail());
		System.out.println(person.getAboutMe());
		System.out.println(person.getDisplayName());
		System.out.println(person.getEtag());
		System.out.println(person.getFamilyName());
		System.out.println(person.getGender());
		*/
		
	}
	
	@RequestMapping(value = "/sign_in")
    public String googleJoin(HttpServletResponse response, Model model) {
 
        oauthOperations = googleConnectionFactory.getOAuthOperations();
        String url = oauthOperations.buildAuthenticateUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
        System.out.println("/googleLogin, url : " + url);
        model.addAttribute("google_url", url);
 
        return "user/sign_in";
    }
	
	@RequestMapping(value = "/naver_login")
	public String navesr() {  
		
		return "naverLogin";
	}
	
	@RequestMapping(value = "/naver_callback")
	public String naverCallBack() {  
		
		return "user/naverCallBack";
	}
	
	@RequestMapping(value = "/naveruser")
	public String naverUser(HttpServletRequest request,
			@RequestParam("id") String id, @RequestParam("email") String email, @RequestParam("profileImage") String profileImage ) {  
		
		 System.out.println("id:::"+id);
		 System.out.println("email:::"+email);
		 System.out.println("profileImage:::"+profileImage);
		 
		 
		 HttpSession session =  request.getSession();
		 session.setAttribute("id", id);
		 session.setAttribute("email", email);
		 session.setAttribute("img", profileImage);
		 session.setAttribute("joinroute", "naver");
		
		return "redirect:/selectinterest";
	}
	
	
	@RequestMapping(value = "/selectinterest")
	public ModelAndView selectinterest(HttpServletResponse response) {  
		CategoryServiceImpl categoryServiceImpl= new CategoryServiceImpl();
		System.out.println("selectinterest");
		ArrayList<CategoryVO> categoryVO = categoryServiceImpl.serviceGetCategory();
		System.out.println("selectinterest complete");
//		ArrayList<InterestVO> list = categoryVO.getInterests();
//		PrintWriter out;
//		try {
//			out = response.getWriter();
//			out.print(list);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		String listToJson="";
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			listToJson=mapper.writeValueAsString(categoryVO);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", categoryVO);
		modelAndView.setViewName("user/select_interest");
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
