package com.tjhx.service.realm;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.tjhx.entity.security.Menu;
import com.tjhx.entity.security.Role;
import com.tjhx.entity.security.User;
import com.tjhx.service.security.UserManager;

public class ShiroDbRealm extends AuthorizingRealm {
	@Resource
	private UserManager userManager;

	/**
	 * 授权函数
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 获取当前登录的用户名
		String loginName = (String) super.getAvailablePrincipal(principals);

		List<String> roles = new ArrayList<String>();
		List<String> permissions = new ArrayList<String>();

		User user = userManager.getByLoginName_Cache(loginName);
		if (user != null) {
			if (user.getRoles() != null && user.getRoles().size() > 0) {
				for (Role role : user.getRoles()) {
					roles.add(role.getName());
					if (role.getMenus() != null && role.getMenus().size() > 0) {
						for (Menu menu : role.getMenus()) {
							if (StringUtils.isNotEmpty(menu.getNavLink())) {
								permissions.add(menu.getNavLink());
							}
						}
					}
				}
			}
		} else {
			throw new AuthorizationException();
		}
		// 给当前用户设置角色
		info.addRoles(roles);
		// 给当前用户设置权限
		info.addStringPermissions(permissions);

		return info;
	}

	/**
	 * 认证回调函数,登录时调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		System.out.println("????????????????????????????????");
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User user = userManager.getByLoginName_Cache(token.getUsername());
		if (user != null) {
			return new SimpleAuthenticationInfo(user.getLoginName(), user.getPassWord(), user.getName());
		} else {
			return null;
		}
	}

}
