package com.biz.vo;

import org.springframework.stereotype.Component;

@Component
public class Except {

	private int eseq;
	private int mseq;
	private String except;
	private int interestgroup;
	
	public int getEseq() {
		return eseq;
	}
	public void setEseq(int eseq) {
		this.eseq = eseq;
	}
	public int getMseq() {
		return mseq;
	}
	public void setMseq(int mseq) {
		this.mseq = mseq;
	}
	public String getExcept() {
		return except;
	}
	public void setExcept(String except) {
		this.except = except;
	}
	public int getInterestgroup() {
		return interestgroup;
	}
	public void setInterestgroup(int interestgroup) {
		this.interestgroup = interestgroup;
	}
	
}
