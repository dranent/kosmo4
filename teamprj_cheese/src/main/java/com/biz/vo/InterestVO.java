package com.biz.vo;

import org.springframework.stereotype.Component;

//@Component
public class InterestVO {

	private int iseq;
	private int interestgroup;
	private String interest;
	
	public int getIseq() {
		return iseq;
	}
	public void setIseq(int iseq) {
		this.iseq = iseq;
	}
	public int getInterestgroup() {
		return interestgroup;
	}
	public void setInterestgroup(int interestgroup) {
		this.interestgroup = interestgroup;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	
}
