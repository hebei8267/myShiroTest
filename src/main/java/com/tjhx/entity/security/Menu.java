package com.tjhx.entity.security;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;
import org.hibernate.annotations.NaturalId;

import com.tjhx.entity.IdEntity;

/**
 * 菜单资源
 */
@Entity
@Table(name = "T_MENU", indexes = { @Index(columnList = "PARENT_MENU_ID") })
public class Menu extends IdEntity {

	private static final long serialVersionUID = -3867959331047032376L;

	/** 菜单资源编号 */
	@NaturalId
	@Column(name = "MENU_ID", nullable = false, length = 32)
	private String id;

	/** 菜单资源名称 */
	@Column(name = "MENU_NAME", nullable = false, length = 32)
	private String name;

	/** 菜单导航地址 */
	@Column(name = "MENU_NAV_LINK", length = 64)
	private String navLink;

	/** 菜单图标 */
	@Column(name = "ICON_PATH", length = 64)
	private String iconPath;

	/** 数据对象排序序号 */
	@Column(name = "_INDEX")
	private int _index;

	/** 菜单类型 1-文件夹2-叶节点 */
	@Column(name = "MENU_TYPE")
	private int type;

	/** 备注 */
	@Column(name = "COMMENT")
	private String comment;

	/** 父菜单 */
	@ManyToOne
	@JoinColumn(name = "PARENT_MENU_UUID")
	private Menu parentMenu;

	/** 父菜单编号 */
	@Column(name = "PARENT_MENU_ID", length = 32)
	private String parentMenuId;

	/** 子菜单集合 */
	@OneToMany(mappedBy = "parentMenu", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@OrderColumn(name = "_INDEX")
	@ListIndexBase(value = 1)
	private List<Menu> subMenuList;

	/**
	 * 获取菜单资源编号
	 * 
	 * @return id 菜单资源编号
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置菜单资源编号
	 * 
	 * @param id 菜单资源编号
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取菜单资源名称
	 * 
	 * @return name 菜单资源名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置菜单资源名称
	 * 
	 * @param name 菜单资源名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取菜单导航地址
	 * 
	 * @return navLink 菜单导航地址
	 */
	public String getNavLink() {
		return navLink;
	}

	/**
	 * 设置菜单导航地址
	 * 
	 * @param navLink 菜单导航地址
	 */
	public void setNavLink(String navLink) {
		this.navLink = navLink;
	}

	/**
	 * 获取菜单图标
	 * 
	 * @return iconPath 菜单图标
	 */
	public String getIconPath() {
		return iconPath;
	}

	/**
	 * 设置菜单图标
	 * 
	 * @param iconPath 菜单图标
	 */
	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	/**
	 * 获取数据对象排序序号
	 * 
	 * @return _index 数据对象排序序号
	 */
	public int get_index() {
		return _index;
	}

	/**
	 * 设置数据对象排序序号
	 * 
	 * @param _index 数据对象排序序号
	 */
	public void set_index(int _index) {
		this._index = _index;
	}

	/**
	 * 获取菜单类型1-文件夹2-叶节点
	 * 
	 * @return type 菜单类型1-文件夹2-叶节点
	 */
	public int getType() {
		return type;
	}

	/**
	 * 设置菜单类型1-文件夹2-叶节点
	 * 
	 * @param type 菜单类型1-文件夹2-叶节点
	 */
	public void setType(int type) {
		this.type = type;
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
	 * 获取父菜单
	 * 
	 * @return parentMenu 父菜单
	 */
	public Menu getParentMenu() {
		return parentMenu;
	}

	/**
	 * 设置父菜单
	 * 
	 * @param parentMenu 父菜单
	 */
	public void setParentMenu(Menu parentMenu) {
		if (null != parentMenu) {
			this.parentMenuId = parentMenu.getId();
		}
		this.parentMenu = parentMenu;
	}

	/**
	 * 获取父菜单编号
	 * 
	 * @return parentMenuId 父菜单编号
	 */
	public String getParentMenuId() {
		return parentMenuId;
	}

	/**
	 * 设置父菜单编号
	 * 
	 * @param parentMenuId 父菜单编号
	 */
	protected void setParentMenuId(String parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	/**
	 * 获取子菜单集合
	 * 
	 * @return subMenuList 子菜单集合
	 */
	public List<Menu> getSubMenuList() {
		return subMenuList;
	}

	/**
	 * 设置子菜单集合
	 * 
	 * @param subMenuList 子菜单集合
	 */
	public void setSubMenuList(List<Menu> subMenuList) {
		this.subMenuList = subMenuList;
	}

	/**
	 * 添加子菜单
	 * 
	 * @param subMenu
	 * @return
	 */
	public Menu addSubMenu(Menu subMenu) {
		if (null == this.subMenuList) {
			this.subMenuList = new ArrayList<Menu>();
		}
		subMenuList.add(subMenu);
		return this;
	}
}
