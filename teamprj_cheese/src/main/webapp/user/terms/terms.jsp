<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.js?ver=2141214123"></script>
<script>

$(document).ready(function(){
	//$("#yac1").load(yacx);
	
});
function closed(){
	self.close();	
}
</script>
</head>
<body>
<h2>개인정보수집동의</h2>
<textarea id="yac1" style="resize:none;padding-right:6px;width:700px;padding-left:6px;" readonly="readonly" rows="15">

  ‘(주)Time Cheese'는(은) (이하 '회사'는)
    고객님의 개인정보를 중요시하며, "정보통신망 이용촉진 및 정보보호"에 관한 법률을 준수하고 있습니다.

    회사는 개인정보취급방침을 통하여 고객님께서 제공하시는 개인정보가 어떠한 용도와 방식으로 이용되고 있으며,
    개인정보보호를 위해 어떠한 조치가 취해지고 있는지 알려드립니다.


    회사는 개인정보취급방침을 개정하는 경우 웹사이트 공지사항(또는 개별공지)을 통하여 공지할 것입니다.

    ■ 수집하는 개인정보 항목

    회사는 제공하는 추천 컨텐츠 등을 위해 아래와 같은 개인정보를 수집하고 있습니다.


    ο 수집항목 : ID(당사 홈페이지 회원가입), Gmail주소orEmail, 닉네임, 관심분야 
    ο 개인정보 수집방법 : 홈페이지(회원 가입) 또는 Google로그인

    ■ 개인정보의 수집 및 이용목적

    회사는 수집한 개인정보를 다음의 목적을 위해 활용합니다.

    ο 회원 관리
    회원제 서비스 이용에 따른 본인확인 , 개인 식별 , 불량회원의 부정 이용 방지와
    비인가 사용 방지 , 가입 의사 확인 
    ο 마케팅 및 광고에 활용
    접속 빈도 파악 또는 회원의 서비스 이용에 대한 통계

    ■ 개인정보의 보유 및 이용기간

    원칙적으로, 개인정보 수집 및 이용목적이 달성된 후에는 해당 정보를 지체 없이 파기합니다.
    단, 관계법령의 규정에 의하여 보존할 필요가 있는 경우 회사는 아래와 같이 관계법령에서 정한 일정한 기간 동안 회원정보를 보관합니다.


    보존 항목 : 개인 정보
    보존 근거 : 신용정보의 이용 및 보호에 관한 법률
    보존 기간 : 회원탈퇴시까지

    표시/광고에 관한 기록 : 6개월 (전자상거래등에서의 소비자보호에 관한 법률)
    계약 또는 청약철회 등에 관한 기록 : 5년 (전자상거래등에서의 소비자보호에 관한 법률)
    대금결제 및 재화 등의 공급에 관한 기록 : 5년 (전자상거래등에서의 소비자보호에 관한 법률)
    소비자의 불만 또는 분쟁처리에 관한 기록 : 3년 (전자상거래등에서의 소비자보호에 관한 법률)
    신용정보의 수집/처리 및 이용 등에 관한 기록 : 3년 (신용정보의 이용 및 보호에 관한 법률) 
    
    </textarea>
    <input type="button" value="닫기" onclick="closed()">
</body>
</html>