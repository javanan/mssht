package com.wssht.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userid; // char(32) NOT NULL用户id
	private String relname; // /varchar(10) NOT NULL用户真实姓名
	private String lodname; // varchar(16) NOT NULL用户登录账户
	private String password; // varchar(32) NOT NULL用户密码

	
	@Id
	@Column(name="user_id")
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid")
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name="user_relname")
	public String getRelname() {
		return relname;
	}

	public void setRelname(String relname) {
		this.relname = relname;
	}

	@Column(name="user_lodname")
	public String getLodname() {
		return lodname;
	}

	public void setLodname(String lodname) {
		this.lodname = lodname;
	}

	@Column(name="user_password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
