package edu.smartlist.service.project.manager.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.domain.Persistable;

@MappedSuperclass
public abstract class AbstractBaseEntity implements Persistable<String> {

	@Id
	@Column(name="ID")
	private String id;
	
	@Column(name="CREATED_TIME")
	private Date createdTime;
	
	@Column(name="UPDATED_TIME")
	private Date updatedTime;
	
	@Column(name="VERSION")
	private long version;
	
	public Date getCreatedTime() {
		return createdTime;
	}
	
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String getId() {
		return id;
	}
	@Override
	public boolean isNew() {
		return null == getId();
	}
	
	@PrePersist
	protected void onCreate() {
		if (getId() == null) {
			setId(UUID.randomUUID().toString());
			createdTime = new Date();
			setCreatedTime(createdTime);
			setVersion(1);
			setUpdatedTime(createdTime);
		}		
	}

	@PreUpdate
	protected void onUpdate() {
		setVersion(getVersion()+1);
		updatedTime = new Date();
		setUpdatedTime(updatedTime);
	}
}
