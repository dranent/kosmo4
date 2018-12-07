package com.biz.vo;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

//@Component
public class CategoryVO {

	private int cateseq;
	private String category;
	
	public int getCateseq() {
		return cateseq;
	}
	public void setCateseq(int cateseq) {
		this.cateseq = cateseq;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	

}
