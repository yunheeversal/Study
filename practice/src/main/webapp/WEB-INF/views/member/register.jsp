<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jspf" %>
		
			<div id="carousel-example-generic" class="carousel slide edufair-slide carousel-fade" data-ride="carousel"> 
				<!-- Wrapper for slides -->		   
				<div class="carousel-inner edufair-inner single-inner" role="listbox">									
						<div class="edufair-overlay">
							<img src="images/university/page-bg3.jpg" alt="slide 1" class="edufair-slider-image edufair-single-image">
							<div class="carousel-caption edufair-caption edufair-single-caption">
								<div class="edufair-slider-middle">
									<div class="container edufair-slider-text">
										<h2 class="fadeInLeft">회원가입</h2>	
										<ol class="breadcrumb edufair-single-breadcrumbs">								 
										</ol>										
									</div>
								</div>
							</div>				  
						</div>
				</div>
			</div>
						
		</div>
	                                <!-- 회원가입 -->
		 
										<div class="edufair-subscription-1x">
							
											<div class="edufair-subscription-form-1x">							
											<form action="/member/register"  method="POST">
													<div class="col-md-12">
														<div class="form-group">				
														<label for="userId">아이디</label>					    				    	
															<input type="text" id="userId" class="form-control"  name="userId" 
															placeholder="아이디를 입력해주세요." required >									
															<%-- <c:if test="${errors.duplicateId}">이미 사용중인 아이디입니다.</c:if> --%>
														</div>
													</div>
													<div class="col-md-12">
														<div class="form-group">			
														<label for="userPw">비밀번호</label>							    										    
															<input type="password" class="form-control" name="userPw" 
															 placeholder="비밀번호를 입력해주세요." required >	
														</div>
													</div>
													<div class="col-md-12">
														<div class="form-group">		
														<label for="confirmPassword">비밀번호 확인</label>									    
															<input type="password" class="form-control" name="confirmPassword" 
															 placeholder="비밀번호를 재 입력해주세요. " required >												
															<%-- <c:if test="${errors.notMatch}">비밀번호가 일치하지 않습니다.</c:if> --%>
														</div>
													</div>
													<div class="col-md-12">
														<div class="form-group">			
														<label for="userName">닉네임</label>							    										    
															<input type="text" class="form-control" name="userName" 
															placeholder="닉네임을 입력해주세요." required >
														</div>
													</div>
													<div class="col-md-12">
														<div class="form-group">		
														<label for="userEmail">이메일</label>								    										    
															<input type="email" class="form-control" name="userEmail" 
															placeholder="example@helpme.com" required >
														</div>
													</div>
													<div class="col-md-12">
														<div class="form-group">		
														<label for="phone">휴대전화</label>							    										    
															<input type="tel" class="form-control" name="phone"  pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
															placeholder="010-1234-5678" required >
														</div>
													</div>
													<div class="col-md-12">
														<div class="form-group">		
														<label for="address">주소</label>							    										    
															<input type="text" class="form-control" name="address" 
															placeholder="주소를 입력해주세요." required >
														</div>
													</div>
														<div class="col-md-12">
														<div class="form-group">		
														<label for="gender">성별 &nbsp	</label>							    										    
							                    			<label class="radio-inline"> <input type="radio" name="gender"  value="남" checked>남성 </label> 
							                    			<label class="radio-inline"> <input type="radio" name="gender"   value="여">여성 </label>
														</div>
													</div>
													
													<div class="col-md-12">
														<div class="form-group">
														<label for="sms">SMS 수신 &nbsp	</label>
														 <label class="radio-inline"> <input type="radio" name="sms"  value="Y" checked> 동의 </label> 
							                    			<label class="radio-inline"> <input type="radio" name="sms"   value="N"> 비동의 </label>
														</div>
														</div>													 
													
										               <input type="hidden" id="userRank" name="userRank" value="1">	
																										
														<input type="hidden" id="accTerms" name="accTerms" value="Y">													
																											
													<div class="col-md-12 terms-condition">	
														<h6>가입 시, <a href="#" class=""> 이용약관 </a>에 동의합니다.</h6>
													</div>
									
													<div class="col-md-12">
															<button type="submit"  class="btn btn-primary"  >가입하기 </button>				
													</div>
													</form>
													
													<div class="col-md-12 terms-condition">
														<p>이미 회원이신가요? <a href="/member/login" class=""> 로그인 </a></p>
													</div>												
											</div>								
								  </div>


<%@ include file="../include/footer.jspf" %>