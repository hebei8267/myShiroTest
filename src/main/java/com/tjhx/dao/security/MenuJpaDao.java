package com.tjhx.dao.security;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.tjhx.entity.security.Menu;

public interface MenuJpaDao extends CrudRepository<Menu, Integer> {

	@SuppressWarnings("rawtypes")
	public Iterable findAll(Sort sort);
}
