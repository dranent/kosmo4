package com.biz.common;

import java.io.IOException;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.biz.vo.CrawVO;
import com.sun.org.apache.xpath.internal.operations.Div;

public class WebCraw {


	private final static String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36";

	// SSL 우회 등록
	public static void setSSL() throws NoSuchAlgorithmException, KeyManagementException {
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager(){
			@Override
			public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public X509Certificate[] getAcceptedIssuers() {
				// TODO Auto-generated method stub
				return null;
			}
		} };
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new SecureRandom());
		HttpsURLConnection.setDefaultHostnameVerifier(
				new HostnameVerifier() {
					@Override
					public boolean verify(String hostname, SSLSession session) {
						return true;
					}
				}
				);
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	}

	//--------------------------------------------------------
	// 알라딘  : 베스트북 크롤링 
	//--------------------------------------------------------
	public ArrayList<CrawVO> getAladinBookList() {
	//public static void main(String[] a) {
		ArrayList<CrawVO> list = new ArrayList<CrawVO>();
		try {
			String connUrl = "https://www.aladin.co.kr/shop/common/wbest.aspx?BranchType=1&start=we";
			// 2. SSL 체크
            if(connUrl.indexOf("https://") >= 0){
            	this.setSSL();
            }
			Document doc = Jsoup.connect(connUrl).get();
			//System.out.println(doc.toString());
			
			Elements elems = doc.select("form#Myform div.ss_book_box");
			//System.out.println(elems.toString());
			for(Element elem : elems) {
				//System.out.println(elem);
				CrawVO vo = new CrawVO();
				
				String title = elem.select("table tbody tr td:nth-child(3) table tbody tr:nth-child(1) td:nth-child(1) div:nth-child(1) ul li:nth-child(2) a.bo3 b").text();
				String href = elem.select("table tbody tr td:nth-child(3) table tbody tr:nth-child(1) td:nth-child(1) div:nth-child(1) ul li:nth-child(2) a.bo3").attr("href");
				String imgsrc = elem.select("table tbody tr td:nth-child(2) table tbody tr:nth-child(1) td div:nth-child(2) a img").attr("src");
				String price = elem.select("table tbody tr td:nth-child(3) table tbody tr:nth-child(1) td:nth-child(1) div:nth-child(1) ul li:nth-child(4) span.ss_p2 b span").text();
				
				vo.setHref(href);
				vo.setTitle(title);
				vo.setPrice(price);
				vo.setImgsrc(imgsrc);
				list.add(vo);
			}
			
//			System.out.println(list.size()+"건 크롤링");
//			for(CrawVO vo : list) {
//				System.out.println(vo.getTitle());
//				System.out.println(vo.getImgsrc());
//				System.out.println(vo.getCont());
//				System.out.println(vo.getHref());
//				System.out.println("=====================");
//			}
//				
				
		} catch (IOException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	//--------------------------------------------------------
	// YTN  : YTN뉴스 크롤링
	//--------------------------------------------------------
	public ArrayList<CrawVO> getYtnNews() {
		ArrayList<CrawVO> list = new ArrayList<CrawVO>();
		try {
			String connUrl = "https://www.ytn.co.kr/photo/photo_list_1406.html";
			// 2. SSL 체크
            if(connUrl.indexOf("https://") >= 0){
            	this.setSSL();
            }
			Document doc = Jsoup.connect(connUrl).get();
			//System.out.println(doc.toString());
			Elements elems = doc.select("div#ytn_list_v2014 dl.photo_list");
			
			for(Element elem : elems) {
				//System.out.println(elem);
				CrawVO vo = new CrawVO();
				
				String href = "https://www.ytn.co.kr"+elem.select("dt a").attr("href");
				String title = elem.select("dt a").text();
				String cont = elem.select("dd.text a").text();
				String imgsrc = elem.select("dd.vertical p a img").attr("src");
				
				vo.setHref(href);
				vo.setTitle(title);
				vo.setCont(cont);
				vo.setImgsrc(imgsrc);
				list.add(vo);
			}
			
//			System.out.println(list.size()+"건 크롤링");
//			for(CrawVO vo : list) {
//				System.out.println(vo.getTitle());
//				System.out.println(vo.getImgsrc());
//				System.out.println(vo.getCont());
//				System.out.println(vo.getHref());
//				System.out.println("=====================");
//			}
//				
				
		} catch (IOException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	//--------------------------------------------------------
	// 기상청  : 일기예보 크롤링 
	//--------------------------------------------------------
	public HashMap<String, String> getWeather(String connUrl) {
		//public static void main(String[] a) {
			//String connUrl = "http://www.weather.go.kr/weather/forecast/digital_forecast.jsp?x=67&y=123";
			HashMap<String, String> map = new HashMap<String, String>();
			try {
				// 2. SSL 체크
	            if(connUrl.indexOf("https://") >= 0){
	            	this.setSSL();
	            }
	            //div#dfs-panel > div.local_forecast_inn > div.now_weather1 > dl > dd.now_weather1_center.temp1.MB10
	            //div#dfs-panel > div.local_forecast_inn > div.time_weather1 > dl:nth-child(1) > dd.time_weather1_left.icon > img
				Document doc = Jsoup.connect(connUrl).get();
				String temp = doc.select("div#dfs-panel div.local_forecast_inn div.now_weather1 dl dd.now_weather1_center.temp1.MB10").text();
				//System.out.println(temp);
				
				String weather = doc.select("div#dfs-panel div.local_forecast_inn div.time_weather1 dl:nth-child(1) dd.time_weather1_left.icon img").attr("alt");
				//System.out.println(weather);
				
				map.put("key_temp", temp);
				map.put("key_weather", weather);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (KeyManagementException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			return map;
		}

	

}
