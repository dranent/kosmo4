<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f1f1f1;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}
.dropdown:hover .dropbtn {background-color: #3e8e41;}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.js?ver=3414324242"></script>
<script src="/js/weather_top.js?ver=4412412414141421414"></script>
<body>
<header style="width: 100%; height: 30px;">
<div style="display: flex;">
<div style="padding-left: 5em;">
<a href="main.jsp" style="text-decoration:none;"  >
<img src="/img/logo2.jpg" style="block-size: 45px;">
</div>
<div align="right" style="padding-left: 80em;">

<div class="g-signin2" data-onsuccess="onSignIn"></div>
		<div class="dropdown" style="margin-right: 1560px;">
	  		<img class="dropbtn" id="memberIMG" src="https://ssl.pstatic.net/static/pwe/address/img_profile.png" 
				style="
				border: 2px solid red;
				-khtml-border-radius: 70px;
				-webkit-border-radius: 70px;
				block-size: 20px;
				">
			  <div class="dropdown-content">
			    <a href="#">logout</a>
			    <a text-decoration:none; onclick="window.open('user/terms/terms.jsp', '로그인','width=735,height=350,location=no,status=no,scrollbars=yes');">이용약관</a>
			    <a href="${google_url}"><img src="/img/googleLogin.jpg" style="block-size: 55px;"></a>
			  
			  

			  
	
	</div>
</div>

<a style="text-decoration:none;" onclick="window.open('/sign_in', '로그인','width=490,height=580,location=no,status=no,scrollbars=yes');"  >
	<label>
		<img src="/img/button1.jpg"	style=" 
				border: 0px solid red;
				-khtml-border-radius: 70px;
				-webkit-border-radius: 20px;
				block-size: 20px;
				">Sign in
	</label>
</a>


</div>
</header>

<!-- <hr id="w_many_cloud" style=" height: 7px; background-color: #bcd3eb; border-color: #bcd3eb;">
<hr id="w_alittle_cloud" style=" height: 5px; background-color: darkgrey; border-color: darkgray;">
<hr id="w_clean" style=" height: 5px; background-color: darkgrey; border-color: darkgray;">
<hr id="w_rain" style=" height: 5px; background-color: darkgrey; border-color: darkgray;">
<hr id="w_snow" style=" height: 5px; background-color: darkgrey; border-color: darkgray;">
<hr id="w_snow_or_rain" style=" height: 5px; background-color: darkgrey; border-color: darkgray;">
<hr id="w_many_snow_or_rain" style=" height: 5px; background-color: darkgrey; border-color: darkgray;"> -->



</body>
</html>