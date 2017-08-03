package com.yutuer.core.domain;

import javax.persistence.Column;
import javax.persistence.Id;

import org.hibernate.annotations.Index;

public class LoginLog extends BaseVersionModel {

	@Id
	@Column(name = "loginId", columnDefinition = "bigint(20) AUTO_INCREMENT COMMENT '主键,自增'")
	private long loginId;

	@Index(name = "idx_userId")
	@Column(name = "userId", columnDefinition = "bigint(20) COMMENT '玩家userid'", unique = true)
	private long userId;

	@Column(name = "ip", columnDefinition = "varchar(50) comment '玩家密码'")
	private String ip;

	@Column(name = "loginDate", columnDefinition = "bigint(20) comment '玩家登录时间'")
	private long loginDate;

	public long getLoginId() {
		return loginId;
	}

	public void setLoginId(long loginId) {
		this.loginId = loginId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public long getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(long loginDate) {
		this.loginDate = loginDate;
	}

}
