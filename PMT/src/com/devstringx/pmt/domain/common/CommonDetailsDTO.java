package com.devstringx.pmt.domain.common;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class CommonDetailsDTO implements Serializable {
	
	private static final long serialVersionUID = -452585979253252083L;
	
	private int version;
	private String strCreatedAuthor;
	private Date createdDate;
	private String strUpdatedAuthor;
	private Date updatedDate;
	
	@Column(name="VERSION",nullable=false,columnDefinition="integer default 1")
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	@Column(name="CREATED_AUTHOR",nullable=false,columnDefinition="varchar(20)")
	public String getStrCreatedAuthor() {
		return strCreatedAuthor;
	}
	public void setStrCreatedAuthor(String strCreatedAuthor) {
		this.strCreatedAuthor = strCreatedAuthor;
	}
	
	//@Column(name="CREATED_TS",nullable=false,columnDefinition="timestamp default now()")
	@Column(name="CREATED_AT",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name="UPDATED_AUTHOR",length=20)
	public String getStrUpdatedAuthor() {
		return strUpdatedAuthor;
	}
	public void setStrUpdatedAuthor(String strUpdatedAuthor) {
		this.strUpdatedAuthor = strUpdatedAuthor;
	}

	@Column(name="UPDATED_AT")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
