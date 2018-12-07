<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.3.1.js?ver=7"></script>
<script src="/js/select_interest.js?ver=451351351352"></script>

<body>
<%-- This is select area list=${list}
<c:forEach items="${list}" var="list">
<div>
	<h3>${list.category}</h3>
		<div>
			<h4><label><input type="checkbox" name="${list.category}" id="${list.category}" class="${list.category}">전체선택</label></h4>
				<div>
					<c:forEach items="${list.interests}" var="ilist">
					</c:forEach>
					<label><input type="checkbox" name="${list.category}" class="${list.category}_e_check">기타
					<input type="text" name="${list.category}" class="${list.category}_except" disabled="disabled"></label>
				</div>
		</div>
</div>
</c:forEach> --%>


<form action="/addMemberInfo" method="post" class="interestFORM">
 
 
 <div>
 	 <p style= > 정보입력</p><hr>
 	  생년월일:      <input type= "text" name="birthday" class="birthday" >
 	  			  <br> ex : 19950612 
 	              
 	               <!--  *개인 맞춤 서비스 제공 시 필요! --><br>
 </div>
 	
 <div>
 	   비밀번호:  <input type= "text" name="pw" class="pw" value="비밀번호를 설정하세요">   
 </div> 	               <!--   *회원정보 수정 시 필요! --><br>
 

 <p>관심사를 선택해주세요</p><hr>	
 <div>
 	<h3>노래</h3>
		<div>
			<h4><label><input type="checkbox" name="m_all" id="m_all" class="m_all">전체선택</label></h4>
				<div>
					<label><input type="checkbox" name="checkarr" class="musics" value="1">발라드</label>
					<label><input type="checkbox" name="checkarr" class="musics" value="2">댄스</label>
					<label><input type="checkbox" name="checkarr" class="musics" value="3">랩/힙합</label>
					<label><input type="checkbox" name="checkarr" class="musics" value="4">RnB/Soul</label>
					<label><input type="checkbox" name="checkarr" class="musics" value="5">인디</label>
					<label><input type="checkbox" name="checkarr" class="musics" value="6">록/메탈</label>
					<label><input type="checkbox" name="checkarr" class="musics" value="7">트로트</label>
					<label><input type="checkbox" name="checkarr" class="musics" value="8">Jazz</label>
					<label><input type="checkbox" name="checkarr" class="m_e_check" value="9">기타
					<input type="text" name="excepts" class="m_except" disabled="disabled"></label>
				</div>
		</div>
</div>

<div>
	<h3>책</h3>
		<div>
			<h4><label><input type="checkbox" name="b_all" id="b_all" class="b_all">전체선택</label></h4>
				<div>
					<label><input type="checkbox" name="checkarr" class="books" value="10">소설</label>
					<label><input type="checkbox" name="checkarr" class="books" value="11">시</label>
					<label><input type="checkbox" name="checkarr" class="books" value="12">에세이</label>
					<label><input type="checkbox" name="checkarr" class="books" value="13">고전</label>
					<label><input type="checkbox" name="checkarr" class="books" value="14">만화</label>
					<label><input type="checkbox" name="checkarr" class="books" value="15">자기계발</label>
					<label><input type="checkbox" name="checkarr" class="books" value="16">역사</label>
					<label><input type="checkbox" name="checkarr" class="books" value="17">과학</label>
					<label><input type="checkbox" name="checkarr" class="books" value="18">건강</label>
					<label><input type="checkbox" name="checkarr" class="books" value="19">취미</label>
					<label><input type="checkbox" name="checkarr" class="books" value="20">레저</label>
					<label><input type="checkbox" name="checkarr" class="books" value="21">여행</label>
					<label><input type="checkbox" name="checkarr" class="books" value="22">잡지</label>
					<label><input type="checkbox" name="checkarr" class="b_e_check" value="23">기타
					<input type="text" name="excepts" class="b_except" disabled="disabled"></label>
				</div>
		</div>
</div>

<div>
	<h3>영상</h3>
		<div>
			<h4><label><input type="checkbox" name="v_all" id="v_all" class="v_all">전체선택</label></h4>
				<div>
					<label><input type="checkbox" name="checkarr" class="videos" value="24">게임</label>
					<label><input type="checkbox" name="checkarr" class="videos" value="25">운동</label>
					<label><input type="checkbox" name="checkarr" class="videos" value="26">요리</label>
					<label><input type="checkbox" name="checkarr" class="videos" value="27">DIY</label>
					<label><input type="checkbox" name="checkarr" class="v_e_check" value="28">기타
					<input type="text" name="excepts" class="v_except" disabled="disabled"></label>
				</div>
		</div>
</div>

<div>
	<h3>실외활동</h3>
		<div>
			<h4><label><input type="checkbox" name="o_all" id="o_all" class="o_all">전체선택</label></h4>
				<div>
					<label><input type="checkbox" name="checkarr" class="outdoors" value="29">산책</label>
					<label><input type="checkbox" name="checkarr" class="outdoors" value="30">축제</label>
					<label><input type="checkbox" name="checkarr" class="outdoors" value="31">쇼핑</label>
					<label><input type="checkbox" name="checkarr" class="outdoors" value="32">자전거</label>
					<label><input type="checkbox" name="checkarr" class="outdoors" value="33">등산</label>
				</div>
		</div>
</div>

<div>
	<h3>실내활동</h3>
		<div>
			<h4><label><input type="checkbox" name="i_all" id="i_all" class="i_all">전체선택</label></h4>
				<div>
					<label><input type="checkbox" name="checkarr" class="indoors" value="34">전시회</label>
					<label><input type="checkbox" name="checkarr" class="indoors" value="35">영화</label>
					<label><input type="checkbox" name="checkarr" class="indoors" value="36">공연(뮤지컬,콘서트,연극)</label>
				</div>
		</div>
</div>  

<%-- <c:forEach items="${IVL_LIST}" var="list">
<div>
	<h3>${list.category}</h3>
		<div>
			<h4><label><input type="checkbox" name="${list.category}" id="${list.category}" class="${list.category}">전체선택</label></h4>
				<div>
					<c:forEach items="${list.interests}" var="ilist">
					<label><input type="checkbox" name="${list.category}s" class="${list.category}_e_check">${ilist.interest}</label>
					</c:forEach>
					<label><input type="checkbox" name="${list.category}s" class="${list.category}_e_check">기타
					<input type="text" name="${list.category}_except" class="${list.category}_except" disabled="disabled"></label>
				</div>
		</div>
</div>
</c:forEach> --%>

<div>
<br>
<input type="submit" value="선택완료" >
</div>
</form>

</body>
</html>