package com.biz.service;

import com.biz.vo.MemberInterestVO;

public interface MemberInterestService {

	public MemberInterestVO serviceGetMemberInterest(String mid);
	public int serviceSetMemberInterest(MemberInterestVO memberInterestVO);
	
}
