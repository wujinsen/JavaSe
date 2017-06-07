<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>


<script>
  var person={
	firstName: "zhang",
	lastName: "san",
	allName: function(){
		return this.firstName+this.lastName;
	}
  }
  //alert(person.allName());
  console.log(person.firstName);
  console.log(person["lastName"]);
  console.log(person.allName());
  const aaa="i love u";//javascript常量
  var num=5;
  for(let num=0;num<10;num++){
	  
  }
  alert(num);
</script>

</body>
</html>