package org.yuni.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/*@NoArgsConstructor	// 기본 생성자 생성
@RequiredArgsConstructor   //NonNull이 붙은 필드의 생성자만 생성
@AllArgsConstructor 	// 모든 필드의 생성자 생성
@Getter  // getter
@Setter  // setter
@ToString	// ToString
*/
public class MemberVO {
	

	private String userId;
	private String userPw;
	private String userEmail;
	private String userName;
	private String phone;
	private String gender;
	private String address;
	private  Date regDate;
	private String sms; // char 타입인데 이걸 dao에서 
	private String accTerms;
	private int userRank;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getSms() {
		return sms;
	}
	public void setSms(String sms) {
		this.sms = sms;
	}
	public String getAccTerms() {
		return accTerms;
	}
	public void setAccTerms(String accTerms) {
		this.accTerms = accTerms;
	}
	public int getUserRank() {
		return userRank;
	}
	public void setUserRank(int userRank) {
		this.userRank = userRank;
	}
	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userPw=" + userPw + ", userEmail=" + userEmail + ", userName=" + userName
				+ ", phone=" + phone + ", gender=" + gender + ", address=" + address + ", regDate=" + regDate + ", sms="
				+ sms + ", accTerms=" + accTerms + ", userRank=" + userRank + "]";
	}
	
	
	
}
