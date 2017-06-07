<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript">
$(function(){
  $("#textPhone").focus(function(){
	  $(this).next().show().removeClass("").removeClass("onright").addClass("ontan").html("请输入你的联系电话");
  }).blur(function(){d
	  var patrn = /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$)/;
	  if($(this).val != ""){
		  if(!patrn.exec($(this).val)){
			  $(this).next().removeClass("ontan").addClass("onError").html("联系电话格式不正确");
		  }else{
			$(this).next().removeClass("ontan").removeClass("onError").addClass("onright").html("&nbsp;");
		  }
	  }
	  
  });
});
</script>
</head>
<body>

 <div align="center">
         联系方式<input type="text" id="textPhone"/><label style="color: red;" class="onError"></label>
     </div>
</body>
</html>