<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<h1>home 페이지 입니다.</h1>
<!-- 데이터 전송방식이 되게 여러개 인데, 그중에 하나로 선택 고정함. -->
<!-- <a href="/home/hello">hello 페이지로 이동</a>    오류 발생함. 왜?? POST 방식이라 해놓고, GET 방식 주소 요청해서 그렇다. -->

<!-- <a href="javascript:void(0)" id="hello-href">hello 페이지로 이동-href</a> <br />  하이퍼링크를 무력화 시킴 -->
<a href="/home/hello?id=ssar" id="hello-href">hello 페이지로 이동-href</a> <br /> 

<button id="hello-button">hello 페이지로 이동-button</button> <br />

<form>
	<input type="hidden" id="id" value="ssar" />    <!-- name 속성 대신에 id로 바꺼준다. -->
</form>
<!-- submit 하지 않음 -->
<button id="hello-button-form">hello 페이지로 이동-form</button><br />


<form>
	<input type="hidden" id="username" value="love" />    <!-- name 속성 대신에 id로 바꺼준다. -->
	<input type="hidden" id="phone" value="0102222" />    <!-- name 속성 대신에 id로 바꺼준다. -->
</form>
<button id="hello-put-form">hello 페이지로 이동-form</button><br />  
<!-- 함수이름은 다르게, 주소는 동일하게 hello -->




<script 
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- 여기 위치 중요함. -->
<!-- 세가지 방식의 데이터 전송을 모두 동일하게 하는 방법을 배운다.!!!!!!!!! -->


<script>

/* 	$('#hello-href').on('click', function(){

		let id='ssar';
		
		$.ajax({
			type: 'GET',
			url: '/home/hello?id=' +id,   
			// data : id   , content-Type : plain/text    쿼리 스트링??  모든 데이터는 제이슨으로 주고 받음.
// 			dataType : 무조건 JSON    // 우리는 그냥 데이터 보내는 연습할거니까...
		
		}); 
*/

		

// 	});
	
	// Delete 호출..
	$('#hello-button').on('click', function(){    //delete 방식으로 호출해보자.
		let data= {
			id : 'ssar'
		};
				
		$.ajax({
			type : 'DELETE',
			url : '/home/hello',
			data : JSON.stringify(data),
			contentType : 'application/json; charset=utf-8',
			dataType : 'json'

		}).done(function(result){
			if(result.statusCode == 200) {
				alert('글이 삭제 되었습니다.');
				location.href='/home/hello';
			}

		}).fail(function(result){
			alert('글 삭제가 실패하였습니다.');
		});
	});


	//POST 방식 호출.
	$('#hello-button-form').on('click', function(){
//		위에   id랑 value 값이 있기 때문에
//		let id = $('#id').val();
		let data={
				id : $('#id').val()
		};
		
// 		let data= {
// 				id : 'ssar'
// 			};
		
					
			$.ajax({
				type : 'POST',
				url : '/home/hello',
				data : JSON.stringify(data),
				contentType : 'application/json; charset=utf-8',
				dataType : 'json'	
			}).done(function(result){
				if(result.statusCode == 200) {
					alert('글이 등록 되었습니다.');
					location.href='/home/hello';
				}

			}).fail(function(result){
				alert('글 등록을 실패하였습니다.');
			});
		});



///// 내가 직접 PUT 해보기.////////////////
	// PUT 방식 호출.
	$('#hello-put-form').on('click', function(){

		let data={
			username:$('#username').val(),
			phone :$('#phone').val()
		};
		
			$.ajax({
				type : 'PUT',
				url : '/home/hello',
				data : JSON.stringify(data),
				contentType : 'application/json; charset=utf-8',   
				dataType : 'json'
					
			}).done(function(result){
				if(result.statusCode == 200) {
					alert('글이 수정 되었습니다.');
					location.href='/home/hello';
				}
			}).fail(function(result){
				alert('글 수정을  실패하였습니다.');
			});
		});

</script>
</body>
</html>