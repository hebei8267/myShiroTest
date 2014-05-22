package com.tjhx.entity.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.tjhx.entity.IdEntity;

/**
 * 用户组
 */
@Entity
@Table(name = "T_USER_GROUP")
public class UserGroup extends IdEntity {

	private static final long serialVersionUID = 3389709199484828684L;

	/** 用户组编号 */
	@NaturalId
	@Column(name = "USER_GROUP_ID", nullable = false, unique = true, length = 32)
	private String id;

	/** 用户组姓名 */
	@Column(name = "USER_GROUP_NAME", nullable = false, length = 32)
	private String name;

	/** 备注 */
	@Column(name = "COMMENT")
	private String comment;

	/**
	 * 获取用户组编号
	 * 
	 * @return id 用户组编号
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置用户组编号
	 * 
	 * @param id 用户组编号
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取用户组姓名
	 * 
	 * @return name 用户组姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置用户组姓名
	 * 
	 * @param name 用户组姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取备注
	 * 
	 * @return comment 备注
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * 设置备注
	 * 
	 * @param comment 备注
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

}
