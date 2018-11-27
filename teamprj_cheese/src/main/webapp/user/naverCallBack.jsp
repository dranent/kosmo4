<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js?ver=142141244"></script>
</head>
<body>
<script>
  var naver_id_login = new naver_id_login("LxiRH2TKoi75JMT5N7iz", "http://localhost/naver_callback");
  // 접근 토큰 값 출력
  
  // 네이버 사용자 프로필 조회
  naver_id_login.get_naver_userprofile("naverSignInCallback()");
  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
  function naverSignInCallback() {
	  
	  var naverUser={"id":naver_id_login.getProfileData('id'),
	  				"email":naver_id_login.getProfileData('email'),
					"profileImage":naver_id_login.getProfileData('profile_image')};
    alert(naver_id_login.getProfileData('email'));
    alert(naver_id_login.getProfileData('id'));
    alert(naver_id_login.getProfileData('nickname'));
    alert(naver_id_login.getProfileData('age'));
    alert(naver_id_login.getProfileData('profile_image'));
    
    //var oPerson = JSON.parse(naverUser);

    $.ajax({
        url:"naveruser",
        type:'POST',
        dataType : 'json',
        data: naverUser,
        success:function(data){
                  },
        error:function(jqXHR, textStatus, errorThrown){
        }
    });
  }
</script>
</body>
</html>