/**
 * 
 */
package com.tjhx.controller.security;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author he_bei
 * 
 */
@Controller
public class TestController {
	@RequestMapping(value = "/Link01")
	public String Link01(HttpServletRequest request) {
		System.out.println(request.getPathInfo());
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.checkPermission(request.getPathInfo());
		return "test/Link01";
	}

	@RequestMapping(value = "/Link0101")
	public String Link0101(HttpServletRequest request) {
		System.out.println(request.getPathInfo());
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.checkPermission(request.getPathInfo());
		return "test/Link0101";
	}

	@RequestMapping(value = "/Link0102")
	public String Link0102(HttpServletRequest request) {
		System.out.println(request.getPathInfo());
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.checkPermission(request.getPathInfo());
		return "test/Link0102";
	}

	@RequestMapping(value = "/Link0103")
	public String Link0103(HttpServletRequest request) {
		System.out.println(request.getPathInfo());
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.checkPermission(request.getPathInfo());
		return "test/Link0103";
	}

	@RequestMapping(value = "/Link02")
	public String Link02(HttpServletRequest request) {
		System.out.println(request.getPathInfo());
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.checkPermission(request.getPathInfo());
		return "test/Link02";
	}

	@RequestMapping(value = "/Link0201")
	public String Link0201(HttpServletRequest request) {
		System.out.println(request.getPathInfo());
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.checkPermission(request.getPathInfo());
		return "test/Link0201";
	}
}
