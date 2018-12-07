package com.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.mapper.MemberMapper;
import com.biz.service.MemberService;
import com.biz.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;

	
	@Override
	public MemberVO serviceGetMember(String mid) {
		MemberVO memberVO= new MemberVO();

		if(memberMapper==null) {
			System.out.println("Notfoud Member");
		}else {
			System.out.println("Login of Member");
			memberVO=memberMapper.getMember(mid);
		}
		return memberVO;
	}

	@Override
	public int serviceSetMember(MemberVO memberVO) {
		if(memberVO==null) {
			System.out.println("잘못된 접근...[회원정보 없음]");
		}else {
			System.out.println("회원정보 확인,가입경로::"+memberVO.getJoinroute());
		}
		
		return memberMapper.setMember(memberVO);
	}

	@Override
	public  int serviceAddMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return memberMapper.addMemberInfo(vo);
	}
	
	
}
