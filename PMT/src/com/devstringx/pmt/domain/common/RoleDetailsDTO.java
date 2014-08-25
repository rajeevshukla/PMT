package com.devstringx.pmt.domain.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author JavaDeamon
 *
 */
@Entity
@Table(name="ROLE_DETAILS")
public class RoleDetailsDTO implements GrantedAuthority {
	
	private static final long serialVersionUID = 4976542322975844498L;
	private String roleDesc;
	private String roleId;

	public RoleDetailsDTO(String roleDesc, String roleId) {
		super();
		this.roleDesc = roleDesc;
		this.roleId = roleId;
	}

	@Id
	@Column(name="ROLE_ID",length=50)
	public String getAuthority() {
		return roleId;
	}

	@Column(name="ROLE_DESC",length=100)
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	@Transient
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public void setAuthority(String roleId){
		this.setRoleId(roleId);
	}

	@Override
	public String toString() {
		return "RoleDetailsDTO [roleDesc=" + roleDesc + ", roleId=" + roleId
				+ "]";
	}

	

	
}