package test.com.tjhx.security;

import javax.annotation.Resource;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.tjhx.dao.security.RoleJpaDao;
import com.tjhx.dao.security.UserJpaDao;
import com.tjhx.entity.security.User;

public class UserTest extends SpringTransactionalTestCase {

	@Resource
	private RoleJpaDao roleJpaDao;

	@Resource
	private UserJpaDao userJpaDao;

	@Test
	@Rollback(false)
	public void addUser1() {
		User user = new User();

		user.setId("U001");// 用户编号
		user.setName("用户001");// 用户姓名
		user.setLoginName("U001");// 登录帐号
		user.setPassWord("U001");// 登录密码
		user.setValidFlg("1");// 角色有效性-0:禁用 1:启用
		user.addRole(roleJpaDao.getById("R001"));// 添加用户和角色的关系

		userJpaDao.save(user);
	}

	@Test
	@Rollback(false)
	public void addUser2() {
		User user = new User();

		user.setId("U002");// 用户编号
		user.setName("用户002");// 用户姓名
		user.setLoginName("U002");// 登录帐号
		user.setPassWord("U002");// 登录密码
		user.setValidFlg("1");// 角色有效性-0:禁用 1:启用
		user.addRole(roleJpaDao.getById("R002"));// 添加用户和角色的关系
		user.addRole(roleJpaDao.getById("R003"));// 添加用户和角色的关系

		userJpaDao.save(user);
	}

	@Test
	@Rollback(false)
	public void addUser3() {
		User user = new User();

		user.setId("U003");// 用户编号
		user.setName("用户003");// 用户姓名
		user.setLoginName("U003");// 登录帐号
		user.setPassWord("U003");// 登录密码
		user.setValidFlg("1");// 角色有效性-0:禁用 1:启用
		user.addRole(roleJpaDao.getById("R002"));// 添加用户和角色的关系

		userJpaDao.save(user);
	}

	@Test
	@Rollback(false)
	public void addUser4() {
		User user = new User();

		user.setId("U004");// 用户编号
		user.setName("用户004");// 用户姓名
		user.setLoginName("U004");// 登录帐号
		user.setPassWord("U004");// 登录密码
		user.setValidFlg("1");// 角色有效性-0:禁用 1:启用
		user.addRole(roleJpaDao.getById("R004"));// 添加用户和角色的关系

		userJpaDao.save(user);
	}
}
