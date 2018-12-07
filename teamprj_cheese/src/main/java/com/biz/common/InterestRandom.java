package com.biz.common;

public class InterestRandom {

	
	public static String RandomVideo(){
		String[] RandomVideo= new String[] {"게임","운동","요리","DIY 만들기"};
		String RVideo=null;
		for (int i = 0; i < RandomVideo.length; i++) {
			RVideo= RandomVideo[(int) (Math.random()*4)];
			}
		return RVideo;
		}

	
	
	public static String RandomMusic(){
	String[] RandomMusic= new String[] {"발라드","댄스","랩/힙합","RnB/Soul","인디","록/메탈","트로트","Jazz"};
	String RMusic=null;
	for (int i = 0; i < RandomMusic.length; i++) {
		RMusic= RandomMusic[(int) (Math.random()*8)];
		
		}
	return RMusic;
	}
}
