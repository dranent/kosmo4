package com.biz.service;

import java.util.ArrayList;
import com.biz.vo.CartVO;

public interface CartService {
	public ArrayList<CartVO> svcCartList(String regid);
	public CartVO svcCartView(int cseq, String regid);
}
