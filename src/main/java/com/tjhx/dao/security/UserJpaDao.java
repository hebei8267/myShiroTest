package com.tjhx.dao.security;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.tjhx.entity.security.User;

public interface UserJpaDao extends CrudRepository<User, Integer> {

	@SuppressWarnings("rawtypes")
	public Iterable findAll(Sort sort);

	/**
	 * 根据登录帐号取得用户信息
	 * 
	 * @param loginName 登录帐号
	 * @return 用户信息
	 */
	public User getByLoginName(String loginName);
}
