package com.biz.service.impl;

import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.mapper.YoutubeMapper;
import com.biz.mapper.UserMapper;
import com.biz.service.YoutubeService;
import com.biz.vo.BoardVO;
import com.biz.vo.InterestVO;



@Service
public class YoutubeServiceImpl implements YoutubeService {
	@Autowired
	private  YoutubeMapper  YoutubeDAO;

	
	
	@Override
	public ArrayList<InterestVO> video() {
		// TODO Auto-generated method stub
		return  YoutubeDAO.video();
	}
	
	@Override
	public ArrayList<InterestVO> music() {
		// TODO Auto-generated method stub
		return  YoutubeDAO.music();
	}
	
//	public ArrayList<BoardVO> svcList() {
//		System.out.println("servce .....");
//		return  InterestDAO.selectAll();
////		ArrayList<BoardVO> list = dao.select();
////		return list;
//	}





	
	



}
