package com.devstringx.pmt.domain.common;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetailsDTO extends CommonDetailsDTO implements UserDetails {

	private static final long serialVersionUID = 4252923265521334091L;

	private String username;
	private String userDisplayNameFirst;
	private String userDisplayNameMiddle;
	private String userDisplayNameLast;

	@NotBlank
	@Email
	private String emailId;
	private String password;

	private String title;
	private String mobileNo;
	private String alternateEmail;
	private Date  lastPasswdChangeDate;
	private String lastPassword;
	private String address;
	private String area;
	private String city;
	private String state;
	private String pincode;


	//editable fields
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	private boolean isCredentialsNonExpired;
	private boolean isEnabled;
	private boolean verificationStatus;					//for email verification
	private Boolean passwordReset;						//whether password is reset using link or not


	private boolean credentialsExpired;					//additional field for checking of credentials expiry
	private Date resetPasswordLinkValidUpto;			//validity timestamp of resetPassword
	private Date resetPasswordLinkMailedOn;				//mailed timestamp of resetPassword
	private String[] role;
	private Integer count;

	private Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
	


	@Id
	@Column(name = "USER_ID", length = 20)
	public String getUsername() {
		return username;
	}

	@Column(name = "USER_NAME_FIRST", length = 40, nullable = false)
	public String getUserDisplayNameFirst() {
		return userDisplayNameFirst;
	}

	@Column(name = "USER_NAME_MIDDLE", length = 40)
	public String getUserDisplayNameMiddle() {
		return userDisplayNameMiddle;
	}

	@Column(name = "USER_NAME_LAST", length = 40)
	public String getUserDisplayNameLast() {
		return userDisplayNameLast;
	}

	@Column(name="EMAIL_VERIFIED", nullable=false, columnDefinition="smallint default 0")
	public boolean isVerificationStatus() {
		return verificationStatus;
	}

	@Column(name = "EMAIL_ID", nullable=false, length = 50)
	public String getEmailId() {
		return emailId;
	}

	@Basic
	@Column(name = "HASHED_PASSWORD", length = 500, nullable = false)
	public String getPassword() {
		return password;
	}

	@Column(name="USER_TITILE")
	public String getTitle() {
		return title;
	}

	@Column(name="MOBILE_NO")
	public String getMobileNo() {
		return mobileNo;
	}

	@Column(name="ALTERNATE_EMAIL")
	public String getAlternateEmail() {
		return alternateEmail;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="LAST_PASSWD_CHANGE_DATE")
	public Date getLastPasswdChangeDate() {
		return lastPasswdChangeDate;
	}

	@Column(name="LAST_PASSWORD")
	public String getLastPassword() {
		return lastPassword;
	}

	@Column(name="ADDRESS")
	public String getAddress() {
		return address;
	}

	@Column(name="AREA")
	public String getArea() {
		return area;
	}

	@Column(name="CITY")
	public String getCity() {
		return city;
	}

	@Column(name="STATE")
	public String getState() {
		return state;
	}

	@Column(name="PINCODE",length=10)
	public String getPincode() {
		return pincode;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}

	public void setLastPasswdChangeDate(Date lastPasswdChangeDate) {
		this.lastPasswdChangeDate = lastPasswdChangeDate;
	}

	public void setLastPassword(String lastPassword) {
		this.lastPassword = lastPassword;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Column(name = "IS_ACNT_NON_EXPD", nullable = false, columnDefinition = "smallint default 1")
	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}

	@Column(name = "IS_ACNT_NON_LOCKD", nullable = false, columnDefinition = "smallint default 1")
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	@Column(name = "IS_CRED_NON_EXPD", nullable = false, columnDefinition = "smallint default 1")
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	@Column(name = "IS_ENABLED", nullable = false, columnDefinition = "smallint default 1")
	public boolean isEnabled() {
		return isEnabled;
	}

	@ManyToMany(targetEntity = RoleDetailsDTO.class, 
			cascade = CascadeType.DETACH)
	@Fetch(FetchMode.JOIN)
	@JoinTable(name = "USER_ROLE_MAPPING",
	joinColumns = @JoinColumn(name = "URM_USER_ID"), 
	inverseJoinColumns = @JoinColumn(name = "URM_ROLE_ID"))
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	

	@Column(name = "COUNT", length=10)
	public Integer getCount() {
		return count;
	}

	@Column(name="IS_PASSWORD_RESET")
	public Boolean isPasswordReset() {
		return passwordReset;
	}

	@Column(name="PASSWORD_RESET_VALID_UPTO")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getResetPasswordLinkValidUpto() {
		return resetPasswordLinkValidUpto;
	}

	@Column(name="PASSWORD_RESET_LINK_MAILED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getResetPasswordLinkMailedOn() {
		return resetPasswordLinkMailedOn;
	}




	public void setUsername(String username) {
		this.username = username;
	}

	public void setAccountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}

	public void setAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}

	public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setUserDisplayNameFirst(String userDisplayNameFirst) {
		this.userDisplayNameFirst = userDisplayNameFirst;
	}

	public void setUserDisplayNameMiddle(String userDisplayNameMiddle) {
		this.userDisplayNameMiddle = userDisplayNameMiddle;
	}

	public void setUserDisplayNameLast(String userDisplayNameLast) {
		this.userDisplayNameLast = userDisplayNameLast;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setVerificationStatus(boolean verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public void setPasswordReset(Boolean passwordReset) {
		this.passwordReset = passwordReset;
	}

	public void setResetPasswordLinkValidUpto(Date resetPasswordLinkValidUpto) {
		this.resetPasswordLinkValidUpto = resetPasswordLinkValidUpto;
	}

	public void setResetPasswordLinkMailedOn(Date resetPasswordLinkMailedOn) {
		this.resetPasswordLinkMailedOn = resetPasswordLinkMailedOn;
	}

	@Transient
	public String[] getRole() {
		return role;
	}

	public void setRole(String[] role) {
		this.role = role;
	}

	@Transient
	public boolean isCredentialsExpired() {
		return credentialsExpired;
	}

	public void setCredentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}

	@Override
	public String toString() {
		return "UserDetailsDTO [username=" + username
				+ ", userDisplayNameFirst=" + userDisplayNameFirst
				+ ", userDisplayNameMiddle=" + userDisplayNameMiddle
				+ ", userDisplayNameLast=" + userDisplayNameLast + ", emailId="
				+ emailId + ", isAccountNonExpired=" + isAccountNonExpired
				+ ", isAccountNonLocked=" + isAccountNonLocked
				+ ", isCredentialsNonExpired=" + isCredentialsNonExpired
				+ ", isEnabled=" + isEnabled + ", verificationStatus="
				+ verificationStatus + ", passwordReset=" + passwordReset
				+ ", resetPasswordLinkValidUpto=" + resetPasswordLinkValidUpto
				+ ", resetPasswordLinkMailedOn=" + resetPasswordLinkMailedOn
				+ ", count=" + count + ", authorities=" + authorities+"]";
	}

	public static final String USER_ID="username";

}