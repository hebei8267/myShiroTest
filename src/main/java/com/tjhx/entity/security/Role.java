package com.tjhx.entity.security;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.tjhx.entity.IdEntity;

/**
 * 角色
 */
@Entity
@Table(name = "T_ROLE")
public class Role extends IdEntity {

	private static final long serialVersionUID = 481601850663825045L;

	/** 角色编号 */
	@NaturalId
	@Column(name = "ROLE_ID", nullable = false, length = 32)
	private String id;

	/** 角色名称 */
	@Column(name = "ROLE_NAME", nullable = false, length = 32)
	private String name;

	/** 角色有效性-0:禁用 1:启用 */
	@Column(name = "VALID_FLG", nullable = false, length = 1)
	private String validFlg;

	/** 备注 */
	@Column(name = "COMMENT")
	private String comment;

	/** 角色和菜单资源的多对多关系映射 */
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "T_ROLE_MENU_REL", joinColumns = { @JoinColumn(name = "ROLE_ID") }, inverseJoinColumns = { @JoinColumn(name = "MENU_ID") })
	private Set<Menu> menus;

	/**
	 * 获取角色编号
	 * 
	 * @return id 角色编号
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置角色编号
	 * 
	 * @param id 角色编号
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取角色名称
	 * 
	 * @return name 角色名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置角色名称
	 * 
	 * @param name 角色名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取角色有效性-0:禁用1:启用
	 * 
	 * @return valid 角色有效性-0:禁用1:启用
	 */
	public String getValidFlg() {
		return validFlg;
	}

	/**
	 * 设置角色有效性-0:禁用1:启用
	 * 
	 * @param valid 角色有效性-0:禁用1:启用
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
	 * 获取角色和菜单资源的多对多关系映射
	 * 
	 * @return menus 角色和菜单资源的多对多关系映射
	 */
	public Set<Menu> getMenus() {
		return menus;
	}

	/**
	 * 设置角色和菜单资源的多对多关系映射
	 * 
	 * @param menus 角色和菜单资源的多对多关系映射
	 */
	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	/**
	 * 添加菜单权限
	 * 
	 * @param menu
	 * @return
	 */
	public Role addMenuPmss(Menu menu) {
		if (null != menu) {
			if (null == menus) {
				this.menus = new HashSet<Menu>();
			}
			this.menus.add(menu);
		}

		return this;
	}
}
