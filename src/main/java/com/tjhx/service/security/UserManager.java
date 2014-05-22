package com.tjhx.service.security;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.cache.memcached.SpyMemcachedClient;

import com.tjhx.dao.security.UserJpaDao;
import com.tjhx.entity.security.User;
import com.tjhx.globals.MemcachedObjectType;

@Service
@Transactional(readOnly = true)
public class UserManager {
	private static Logger logger = LoggerFactory.getLogger(UserManager.class);

	@Resource
	private UserJpaDao userJpaDao;
	@Resource
	private SpyMemcachedClient spyMemcachedClient;

	/**
	 * 根据登录帐号取得用户信息
	 * 
	 * @param loginName 登录帐号
	 * @return 用户信息
	 */
	public User getByLoginName1(String loginName) {
		return userJpaDao.getByLoginName(loginName);
	}

	/**
	 * 根据登录帐号取得用户信息 Cache
	 * 
	 * @param loginName 登录帐号
	 * @return 用户信息
	 */
	public User getByLoginName_Cache(String loginName) {
		System.out.println("getByLoginName_Cache@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		List<User> _userList = getAllUser_Cache();

		for (User user : _userList) {
			if (user.getLoginName().equals(loginName)) {
				return user;
			}
		}
		return null;
	}

	/**
	 * 取得全量人员信息
	 * 
	 * @return 全量人员信息
	 */
	public List<User> getAllUser_Cache() {
		List<User> _userList = spyMemcachedClient.get(MemcachedObjectType.USER_LIST.getObjKey());

		if (null == _userList) {
			// 从数据库中取出全量人员信息(List格式)
			_userList = (List<User>) userJpaDao.findAll();
			// 将人员信息Map保存到memcached
			spyMemcachedClient.set(MemcachedObjectType.USER_LIST.getObjKey(), MemcachedObjectType.USER_LIST.getExpiredTime(),
					_userList);

			logger.debug("人员信息不在 memcached中,从数据库中取出并放入memcached");
		} else {
			logger.debug("从memcached中取出人员信息");
		}
		return _userList;
	}

}