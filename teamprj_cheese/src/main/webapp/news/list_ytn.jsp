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
ytn 연예뉴스<hr>
<a href="/ytn">핫뉴스</a>   <a href="/aladin">도서목록</a>
<hr>
<table width="300" border="1">

<c:forEach items="${LVL_LIST}" var="cvo">
<tr>
	<td>
		<a href="${cvo.href}">${cvo.title}</a>
	</td>
	<td>${cvo.cont}</td>
	<td><img width="100" height="100" src="${cvo.imgsrc}"></td>
</tr>	
</c:forEach>

</table>

</body>
</html>