package com.tjhx.entity.security;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.tjhx.entity.IdEntity;

/**
 * 用户
 */
@Entity
@Table(name = "T_USER", indexes = { 
		@Index(columnList = "LOGIN_NAME"),
		@Index(columnList = "PHONE_NUM"), 
		@Index(columnList = "QQ_NUM") })
public class User extends IdEntity {

	private static final long serialVersionUID = 1876787651127720876L;

	/** 用户编号 */
	@NaturalId
	@Column(name = "USER_ID", nullable = false, length = 32)
	private String id;

	/** 用户姓名 */
	@Column(name = "USER_NAME", nullable = false, length = 32)
	private String name;

	/** 登录帐号 */
	@Column(name = "LOGIN_NAME", nullable = false, unique = true, length = 32)
	private String loginName;

	/** 登录密码 */
	@Column(name = "PASS_WORD", nullable = false, length = 32)
	private String passWord;

	/** 性别 */
	@Column(name = "SEX", length = 1)
	private String sex;

	/** 出生日期YYYYMMDD */
	@Column(name = "BIRTH_DAY", length = 8)
	private String birthDay;

	/** 手机号码 */
	@Column(name = "PHONE_NUM", length = 16)
	private String phoneNum;

	/** 固定电话 */
	@Column(name = "TEL_NUM", length = 16)
	private String telNum;

	/** QQ号码 */
	@Column(name = "QQ_NUM", length = 16)
	private String qqNum;

	/** 电子邮件 */
	@Column(name = "EMAIL_ADD", length = 32)
	private String emailAdd;

	/** 有效性-0:禁用 1:启用 */
	@Column(name = "VALID_FLG", nullable = false, length = 1)
	private String validFlg;

	/** 备注 */
	@Column(name = "COMMENT")
	private String comment;

	/** 用户和角色的关系 */
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "T_USER_ROLE_REL", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
	private Set<Role> roles;

	/** 所属用户组 */
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_GROUP_UUID")
	private UserGroup userGroup;

	/**
	 * 获取用户编号
	 * 
	 * @return id 用户编号
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置用户编号
	 * 
	 * @param id 用户编号
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取用户姓名
	 * 
	 * @return name 用户姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置用户姓名
	 * 
	 * @param name 用户姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取登录帐号
	 * 
	 * @return loginName 登录帐号
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * 设置登录帐号
	 * 
	 * @param loginName 登录帐号
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * 获取登录密码
	 * 
	 * @return passWord 登录密码
	 */
	public String getPassWord() {
		return passWord;
	}

	/**
	 * 设置登录密码
	 * 
	 * @param passWord 登录密码
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	/**
	 * 获取性别
	 * 
	 * @return sex 性别
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 设置性别
	 * 
	 * @param sex 性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 获取出生日期YYYYMMDD
	 * 
	 * @return birthDay 出生日期YYYYMMDD
	 */
	public String getBirthDay() {
		return birthDay;
	}

	/**
	 * 设置出生日期YYYYMMDD
	 * 
	 * @param birthDay 出生日期YYYYMMDD
	 */
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	/**
	 * 获取手机号码
	 * 
	 * @return phoneNum 手机号码
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * 设置手机号码
	 * 
	 * @param phoneNum 手机号码
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/**
	 * 获取固定电话
	 * 
	 * @return telNum 固定电话
	 */
	public String getTelNum() {
		return telNum;
	}

	/**
	 * 设置固定电话
	 * 
	 * @param telNum 固定电话
	 */
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	/**
	 * 获取QQ号码
	 * 
	 * @return qqNum QQ号码
	 */
	public String getQqNum() {
		return qqNum;
	}

	/**
	 * 设置QQ号码
	 * 
	 * @param qqNum QQ号码
	 */
	public void setQqNum(String qqNum) {
		this.qqNum = qqNum;
	}

	/**
	 * 获取电子邮件
	 * 
	 * @return emailAdd 电子邮件
	 */
	public String getEmailAdd() {
		return emailAdd;
	}

	/**
	 * 设置电子邮件
	 * 
	 * @param emailAdd 电子邮件
	 */
	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}

	/**
	 * 获取有效性-0:禁用1:启用
	 * 
	 * @return validFlg 有效性-0:禁用1:启用
	 */
	public String getValidFlg() {
		return validFlg;
	}

	/**
	 * 设置有效性-0:禁用1:启用
	 * 
	 * @param validFlg 有效性-0:禁用1:启用
	 */
	public void setValidFlg(String validFlg) {
		this.validFlg = validFlg;
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

	/**
	 * 获取用户和角色的关系
	 * 
	 * @return roles 用户和角色的关系
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * 设置用户和角色的关系
	 * 
	 * @param roles 用户和角色的关系
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * 获取所属用户组
	 * 
	 * @return userGroup 所属用户组
	 */
	public UserGroup getUserGroup() {
		return userGroup;
	}

	/**
	 * 设置所属用户组
	 * 
	 * @param userGroup 所属用户组
	 */
	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

}
