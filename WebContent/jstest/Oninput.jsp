<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.10.2.js"></script>
    <script type="text/javascript">
    // Firefox, Google Chrome, Opera, Safari, Internet Explorer from version 9
        function OnInput (event) {
            alert (event);
        }
    // Internet Explorer
        function OnPropChanged (event) {
            if (event.propertyName.toLowerCase () == "value") {
                alert ("The new contents: " + event.srcElement.value);
            }
        }
        function setDropDown(str){
        	
        var ops=document.getElementById("enterprises").options;//原有列表
       	 var ops2=document.getElementById("enterprises2").options;//暂存列表
       	 if(str==""){
       		 $("#enterprises").empty();
       		 for(var i=0;i<ops2.length;i++){
       		   $("#enterprises").append("<option value=\""+ops2[i].value+"\">"+ops2[i].text+"</option>");
       		 }
       	 }else{
       	
       		 $("#enterprises").empty();
       		
       		 for(var i=0;i<ops2.length;i++){
       			 var a = ops2[i].text;
       			 while(a.indexOf(str) != -1){		//如果该项的value等于文本框填写的值
       				
       				   $("#enterprises").append("<option value=\""+ops2[i].value+"\">"+ops2[i].text+"</option>");
       				 break;
       		  	}
       		}
       		var ops_=document.getElementById("enterprises").options;//原有列表
       		if(ops_.length<=0){
       		
       		 //$("#enterprises").empty();
       		 for(var i=0;i<ops2.length;i++){
       		   $("#enterprises").append("<option value=\""+ops2[i].value+"\">"+ops2[i].text+"</option>");
       		 }
       		}
       	 }
        }
        //测试jquery弹出
        function aa(){
        	alert($("#info").val());
        }
        //监听输入框值的即时变化
        function immediately(){ 
        	var element = document.getElementById("mytext"); 
        	if("\v"=="v") { 
        	element.onpropertychange = webChange; 
        	}else{ 
        	element.addEventListener("input",webChange,false); 
        	} 
        	function webChange(){ 
        	if(element.value){document.getElementById("test").innerHTML = element.value}; 
        	} 
        	} 

    </script>
    
</head>

<body>
	<input type="button" onclick="aa()" value="点击">
    Please modify the contents of the text field.
    <input type="text" id="info" oninput="OnInput(this.value)" onchange="OnPropChanged (event)"
     value="改变内容即时显示" />
     <input type="text" id="enterprisesInput" oninput="setDropDown(this.value)" /><br />
										<select name="enterprises" id="enterprises" > 
											<option value="其它">其它</option>
												<option value="S082" size="1">爱建证券有限责任公司 </option>
											
												 <option value="A040" size="1">安徽大时代投资咨询有限公司 </option>
											
												 <option value="A039" size="1">安徽华安新兴证券投资咨询有限责任公司 </option>
											
												 <option value="F069" size="1">安信基金管理有限责任公司 </option>
											
												 <option value="S145" size="1">安信证券股份有限公司 </option>
											
												 <option value="F009" size="1">宝盈基金管理有限公司 </option>
											
												 <option value="A050" size="1">北京博星投资顾问有限公司 </option>
											
												 <option value="A010" size="1">北京东方高圣投资顾问有限公司 </option>
												</select>
										<select name="enterprises2" id="enterprises2" style="display:none" > 
											<option value="其它">其它</option>
												<option value="S082" size="1">爱建证券有限责任公司 </option>
											
												 <option value="A040" size="1">安徽大时代投资咨询有限公司 </option>
											
												 <option value="A039" size="1">安徽华安新兴证券投资咨询有限责任公司 </option>
											
												 <option value="F069" size="1">安信基金管理有限责任公司 </option>
											
												 <option value="S145" size="1">安信证券股份有限公司 </option>
											
												 <option value="F009" size="1">宝盈基金管理有限公司 </option>
											
												 <option value="A050" size="1">北京博星投资顾问有限公司 </option>
											
												 <option value="A010" size="1">北京东方高圣投资顾问有限公司 </option>
												</select>
												<br>
		<input type="text" name="textfield" id="mytext" onclick="immediately()"/> 
<div>您输入的值为：<span id="test">还未输入</span></div> 
		<input type="text" name="textfield" oninput="document.getElementById('webtest').innerHTML=this.value;" onpropertychange="document.getElementById('webtest').innerHTML=this.value;" /> 
<div>您输入的值为：<span id="webtest">还未输入</span></div> 
												
	
</body>
</html>