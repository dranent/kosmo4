package com.biz.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.web.servlet.ModelAndView;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.biz.service.CartService;
import com.biz.vo.CartVO;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView list( ) {
		System.out.println("Controller ......");
		String regid = "kim";	//TODO:session
		ArrayList<CartVO> list = cartService.svcCartList(regid);
		ModelAndView mav = new ModelAndView();
		mav.addObject("LVL_LIST", list);
		mav.setViewName("cart/list");
		return mav;
	}
	
	@RequestMapping(value = "/cartview/{cseq}", method = RequestMethod.GET)
	public ModelAndView view(
			@PathVariable int cseq
	) {		
		System.out.println("Controller ......");
		String regid = "kim"; 	//TODO:session
		CartVO cvo = cartService.svcCartView(cseq, regid);
		ModelAndView mav = new ModelAndView();
		mav.addObject("KEY_VO", cvo);
		
		
		mav.setViewName("cart/view");
		return mav;
	}
	
	


}
