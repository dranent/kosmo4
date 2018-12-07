<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/css?family=Fugaz+One" rel="stylesheet">

<title>Time Cheese!</title>

<style>
html{width: 100%; height: 100%;}


ul{width:100%;height:5%;background:#FBD501;list-style:none;
overflow-y:scroll;"
}



body {
	width: 100%; height: 100%;
    -webkit-animation: colorchange 60s infinite; 
    animation: colorchange 60s infinite;
}
 
 
@-webkit-keyframes colorchange {
 
     0%  {background: #7c8af4;}
    25%  {background: #78281F;}
    50%  {background: #117A65;}
    75%  {background: #DC7633;}
    100% {background: #9B59B6;}
}
 
 
@keyframes colorchange {
     0%  {background: #7c8af4;}
    25%  {background: #78281F;}
    50%  {background: #117A65;}
    75%  {background: #DC7633;}
    100% {background: #9B59B6;}
}   

a.title {font-family: 'Fugaz One', cursive;
			font-size: 200%;
	text-decoration:none;
}


</style>

</head>


<body>



<table style="border:0; cellpadding:0; cellspacing:1; width:100%;">
	<tr height=55px valign="middle" Style="background-color:red;">
		<td>
			<jsp:include page="top.jsp" ></jsp:include>
		</td>
	</tr>
</table>


<div style=" border: 3px solid green; width:100%; height: 100%; white-space:nowrap; ">


		<!-- menu bar -->
		<ul>
			<li><a href="#" class="title">Time Cheese</a></li>
		</ul>
		<br>
		<!-- -------- -->


		<!-- content 영역 -->
		
		<div
			style="float: left; border: 1px solid blue; width: 19%; height: 99%;">
			첫번째 영역</div>
		
		
		
		<div id=youtubvideo style="float: left; border: 1px solid gold; width: 19%; height: 99%;">
		   Video<br>
			<c:forEach items="${VVL_LIST}" var="vvo" >
				<div align="center" >
					<iframe width="90%" height="90%" src="https://www.youtube.com/embed/${vvo.videoId}" frameborder="0"  allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
				    <br>
				</div>
			</c:forEach>	
		</div>
	
		<div id=youtubemusic style="float: left; border: 1px solid gold; width: 19%; height: 99%;">
		   Music<br>
			<c:forEach items="${MVL_LIST}" var="mvo" >
				<div align="center" >
					<iframe width="90%" height="90%" src="https://www.youtube.com/embed/${mvo.videoId}" frameborder="0"  allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
				    <br>
				</div>
			</c:forEach>	
		</div>
		
		
			
		
		<div
			style="float: left; border: 2px solid gold; width: 19%; height: 99%;">
			네번째 영역</div>
		<div
			style="float: left; border: 2px solid red; width: 19%; height: 99%;">
			다섯번째 영역</div>
















	</div>


</body>
</html>