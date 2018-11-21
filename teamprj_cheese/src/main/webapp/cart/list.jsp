<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
kim 님의 카트 목록<hr>
<table width="300" border="1">

<c:forEach items="${LVL_LIST}" var="cvo">
<tr>
	<td>
		<a href="/cartview/${cvo.cseq}">${cvo.cseq}</a>
	</td>
	<c:forEach items="${cvo.glist}" var="gvo">
	<td>
		${gvo.gname} 
		${gvo.gprice} 
	
		<fmt:formatNumber value="${gvo.gprice}" pattern="###,###,###,###" />

		<br>
	</td>
	</c:forEach>
	
</tr>	
</c:forEach>

</table>

</body>
</html>