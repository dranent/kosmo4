$(document).ready(function(){
	
	
	
	$(".m_all").click(function(){ 
		$(".musics").prop("checked",this.checked);
	});
	$(".m_e_check").click(function(){
	var mchecked = $(".m_e_check").is(":checked");
	if(mchecked==true){
		$(".m_except").removeAttr('disabled');
		$(".m_except").focus();
	}else{
		$(".m_except").attr("disabled","disabled");
	}
	
	}); 
	
	
	
	
	
	$(".b_all").click(function(){ 
		$(".books").prop("checked",this.checked);
	});
	$(".b_e_check").click(function(){
	var mchecked = $(".b_e_check").is(":checked");
	if(mchecked==true){
		$(".b_except").removeAttr('disabled');
		$(".b_except").focus();
	}else{
		$(".b_except").attr("disabled","disabled");
	}
	
	}); 
	
	
	
	
	
	$(".v_all").click(function(){ 
		$(".videos").prop("checked",this.checked);
	});
	$(".v_e_check").click(function(){
		var mchecked = $(".v_e_check").is(":checked");
		if(mchecked==true){
			$(".v_except").removeAttr('disabled');
			$(".v_except").focus();
		}else{
			$(".v_except").attr("disabled","disabled");
		}
		
		}); 
		
	
	
	
	$(".o_all").click(function(){ 
		$(".outdoors").prop("checked",this.checked);
	});
	
 
	
	
	$(".i_all").click(function(){ 
		$(".indoors").prop("checked",this.checked);
	});
	
	
	
//	$.ajax({
//        type:"POST",
//        url:"/selectinterest",
//        //dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
//        success : function(data) {
//              // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
//        	console.log(data);
//			$.map(data, mapCallback);
//			function mapCallback( v,  i) { 
//				console.log(v.cateseq + "," + v.category);
//			}
//			
//			
//        },
//
//        complete : function(data) {
//              // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
//        	console.log(data);
//			console.log(data.cateseq + "," + data.category);
//        },
//
//        error : function(xhr, status, error) {
//
//              alert("에러발생");
//
//        }
//
//  });
});