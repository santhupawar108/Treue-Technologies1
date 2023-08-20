package com.pawar.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
@Data
@MappedSuperclass
public class CustomAuditEntity {

	@CreatedBy
	private String createdBy;
	
	@LastModifiedBy
	private String modifiedBy;
	
	private Date createdDate;
	
	private Date modifiedDate;
	
	

	public CustomAuditEntity() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CustomAuditEntity(String createdBy, String modifiedBy, Date createdDate, Date modifiedDate) {
		super();
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public String getModifiedBy() {
		return modifiedBy;
	}



	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}



	public Date getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



	public Date getModifiedDate() {
		return modifiedDate;
	}



	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
	
	
}
