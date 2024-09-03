$(function() {    
    // 로그인 성공 시 세션 스토리지 설정
	 function setLoginSessionStorage(userId) {
	     sessionStorage.setItem('isLoggedIn', 'true');
		 sessionStorage.setItem('userId', userId); // 사용자 ID 저장
	 }
	 
	 // 로그아웃 처리
	 function bindLogoutEvent() {
	     $('#login_y_link2').click(function(){
	         sessionStorage.setItem('isLoggedIn', 'false');
			 deleteCookie('userId'); // userId 쿠키 삭제
	         alert('로그아웃 되었습니다.');
	         location.reload(true);
	     });
	 }
	 
	 // 쿠키 삭제 함수
	 function deleteCookie(name) {
	     document.cookie = name + '=; Max-Age=0; path=/;';
	 }
	

    // 세션 스토리지 확인 예시
    function getLoginSessionStorage() {
        return sessionStorage.getItem('isLoggedIn');
    }
    
    // 로그인 상태에 따라 네비게이션 바 업데이트
    function updateLoginStatus() {
        if (getLoginSessionStorage() === 'true') {
            $('#login_y_link').show();
            $('#login_n_link').hide();
            $('#login_n_link2').hide();
            $('#login_y_link2').show();
        } else {
            $('#login_y_link').hide();
            $('#login_n_link').show();
            $('#login_n_link2').show();
            $('#login_y_link2').hide();
        }
    }
    
	// GNB HTML을 로드하고 로그인 상태를 업데이트
	function loadGNB() {
	    $.get('gnb.html', function(data) {
	        $('#gnb-placeholder').html(data);
	        updateLoginStatus();
	        bindLogoutEvent(); // GNB 로드 후 이벤트 바인딩
	    });
		
		if(window.location.href.indexOf("index.html")){
			$('.nav-01').className += "active";
		}
	}
	
    // 페이지 로드 시 GNB 로드
    $(document).ready(function() {
        loadGNB();
    });
	
	
    
    // 모달 처리
    $(document).on('show.bs.modal', '#exampleModal', function (event) {
        var button = event.relatedTarget;
        var exampleModal = $(this);
		
		// 전화번호 입력 시 하이픈 자동 삽입
        exampleModal.find('#user_phonenumber').off('input').on('input', function() {
            let input = $(this).val();
            input = input.replace(/[^0-9]/g, ''); // 숫자가 아닌 문자는 모두 제거
            
            if (input.length >= 3 && input.length <= 6) {
                input = input.slice(0, 3) + '-' + input.slice(3);
            } else if (input.length > 6) {
                input = input.slice(0, 3) + '-' + input.slice(3, 7) + '-' + input.slice(7, 11);
            }
            
            $(this).val(input);
        });

        exampleModal.find('#modal-submit').click(function(){
            let formData = {
                user_name: $('#user_name').val(),
                user_id: $('#user_id').val(),
                user_pw: $('#user_pw').val(),
                user_email: $('#user_email1').val() + '@' + $('#user_email2').val(),
                user_phonenumber: $('#user_phonenumber').val(),
                user_address: $('#user_address').val(),
            };
            
            $.ajax({
                type : 'get',
                url : './jsp/register.jsp',
                data : formData,
                success : function(response){
                    alert('회원가입이 완료되었습니다.');
                },
                error : function(e) {
                    console.log(e);
                },
                complete: function(){
                    $('#exampleModal').modal('hide');
                }
            })
        });
        
        var recipient = button.getAttribute('data-bs-whatever');
        exampleModal.find('.modal-title').text('New message to ' + recipient);
        exampleModal.find('.modal-body input').val(recipient);
    });

    $(document).on('show.bs.modal', '#loginModal', function (event) {
        var button = event.relatedTarget;
        var loginModal = $(this);

        loginModal.find('#modal-login-submit').click(function(){
            let formData = {
                login_id: $('#login_id').val(),
                login_pw: $('#login_pw').val(),
            };
            
            $.ajax({
                type : 'get',
                url : './jsp/login.jsp',
                data : formData,
				success : function(response){
				               console.log(response); // 응답 내용을 확인
				               if(response.status === "success"){
				                   alert('로그인에 성공했습니다.');
				                   setLoginSessionStorage(response.userId); // 로그인 성공 시 사용자 ID 저장
				                   location.reload(true);
				               } else {
				                   alert('로그인에 실패했습니다.');
				               }
                },
                error : function(e) {
                    alert('로그인에 실패했습니다.');
                },
                complete: function(){
                    $('#loginModal').modal('hide');
                }
            })
        });

        var recipient = button.getAttribute('data-bs-whatever');
        loginModal.find('.modal-title').text('New message to ' + recipient);
        loginModal.find('.modal-body input').val(recipient);
    });
    

});
