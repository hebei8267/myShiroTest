package com.tjhx.dao.security;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.tjhx.entity.security.Menu;

public interface MenuJpaDao extends CrudRepository<Menu, Integer> {

	@SuppressWarnings("rawtypes")
	public Iterable findAll(Sort sort);

	/**
	 * 根据编号取得菜单资源信息
	 * 
	 * @param id 菜单资源编号
	 * @return 菜单资源信息
	 */
	public Menu getById(String id);
}
