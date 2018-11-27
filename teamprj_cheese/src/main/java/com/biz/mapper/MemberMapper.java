package com.biz.mapper;

import org.springframework.stereotype.Repository;

import com.biz.vo.MemberVO;

@Repository
public interface MemberMapper {

	public MemberVO getMember(String mid);
	public int setMember(MemberVO memberVO);
	
}
