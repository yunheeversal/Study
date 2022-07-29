<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jspf"%>


<div id="carousel-example-generic"
	class="carousel slide edufair-slide carousel-fade" data-ride="carousel">
	<!-- Wrapper for slides -->
	<div class="carousel-inner edufair-inner single-inner" role="listbox">
		<div class="edufair-overlay">
			<img src="/resources/bootstrap/images/mybackground.png" alt="slide 1"
				class="edufair-slider-image edufair-single-image">
			<div class="carousel-caption edufair-caption edufair-single-caption">
				<div class="edufair-slider-middle">
					<div class="container edufair-slider-text">
						<h2 class="fadeInLeft">로그인</h2>
						<ol class="breadcrumb edufair-single-breadcrumbs">
						</ol>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="edufair-subscription-form-1x">
	<div class="container">
		<div class="row">
			<div class="padding-top-large" style="padding-top: 30px"></div>
		</div>
		<div>

	<form action="/member/loginPost" method="post">
		<div class="col-md-12">
			<div class="form-group">
				<label for="userId">아이디</label> <input type="text"
					class="form-control" name="userId" placeholder="아이디" required>
				<%-- <c:if test="${errors.userId}"> </c:if> --%>
			</div>
		</div>
		<div class="col-md-12">
			<div class="form-group">
				<label for="userPw">비밀번호</label> <input type="password"
					class="form-control" name="userPw" placeholder="비밀번호" required>
				<%-- <c:if test="${errors.userPw}"> </c:if> --%>
			</div>
			<%-- <c:if test="${errors.idOrPwNotMatch}">
                                                    아이디와 암호가 일치하지 않습니다.  </c:if> --%>
			<div class="checkbox icheck">
				<label> <input type="checkbox" name="useCookie">
					Remember Me
				</label>
			</div>
		</div>
		<button type="submit" class="edufair-btn-larg btn-primary">로그인
		</button>
		
	</form>
	<div class="col-md-12 terms-condition">
		<p>
			<a href="/member/register" class=""> 회원가입 </a> | <a href="#" class=""> 비밀번호 찾기 </a>
		</p>
	</div>
</div>
</div>
</div>

<!-- jQuery 2.1.4 -->
<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<!-- Bootstrap 3.3.2 JS -->
<script src="/resources/bootstrap/js/bootstrap.min.js"
	type="text/javascript"></script>
<!-- iCheck -->
<script src="/resources/plugins/iCheck/icheck.min.js"
	type="text/javascript"></script>
<script>
	$(function() {
		$('input').iCheck({
			checkboxClass : 'icheckbox_square-blue',
			radioClass : 'iradio_square-blue',
			increaseArea : '20%' // optional
		});
	});
</script>
<%@ include file="../include/footer.jspf"%>