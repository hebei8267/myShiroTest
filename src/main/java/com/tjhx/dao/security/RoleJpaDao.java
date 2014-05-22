package com.tjhx.dao.security;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.tjhx.entity.security.Role;

public interface RoleJpaDao extends CrudRepository<Role, Integer> {

	@SuppressWarnings("rawtypes")
	public Iterable findAll(Sort sort);

	/**
	 * 根据编号取得角色信息
	 * 
	 * @param id 角色编号
	 * @return 角色信息
	 */
	public Role getById(String id);
}
