package com.yutuer.core.domain;

import javax.persistence.Column;

public class BaseVersionModel implements IVersion {

	@Column(name = "version", columnDefinition = "varchar(36) NOT NULL COMMENT '更新用的字段'")
	private String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
