$(function(){
	
	$('#join').submit(function(){
		
		// 아이디 입력이 안되었을 때
		let user_id = $('input[name="user_id"]').val();
		if(!user_id){		//if( user_id=='')
			alert("아이디를 입력하세요");
			$('input[name="user_id"]').focus();		// 유효성 검사호 포커스 맞추기
			return false;
		}
		
		// 비밀번호 입력이 안되었을 때
		let user_pw = $('input[name="user_pw"]').val();
		if( user_pw==''){	// if(!user_pw)
			alert("비밀번호를 입력하세요");
			$('input[name="user_pw"]').focus();		
			return false;
		}
		
		// 성별 입력이 안되었을 때
		// radio는 선택되면 true, 안되었으면 flase ==> 확인을 위해서 is(':checked')
		if(!$('input[name="gender"]').is(':checked')){
			alert("성별를 입력하세요");
			
			// 무조건 남자 선택되게함
			// radio는 배열로 받는다.
			// javascript  
			//document.form1.gender[0].checked = true;
			// jQuery
			$('input[name="gender"]:eq(0)').attr(':checked', true)
				// .attr() : attribute => 속성  => 동적으로 checked='checked' 속성을 넣는다 
				// .prop() : property
			
			return false;
		}
		
		// 이메일
		let email = $('input[name="email"]').val();
		if(!email){	
			alert("이메일를 입력하세요");
			$('input[name="email"]').focus();		// 유효성 검사호 포커스 맞추기
			return false;
		}
		
		// url
		let url = $('input[name="url"]').val();
		if(!url){	
			alert("url를 입력하세요");
			$('input[name="url"]').focus();		// 유효성 검사호 포커스 맞추기
			return false;
		}
		
		// phone
		let phone = $('input[name="phone"]').val();
		if(!phone){	
			alert("phone를 입력하세요");
			$('input[name="phone"]').focus();		// 유효성 검사호 포커스 맞추기
			return false;
		}
		
		
		// 취미(체크박스)
		if(!$('input[name="hobby"]').is(':checked')){
			alert("취미를 선택하세요");
			$('input[name="hobby"]:eq(1)').attr('checked', true);
			$('input[name="hobby"]').focus();
			return false;
		}
		
		// 직업(콤보박스)
		if($('select[name="job"] > option:selected').index()==0){
			alert(" 직업를 선택하세요");
			$('select[name="job"] > option:eq(1)').attr('selected', true);
			return false;
		}

		
		// -----------------
		// 입력한 내용을 화면에 출력
		
		//아이디
		//비밀번호
		//성별
		let gender = $('input[name="gender"]:checked').val();
		//이메일
		//url
		//핸드폰
		//취미 => 체크박스 => 여러개 선택 가능 => 배열
		let hobby = $('input[name="hobby"]:checked');		// 배열
		let hobby_val = '';
		hobby.each(function(){		// each()랑 강화for랑 비슷한 느낌?
			hobby_val += $(this).val();			// $(this) : 자기자신 => 지금은 each안에서 돌고있는 하나하나를 가리킴
		});
		//직업
		let job = $('select[name="job"] > option:selected').val();
		
		//
		let result = `
			<ul>
				<li>아이디 : ` + user_id + `</li>
				<li>비밀번호 : ` + user_pw + `</li>
				<li>성별 : ` + gender + `</li>
				<li>이메일 : ` + email + `</li>
				<li>url : ` + url + `</li>
				<li>핸드폰 : ` + phone + `</li>
				<li>취미 : ` + hobby_val + `</li>
				<li>직업 : ` + job + `</li>
			</ul>
			`; 
		
		$('body').html(result);
		
		
		
		

		return false;		// 가야할 페이지가 없기 때문에 페이지 이동 막기
	});
	
});