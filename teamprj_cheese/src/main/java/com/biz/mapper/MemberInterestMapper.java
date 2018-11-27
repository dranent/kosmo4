package com.biz.mapper;

import org.springframework.stereotype.Repository;

import com.biz.vo.MemberInterestVO;

@Repository
public interface MemberInterestMapper {

	public MemberInterestVO getMemberInterest(String mid);
	public int setMemberInterest(MemberInterestVO memberInterestVO);
	
}
