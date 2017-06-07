<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<title>JQuery Project</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<link type="text/css" href="css/form.css" rel="stylesheet">
<script type="text/javascript">
	$(function() {
		$.post("json.jsp",{},function(obj){
			$("select option:gt(0)").remove() ;
			for (var x = 0 ; x < obj.allDepts.length ; x ++) {
				var option = $("<option>" + obj.allDepts[x].dname + "</option>") ;
				option.attr("value",obj.allDepts[x].deptno) ;
				//$("<option>" + obj.allDepts[x].dname + "</option>").attr("value",obj.allDepts[x].deptno) ;
				$("#dept").append(option) ;
			}
		},"json") ;
	}) ;
</script>  
</head> 
<body>
	部门：<select name="dept" id="dept">
			<option value="0">====== 请选择所在部门 ======</option>
		</select>
</body>
</html>
