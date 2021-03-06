<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="../include/header.jspf"%>


<!-- 여기서 부터 수정 -->

<!-- Start main slider -->
<div id="carousel-example-generic"
	class="carousel slide edufair-slide carousel-fade" data-ride="carousel">
	<!-- Wrapper for slides -->
	<div class="carousel-inner edufair-inner single-inner" role="listbox">
		<div class="edufair-overlay">
			<img
				src="<%=request.getContextPath()%>/pages/images/mybackground.png"
				alt="slide 1" class="edufair-slider-image edufair-single-image">
			<div class="carousel-caption edufair-caption edufair-single-caption">
				<div class="edufair-slider-middle">
					<div class="container edufair-slider-text">
						<h2 class="fadeInLeft">My page</h2>
						<ol class="breadcrumb edufair-single-breadcrumbs">
							<li><a href="#">Home</a></li>
							<li><a href="#">My page</a></li>
							<li class="active">마이 페이지</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- End main slider -->

<!--  메인 박스 -->
<!-- Start edufair features -->
<div class="online-course-category-1x  margin-bottom-large">
	<div class="container">
		<div class="row">
			<div class="padding-top-large" style="padding-top: 30px"></div>
		</div>
		<div>
			<div>
				<!-- div 추가 -->
				<div class="padding-top-large" style="padding-top: 30px">
					<h2 class="edufair-main-title" style="text-align: left">회원 정보</h2>
					<form action="/member/modify" method="post">
						<input type="hidden" name="userId" value="${vo.userId}">
						<input type="hidden" name="gender" value="${vo.gender}">
						<input type="hidden" name="userRank" value="${vo.userRank}">
						<table class="type1">
							<tr>
								<th>회원ID</th>
								<td>${vo.userId}</td>
							</tr>
							<tr>
								<th>이메일</th>
								<td width="65%"><input type="text" name="userEmail"
									pattern="^([\w\.\_\-])*[a-zA-Z0-9]+([\w\.\_\-])*([a-zA-Z0-9])+([\w\.\_\-])+@([a-zA-Z0-9]+\.)+[a-zA-Z0-9]{2,8}$"
									size="40" value="${vo.userEmail}" required /></td>
							</tr>
							<tr>
								<th>닉네임</th>
								<td><input type="text" name="userName" size="40"
									value="${vo.userName}" /></td>
							</tr>
							<tr>
								<th>전화번호</th>
								<td><input type="text" name="phone" size="40"
									pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" value="${vo.phone}" /></td>
							</tr>
							<tr>
								<th>성별</th>
								
								<td>${vo.gender}</td>
							</tr>
							<tr>
								<th>주소</th>
								<td><input type="text" name="address" size="40"
									value="${vo.address}" /></td>
							</tr>
							<tr>
								<th>가입일자</th>
								<td>${vo.regDate}</td>
							</tr>

								<div class="form-group">
									<label for="sms">SMS 수신 </label> <label class="radio-inline">
										<input type="radio" name="sms" value="Y" checked> 동의
									</label> <label class="radio-inline"> <input type="radio"
										name="sms" value="N"> 비동의
									</label>
								</div>

							<tr>
								<th>회원등급</th>
								<td>${vo.userRank}</td>
							</tr>
							<!-- 비밀번호 변경 버튼 추가 -->
							<!--  버튼 class="btn btn-transparent" style="color: #fff" 
						 ->class="edufair-component-button button-large" style="border:solid 1px #eaeaea;" 변경 -->
							<%-- <tr>
							<th>비밀번호 변경</th>
							<td><button class="edufair-component-button button-large"
									style="border: solid 1px #eaeaea;" type="button"
									onclick="location.href='${pageContext.request.contextPath}/changePwd.do'">비밀번호
									변경</button></td>
						</tr>
						<tr>
							<th>나의 적립금</th>
							<td><button class="edufair-component-button button-large"
									style="border: solid 1px #eaeaea;" type="button"
									onclick="location.href='${pageContext.request.contextPath}/mypage/mypoint.do'">적립금
									확인</button></td>
						</tr>
						<tr>
							<th>차단 확인</th>
							<td><button class="edufair-component-button button-large"
									style="border: solid 1px #eaeaea;" type="button"
									onclick="location.href='${pageContext.request.contextPath}/mypage/myblock.do'">차단한
									ID 확인</button></td>
						</tr>
						<tr>
							<th>신고 확인</th>
							<td><button class="edufair-component-button button-large"
									style="border: solid 1px #eaeaea;" type="button"
									onclick="location.href='${pageContext.request.contextPath}/mypage/myreport.do'">신고한
									ID 확인</button></td>
						</tr> --%>

						</table>
						<button class="edufair-component-button button-large"
							type="submit">저장</button>
						<button class="edufair-component-button button-large"
							type="button" onclick="location.href='/home'">홈으로</button>
					</form>
				</div>
			</div>
		</div>

	</div>
</div>


<!--  메인 박스 끝 -->




<%@ include file="../include/footer.jspf"%>