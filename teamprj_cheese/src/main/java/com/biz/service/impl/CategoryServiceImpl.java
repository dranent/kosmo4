package com.biz.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.mapper.CategoryMapper;
import com.biz.service.CategoryService;
import com.biz.vo.CategoryVO;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryMapper categoryMapper;
	
	@Override
	public ArrayList<CategoryVO> serviceGetCategory() {
		ArrayList<CategoryVO> list = new ArrayList<CategoryVO>();
		list=categoryMapper.getCategory();
		if(list==null) {
			System.out.println("serviceGetCategiry is null");
		}
		return list;
	}

	
	
}
