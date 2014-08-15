
package com.devstringx.pmt.domain.common;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="USER_ROLE_MAPPING")
public class UserRoleMappingDTO implements Serializable {

	private static final long serialVersionUID = -3614652973846176678L;
	private String roleId;
	private String userId;
	private String[] roles;
	
	@Id
	@Column(name="URM_ROLE_ID", length=30)
	public String getRoleId() {
		return roleId;
	}
	@Id
	@Column(name="URM_USER_ID", length=20)
	public String getUserId() {
		return userId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Transient
	public String[] getRoles() {
		return roles;
	}
	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	
	@Override
	public String toString() {
		return "UserRoleMappingDTO [roleId=" + roleId + ", userId=" + userId
				+ ", roles=" + Arrays.toString(roles) + "]";
	}
}