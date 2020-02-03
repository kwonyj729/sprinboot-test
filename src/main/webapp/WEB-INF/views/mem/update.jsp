<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
﻿
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정 페이지</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>id</th>
			<th>username</th>
			<th>password</th>
			<th>email</th>
			<th>createDate</th>
		</tr>
		<tr>
			<td><input id="id" type="text" value="${mem.id}" readonly="readonly"/></td>
			<td><input id="" type="text" value="${mem.username}" readonly="readonly"/></td>
			<td><input id="password" type="password" value="${mem.password}" /></td>
			<td><input id="email" type="email" value="${mem.email}" /></td>
			<td><input id="" type="text" value="${mem.createDate}" readonly="readonly"/></td>
	
		</tr>
	</table>
	<button id="mem_update_proc">수정완료</button>
	<button id="mem_delete_proc">회원삭제</button>
	  
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
<script>
	// PUT 방식 호출.
	$('#mem_update_proc').on('click', function(){
		let data={
			id :$('#id').val(),
			password:$('#password').val(),
			email :$('#email').val()			
		};
		
		$.ajax({
			type : 'PUT',
			url : '/mem/api/update',    //데이터를 응답받을때는 항상 apo를 적어줘야한다.
			data : JSON.stringify(data),
			contentType : 'application/json; charset=utf-8',   
			dataType : 'text'          //'json'

		}).done(function(result){
			if(result === 'ok'){
				// console.log(result);
				alert('회원정보 수정 성공');
				location.href='/mem';    //    DML 할떄는 이방식으로 고정해서 쓴다.  홈 화면 으로 감.
			} else {
				// console.log(result);
				alert('회원정보 수정 실패');
			}		
		}).fail(function(result){
			alert('서버오류');
		});
	});


	// DELETE 방식 호출.
	$('#mem_delete_proc').on('click', function(){

		 let id = $('#id').val();		
		
		$.ajax({
			type : 'DELETE',
			url : '/mem/api/delete/'+id,   
			dataType : 'text'
		}).done(function(result){
			if(result === 'ok'){
				alert('회원삭제 성공');
				location.href='/mem';    
			} else {
				alert('회원삭제 실패');
			}		
		}).fail(function(result){
			alert('서버오류');
		});
	});
	</script>
	
	

</body>
</html>