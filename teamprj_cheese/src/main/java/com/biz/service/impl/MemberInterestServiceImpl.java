package com.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.mapper.MemberInterestMapper;
import com.biz.service.MemberInterestService;
import com.biz.vo.MemberInterestVO;

@Service
public class MemberInterestServiceImpl implements MemberInterestService {

	@Autowired
	private MemberInterestMapper memberInterestMapper;

	@Override
	public MemberInterestVO serviceGetMemberInterest(String mid) {
		return memberInterestMapper.getMemberInterest(mid);
	}

	@Override
	public int serviceSetMemberInterest(MemberInterestVO memberInterestVO) {
		return memberInterestMapper.setMemberInterest(memberInterestVO);
	}
	
	
}
