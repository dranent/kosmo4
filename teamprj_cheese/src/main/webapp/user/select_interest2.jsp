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
					<input type="checkbox" name="musics" class="musics" value="ballade">발라드
					<input type="checkbox" name="musics" class="musics" value="dance">댄스
					<input type="checkbox" name="musics" class="musics" value="raphiphop">랩/힙합
					<input type="checkbox" name="musics" class="musics" value="rnbsoul">RnB/Soul
					<input type="checkbox" name="musics" class="musics" value="indie">인디
					<input type="checkbox" name="musics" class="musics" value="rockmetal">록/메탈
					<input type="checkbox" name="musics" class="musics" value="trot">트로트
					<input type="checkbox" name="musics" class="musics" value="jazz">Jazz
					<label><input type="checkbox" name="musicsex" class="m_e_check">기타
					<input type="text" name="except" class="m_except" disabled="disabled"></label>
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