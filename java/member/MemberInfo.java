package member;

import java.util.Date;

public class MemberInfo {
	
	private String id;
	private String password;
	private String name;
	private Date registerDate;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String val) {
		this.id = val;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String val) {
		this.password = val;
	}
	public String getName() {
		return name;
	}
	public void setName(String val) {
		this.name = val;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date val) {
		this.registerDate = val;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String val) {
		this.email = val;
	}
	
	public MemberInfo(String email, String name, String password, Date registerDate) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.registerDate = registerDate;
	}
	
	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}

	public void changePassword(String newPwd) {
		this.password = newPwd;
	}

}
