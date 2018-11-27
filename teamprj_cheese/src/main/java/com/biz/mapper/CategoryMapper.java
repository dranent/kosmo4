package com.biz.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.biz.vo.CategoryVO;

@Repository(value="categoryMapper")
public interface CategoryMapper {

	public ArrayList<CategoryVO> getCategory();
	
}
