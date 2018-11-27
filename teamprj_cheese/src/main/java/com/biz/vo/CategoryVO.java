package com.biz.vo;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

//@Component
public class CategoryVO {

	private int cateseq;
	private int interestgroup;
	private String category;
	
	private ArrayList<InterestVO> interests;
	
	public ArrayList<InterestVO> getInterests() {
		return interests;
	}
	public void setInterests(ArrayList<InterestVO> interests) {
		this.interests = interests;
	}
	
	public int getCateseq() {
		return cateseq;
	}
	public void setCateseq(int cateseq) {
		this.cateseq = cateseq;
	}
	public int getInterestgroup() {
		return interestgroup;
	}
	public void setInterestgroup(int interestgroup) {
		this.interestgroup = interestgroup;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	

}
