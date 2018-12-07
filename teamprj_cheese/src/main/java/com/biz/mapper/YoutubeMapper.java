package com.biz.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.biz.vo.BoardVO;
import com.biz.vo.InterestVO;



@Repository(value="YoutubeDAO")
public interface YoutubeMapper {
	
	
	
	/*public ArrayList<BoardVO> selectAll();
	public BoardVO view(int bseq);*/
	
	public ArrayList<InterestVO> video();
	public ArrayList<InterestVO> music();

}
