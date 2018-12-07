package com.biz.service;

import java.util.ArrayList;

import com.biz.vo.InterestVO;
import com.biz.vo.MemberInterestVO;

public interface MemberInterestService {

	
	public int serviceSetMemberInterest(MemberInterestVO memberInterestVO);
	
	
	public ArrayList<MemberInterestVO> serviceGetVideoCheckList(MemberInterestVO memberInterestVO);
	public ArrayList<MemberInterestVO> serviceGetMusicCheckList(MemberInterestVO memberInterestVO);

}
