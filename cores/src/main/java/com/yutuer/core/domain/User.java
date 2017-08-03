package com.yutuer.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

@Entity
@Table(name = "t_user")
public class User extends BaseVersionModel {

	@Id
	@Column(name = "userId", columnDefinition = "bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键,玩家账户唯一标示'")
	private long userId;

	@Index(name = "idx_userName")
	@Column(name = "userName", columnDefinition = "varchar(200) NOT NULL COMMENT '玩家名称'", unique = true)
	private String userName;

	@Column(name = "password", columnDefinition = "int(11) DEFAULT NULL COMMENT '密码'")
	private int password;

	@Column(name = "credit", columnDefinition = "int(11) DEFAULT NULL COMMENT 'credit'")
	private int credit;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

}
