package com.biz.service;

import com.biz.vo.MemberVO;

public interface MemberService {

	public MemberVO serviceGetMember(String mid);
	public int serviceSetMember(MemberVO memberVO);
	public int serviceAddMember(MemberVO vo);
}
