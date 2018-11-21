<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
kim 님의 카트 상세보기<hr>
<table width="300" border="1">

<c:forEach items="${KEY_VO.glist}" var="cvo">
<tr>
	<td>
		${cvo.gname} ${cvo.gprice}
	</td>
	<c:forEach items="${cvo.imgList}" var="ivo">
	<td>
		<img src="/cdir/${ivo.ufileName}" width="100" height="100">
		${ivo.ufileName} <br>
	</td>
	</c:forEach>
	
</tr>	
</c:forEach>

</table>

</body>
</html>