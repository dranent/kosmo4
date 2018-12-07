package com.biz.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.mapper.MemberInterestMapper;
import com.biz.service.MemberInterestService;
import com.biz.vo.InterestVO;
import com.biz.vo.MemberInterestVO;

@Service
public class MemberInterestServiceImpl implements MemberInterestService {

	@Autowired
	private MemberInterestMapper memberInterestMapper;

	@Override
	public int serviceSetMemberInterest(MemberInterestVO memberInterestVO) {
		// TODO Auto-generated method stub
		return memberInterestMapper.insertCheckList(memberInterestVO);
	}

	
	
	@Override
	public ArrayList<MemberInterestVO> serviceGetVideoCheckList(MemberInterestVO memberInterestVO) {
		// TODO Auto-generated method stub
		return memberInterestMapper.selectVideoCheckList(memberInterestVO);
	}

	@Override
	public ArrayList<MemberInterestVO> serviceGetMusicCheckList(MemberInterestVO memberInterestVO) {
		// TODO Auto-generated method stub
		return memberInterestMapper.selectMusicCheckList(memberInterestVO);
	}

//	@Override
//	public ArrayList<InterestVO> serviceGETCheckList(int mseq) {
//		// TODO Auto-generated method stub
//		return memberInterestMapper.SelectCheckList2(mseq);
//	}

	




	
	
}
