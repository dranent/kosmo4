<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html >
<head>
<script>
function viewOpen(url) {
	window.open(url, 'child01', 'top=100px, left=100px, height=500px, width=500px');
}
</script>
</head>
<body>

Youtebe 동영상 검색 결과<hr>
<form action="/search" method="post">
<input type="text" name="searchStr">
<input type="submit" value="PIN Search">
</form>
<br>
<table border="1" cellpadding="0" cellspacing="0" width=80%>
<thead>
	<tr>
		<th colspan="4">${param.searchStr} 검색결과 </th>
	</tr>
</thead>
<tbody>


		<%--  <td>
			<a href="#" onClick="viewOpen('https://www.youtube.com/watch?v=${svo.videoId}')">${svo.title}</a>
		</td>  --%>


	<tr>
<c:forEach items="${LVL_LIST}" var="svo" varStatus="i">
		<td>
			<iframe width="382" height="191" src="https://www.youtube.com/embed/${svo.videoId}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
			<br>${fn:substring(svo.title,0,25)}
			<c:if test="${fn:length(svo.title)>25}"> ...</c:if>
		</td>
		<c:if test="${i.count%4 == 0 and i.count < fn:length(LVL_LIST)}">
			</tr><tr>
		</c:if>	
</c:forEach>
</tbody>
</table>


</body>
</html>
