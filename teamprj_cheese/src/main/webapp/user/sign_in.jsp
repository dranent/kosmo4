<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>
$(document).ready(function(){
	/* &&("#button").click(function(){
		
	}); */
	
});
</script>
<body>
<div align="center" style="padding-top:50px">
<div>구글로 로그인하기</div>
<a href="${google_url}"><img src="/img/googleLogin.jpg" style="block-size: 55px;"></a> 
 <!-- 네이버아이디로로그인 버튼 노출 영역 -->
  <div style="padding-top:25px">네이버로 로그인하기</div>
  <div id="naver_id_login"></div>
  <!-- //네이버아이디로로그인 버튼 노출 영역 -->
  <script type="text/javascript">
  	var naver_id_login = new naver_id_login("LxiRH2TKoi75JMT5N7iz", "http://localhost/naver_callback");
  	var state = naver_id_login.getUniqState();
  	naver_id_login.setButton("white", 4,65);
  	naver_id_login.setDomain("http://localhost/naver_login");
  	naver_id_login.setState(state);
  	naver_id_login.setPopup();
  	naver_id_login.init_naver_id_login();
  </script>
</div>                     
</body>
</html>