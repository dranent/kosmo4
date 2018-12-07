package com.biz.vo;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

//@Component
public class MemberInterestVO {

	private int mseq;
	private int iseq;


    private ArrayList<InterestVO> interest;
    private ArrayList<CategoryVO> category;

	public ArrayList<InterestVO> getInterest() {
		return interest;
	}
	public void setInterest(ArrayList<InterestVO> interest) {
		this.interest = interest;
	}
	public ArrayList<CategoryVO> getCategory() {
		return category;
	}
	public void setCategory(ArrayList<CategoryVO> category) {
		this.category = category;
	}
	public int getMseq() {
		return mseq;
	}
	public void setMseq(int mseq) {
		this.mseq = mseq;
	}
	public int getIseq() {
		return iseq;
	}
	public void setIseq(int iseq) {
		this.iseq = iseq;
	}

	
	
	
}
