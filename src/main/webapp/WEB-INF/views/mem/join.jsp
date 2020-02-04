<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
<table border="1">
		<tr>		 	
			<th>username</th>
			
			<th>password</th>
			
			<th>email</th>
		</tr>
		<tr>
			<td><input id="username" type="text" /></td>
			
			<td><input id="password" type="password" /></td>
			
			<td><input id="email" type="email" /></td>
		</tr>
	</table>
	<button id="mem_join_proc">회원가입</button>
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script>

	// POST 방식 호출.
	$('#mem_join_proc').on('click', function(){
		let data={
			username :$('#username').val(),
			password:$('#password').val(),
			email :$('#email').val()			
		};
		
		$.ajax({
			type : 'POST',
			url : '/mem/api/join', 
			data : JSON.stringify(data),
			contentType : 'application/json; charset=utf-8',   
			dataType : 'json'     

		}).done(function(result){
			if(result.msg === 'ok'){
				alert('회원가입 성공');
				location.href='/mem';    //    DML 할떄는 이방식으로 고정해서 쓴다.  홈 화면 으로 감.
			} else {
				alert('회원가입 실패');
			}		
		}).fail(function(result){
			alert('서버오류');
		});
	});

	</script>


</body>
</html>










