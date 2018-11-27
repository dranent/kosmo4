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
<script src="/js/select_interest.js?ver=4124124123213"></script>

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


<form action="/comdo" method="post" class="interestFORM">
<div>
	<h3>노래</h3>
		<div>
			<h4><label><input type="checkbox" name="m_all" id="m_all" class="m_all">전체선택</label></h4>
				<div>
					<label><input type="checkbox" name="musics" class="musics" value="ballade">발라드</label>
					<label><input type="checkbox" name="musics" class="musics" value="dance">댄스</label>
					<label><input type="checkbox" name="musics" class="musics" value="raphiphop">랩/힙합</label>
					<label><input type="checkbox" name="musics" class="musics" value="rnbsoul">RnB/Soul</label>
					<label><input type="checkbox" name="musics" class="musics" value="indie">인디</label>
					<label><input type="checkbox" name="musics" class="musics" value="rockmetal">록/메탈</label>
					<label><input type="checkbox" name="musics" class="musics" value="trot">트로트</label>
					<label><input type="checkbox" name="musics" class="musics" value="jazz">Jazz</label>
					<label><input type="checkbox" name="musics" class="m_e_check" value="except">기타
					<input type="text" name="excepts" class="m_except" disabled="disabled"></label>
				</div>
		</div>
</div>

<div>
	<h3>책</h3>
		<div>
			<h4><label><input type="checkbox" name="b_all" id="b_all" class="b_all">전체선택</label></h4>
				<div>
					<label><input type="checkbox" name="books" class="books" value="fiction">소설</label>
					<label><input type="checkbox" name="books" class="books" value="poem">시</label>
					<label><input type="checkbox" name="books" class="books" value="essay">에세이</label>
					<label><input type="checkbox" name="books" class="books" value="classic">고전</label>
					<label><input type="checkbox" name="books" class="books" value="cartoon">만화</label>
					<label><input type="checkbox" name="books" class="books" value="appellative">자기계발</label>
					<label><input type="checkbox" name="books" class="books" value="history">역사</label>
					<label><input type="checkbox" name="books" class="books" value="science">과학</label>
					<label><input type="checkbox" name="books" class="books" value="health">건강</label>
					<label><input type="checkbox" name="books" class="books" value="hobby">취미</label>
					<label><input type="checkbox" name="books" class="books" value="leisure">레저</label>
					<label><input type="checkbox" name="books" class="books" value="trip">여행</label>
					<label><input type="checkbox" name="books" class="books" value="magazine">잡지</label>
					<label><input type="checkbox" name="books" class="b_e_check" value="except">기타
					<input type="text" name="excepts" class="b_except" disabled="disabled"></label>
				</div>
		</div>
</div>

<div>
	<h3>영상</h3>
		<div>
			<h4><label><input type="checkbox" name="v_all" id="v_all" class="v_all">전체선택</label></h4>
				<div>
					<label><input type="checkbox" name="videos" class="videos" value="game">게임</label>
					<label><input type="checkbox" name="videos" class="videos" value="exercise">운동</label>
					<label><input type="checkbox" name="videos" class="videos" value="cook">요리</label>
					<label><input type="checkbox" name="videos" class="videos" value="diy">DIY</label>
					<label><input type="checkbox" name="videos" class="v_e_check" value="except">기타
					<input type="text" name="excepts" class="v_except" disabled="disabled"></label>
				</div>
		</div>
</div>

<div>
	<h3>실외활동</h3>
		<div>
			<h4><label><input type="checkbox" name="o_all" id="o_all" class="o_all">전체선택</label></h4>
				<div>
					<label><input type="checkbox" name="outdoors" class="outdoors" value="stroll">산책</label>
					<label><input type="checkbox" name="outdoors" class="outdoors" value="festival">축제</label>
					<label><input type="checkbox" name="outdoors" class="outdoors" value="shopping">쇼핑</label>
					<label><input type="checkbox" name="outdoors" class="outdoors" value="bicycle">자전거</label>
					<label><input type="checkbox" name="outdoors" class="outdoors" value="climbing">등산</label>
				</div>
		</div>
</div>

<div>
	<h3>실내활동</h3>
		<div>
			<h4><label><input type="checkbox" name="i_all" id="i_all" class="i_all">전체선택</label></h4>
				<div>
					<label><input type="checkbox" name="indoors" class="indoors" value="exhibition">전시회</label>
					<label><input type="checkbox" name="indoors" class="indoors" value="movie">영화</label>
					<label><input type="checkbox" name="indoors" class="indoors" value="performance">공연(뮤지컬,콘서트,연극)</label>
				</div>
		</div>
</div>
<div>
<br>
<input type="submit" value="선택완료" >
</div>
</form>

</body>
</html>