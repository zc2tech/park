package com.niyaowin.park.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//staff_id
//is_super
//phone
//mail
//password_hash
//salt
//nickname
//real_name

@Entity
@Table( name = "staff")
public class Staff {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="staff_id")
	private Long staffId;
	 @Column(name="is_super")
	private boolean isSuper;
    private String phone;
    private String mail;    

	private String passwordHash;   
    private String salt;   
    private String nickname;
    private String realName;

    
    public Long getStaffId() {
		return staffId;
	}
    
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	
	
	public boolean isSuper() {
		return isSuper;
	}
	public void setSuper(boolean isSuper) {
		this.isSuper = isSuper;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}

}
