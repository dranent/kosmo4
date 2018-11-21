package com.biz.vo;

import java.util.ArrayList;

public class GoodsVO {
	private String gcode;
	private String cateCode; 
	private String gname;
	private int gprice;
	private String regid;
	private String regdate;
	
	
	//상품당 카테고리 1개
	private CateInfoVO cateInfoVO;
	public CateInfoVO getCateInfoVO() {
		return cateInfoVO;
	}
	public void setCateInfoVO(CateInfoVO cateInfoVO) {
		this.cateInfoVO = cateInfoVO;
	} 
	
	//상품당 이미지 n개
	private ArrayList<GoodsImgVO> imgList;
	public ArrayList<GoodsImgVO> getImgList() {
		return imgList;
	}
	public void setImgList(ArrayList<GoodsImgVO> imgList) {
		this.imgList = imgList;
	}
		
		
	public String getGcode() {
		return gcode;
	}
	public void setGcode(String gcode) {
		this.gcode = gcode;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getGprice() {
		return gprice;
	}
	public void setGprice(int gprice) {
		this.gprice = gprice;
	}
	public String getRegid() {
		return regid;
	}
	public void setRegid(String regid) {
		this.regid = regid;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}
