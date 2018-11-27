package com.biz.vo;

import org.springframework.stereotype.Component;

@Component
public class MemberVO {

	private int mseq;
	private String mid;
	private String email;
	private String regdate;
	private String joinroute;
	private String profileimg;
	
	
	public String getProfileimg() {
		return profileimg;
	}
	public void setProfileimg(String profileimg) {
		this.profileimg = profileimg;
	}
	public int getMseq() {
		return mseq;
	}
	public void setMseq(int mseq) {
		this.mseq = mseq;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getJoinroute() {
		return joinroute;
	}
	public void setJoinroute(String joinroute) {
		this.joinroute = joinroute;
	}
	
}
