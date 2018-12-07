package com.biz.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.biz.vo.InterestVO;
import com.biz.vo.MemberInterestVO;

@Repository
public interface MemberInterestMapper {

	
	public int insertCheckList(MemberInterestVO memberInterestVO);
	

	public ArrayList<MemberInterestVO> selectVideoCheckList(MemberInterestVO memberInterestVO);
	public ArrayList<MemberInterestVO> selectMusicCheckList(MemberInterestVO memberInterestVO);
	

	
	
}
