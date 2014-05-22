package test.com.tjhx.security;

import javax.annotation.Resource;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.tjhx.dao.security.MenuJpaDao;
import com.tjhx.dao.security.RoleJpaDao;
import com.tjhx.entity.security.Role;

public class RoleTest extends SpringTransactionalTestCase {
	@Resource
	private MenuJpaDao menuJpaDao;

	@Resource
	private RoleJpaDao roleJpaDao;

	@Test
	@Rollback(false)
	public void addRole1() {
		Role role = new Role();

		role.setId("R001");// 角色编号
		role.setName("角色001");// 角色名称
		role.setValidFlg("1");// 角色有效性-0:禁用 1:启用
		role.addMenuPmss(menuJpaDao.getById("01"));// 角色和菜单资源的多对多关系映射
		role.addMenuPmss(menuJpaDao.getById("0101"));// 角色和菜单资源的多对多关系映射
		role.addMenuPmss(menuJpaDao.getById("0102"));// 角色和菜单资源的多对多关系映射
		role.addMenuPmss(menuJpaDao.getById("0103"));// 角色和菜单资源的多对多关系映射
		role.addMenuPmss(menuJpaDao.getById("02"));// 角色和菜单资源的多对多关系映射
		role.addMenuPmss(menuJpaDao.getById("0201"));// 角色和菜单资源的多对多关系映射
		
		roleJpaDao.save(role);
	}

	@Test
	@Rollback(false)
	public void addRole2() {
		Role role = new Role();

		role.setId("R002");// 角色编号
		role.setName("角色002");// 角色名称
		role.setValidFlg("1");// 角色有效性-0:禁用 1:启用
		role.addMenuPmss(menuJpaDao.getById("01"));// 角色和菜单资源的多对多关系映射
		role.addMenuPmss(menuJpaDao.getById("0101"));// 角色和菜单资源的多对多关系映射
		role.addMenuPmss(menuJpaDao.getById("0102"));// 角色和菜单资源的多对多关系映射
		role.addMenuPmss(menuJpaDao.getById("0103"));// 角色和菜单资源的多对多关系映射
		
		roleJpaDao.save(role);
	}

	@Test
	@Rollback(false)
	public void addRole3() {
		Role role = new Role();

		role.setId("R003");// 角色编号
		role.setName("角色003");// 角色名称
		role.setValidFlg("1");// 角色有效性-0:禁用 1:启用
		role.addMenuPmss(menuJpaDao.getById("02"));// 角色和菜单资源的多对多关系映射
		role.addMenuPmss(menuJpaDao.getById("0201"));// 角色和菜单资源的多对多关系映射
		
		roleJpaDao.save(role);
	}

	@Test
	@Rollback(false)
	public void addRole4() {
		Role role = new Role();

		role.setId("R004");// 角色编号
		role.setName("角色004");// 角色名称
		role.setValidFlg("0");// 角色有效性-0:禁用 1:启用
		role.addMenuPmss(menuJpaDao.getById("01"));// 角色和菜单资源的多对多关系映射
		role.addMenuPmss(menuJpaDao.getById("0101"));// 角色和菜单资源的多对多关系映射
		role.addMenuPmss(menuJpaDao.getById("0102"));// 角色和菜单资源的多对多关系映射
		role.addMenuPmss(menuJpaDao.getById("0103"));// 角色和菜单资源的多对多关系映射
		role.addMenuPmss(menuJpaDao.getById("02"));// 角色和菜单资源的多对多关系映射
		role.addMenuPmss(menuJpaDao.getById("0201"));// 角色和菜单资源的多对多关系映射
		
		roleJpaDao.save(role);
	}
}
