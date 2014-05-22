package com.tjhx.controller.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tjhx.entity.security.User;
import com.tjhx.globals.Constants;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public String login(User currUser, HttpSession session, HttpServletRequest request) {
		System.out.println("999999999999999999999");
		Subject user = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(currUser.getLoginName(), currUser.getPassWord());
		token.setRememberMe(true);
		try {
			// 调用的ShiroDbRealm的doGetAuthenticationInfo进行身份认证
			user.login(token);

			return "myspace";
		} catch (AuthenticationException e) {
			token.clear();

			return "redirect:/" + Constants.PAGE_REQUEST_PREFIX + "/index";
		}
	}

}
