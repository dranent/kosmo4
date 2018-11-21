package com.biz.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.mapper.CartMapper;
import com.biz.service.CartService;
import com.biz.vo.CartVO;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartMapper cartDAO;
	
	@Override
	public ArrayList<CartVO> svcCartList(String regid) {
		if(cartDAO == null) 
			System.out.println("cartDAO null ");
		else
			System.out.println("cartDAO ");
		ArrayList<CartVO> list =  cartDAO.selectAll(regid);
		System.out.println(list.size() + "mapper 건");
		return list;
	}

	@Override
	public CartVO svcCartView(int cseq, String regid) {
		return cartDAO.select(cseq, regid);
	}

}
