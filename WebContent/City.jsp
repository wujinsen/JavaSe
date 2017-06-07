<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<link rel="stylesheet" type="text/css" href="css/form.css">

<script type="text/javascript">
	function getCity() {
		$("#city option:gt(0)").remove() ;
		
		$.post("get_json.jsp",{},function(obj) {
			
			var allCitys = obj.allCitys ;
			/* for (var x = 0 ; x < allCitys.length ; x ++) {
				//var options = $("<option>" + obj.allCitys[x].title + "</option");//此处一定要分开写
				//options.attr("value", obj.allCitys[x].id);
				//$("#city").append(options);
				$("#city").append("<option value="+allCitys[x].id+">"+allCitys[x].title+"</option>") ;
			} */
			for(var key in allCitys){
				//alert(key);//key相当于上面的x
				$("#city").append("<option value=''>" + allCitys[key].title + "</option");
			}
		},"json") ;
	}
	 function aa(){
     	alert($("#info").val());
     }
</script> 
</head>

<body>

	<select id="city">
		<option value="0">====== 请选择所在城市 ======</option>
	</select>
	<input type="button" value="读取城市信息f" onclick="getCity()">
	fd<br>
	<input type="button" onclick="aa()" value="点击显示内容">
    Please modify the contents of the text field.
    <input type="text" id="info" oninput="OnInput (event)" onchange="OnPropChanged (event)"
     value="Text fieldf" />
</body>
</body>
</html>