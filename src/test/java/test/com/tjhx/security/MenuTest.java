/**
 * 
 */
package test.com.tjhx.security;

import javax.annotation.Resource;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.tjhx.dao.security.MenuJpaDao;
import com.tjhx.entity.security.Menu;

public class MenuTest extends SpringTransactionalTestCase {
	@Resource
	private MenuJpaDao menuJpaDao;

	@Test
	@Rollback(false)
	public void addMenu1() {
		Menu menu = new Menu();
		// 菜单资源编号
		menu.setId("01");

		// 菜单资源名称
		menu.setName("一级菜单01");

		// 菜单导航地址
		menu.setNavLink("Link01");

		// 菜单类型 1-文件夹2-叶节点 */
		menu.setType(1);

		menuJpaDao.save(menu);
	}

	@Test
	@Rollback(false)
	public void addMenu11() {
		Menu menu = new Menu();
		// 菜单资源编号
		menu.setId("0101");

		// 菜单资源名称
		menu.setName("二级菜单0101");

		// 菜单导航地址
		menu.setNavLink("Link0101");

		// 父菜单
		Menu parentMenu = menuJpaDao.getById("01");
		menu.setParentMenu(parentMenu);
		parentMenu.addSubMenu(menu);

		// 菜单类型 1-文件夹2-叶节点 */
		menu.setType(2);

		menuJpaDao.save(menu);
	}

	@Test
	@Rollback(false)
	public void addMenu12() {
		Menu menu = new Menu();
		// 菜单资源编号
		menu.setId("0102");

		// 菜单资源名称
		menu.setName("二级菜单0102");

		// 菜单导航地址
		menu.setNavLink("Link0102");

		// 父菜单
		Menu parentMenu = menuJpaDao.getById("01");
		menu.setParentMenu(parentMenu);
		parentMenu.addSubMenu(menu);

		// 菜单类型 1-文件夹2-叶节点 */
		menu.setType(2);

		menuJpaDao.save(menu);
	}

	@Test
	@Rollback(false)
	public void addMenu13() {
		Menu menu = new Menu();
		// 菜单资源编号
		menu.setId("0103");

		// 菜单资源名称
		menu.setName("二级菜单0103");

		// 菜单导航地址
		menu.setNavLink("Link0103");

		// 父菜单
		Menu parentMenu = menuJpaDao.getById("01");
		menu.setParentMenu(parentMenu);
		parentMenu.addSubMenu(menu);

		// 菜单类型 1-文件夹2-叶节点 */
		menu.setType(2);

		menuJpaDao.save(menu);
	}

	@Test
	@Rollback(false)
	public void addMenu2() {
		Menu menu = new Menu();
		// 菜单资源编号
		menu.setId("02");

		// 菜单资源名称
		menu.setName("二级菜单02");

		// 菜单导航地址
		menu.setNavLink("Link02");

		// 菜单类型 1-文件夹2-叶节点 */
		menu.setType(1);

		menuJpaDao.save(menu);
	}

	@Test
	@Rollback(false)
	public void addMenu21() {
		Menu menu = new Menu();
		// 菜单资源编号
		menu.setId("0201");

		// 菜单资源名称
		menu.setName("二级菜单0201");

		// 菜单导航地址
		menu.setNavLink("Link0201");

		// 父菜单
		Menu parentMenu = menuJpaDao.getById("02");
		menu.setParentMenu(parentMenu);
		parentMenu.addSubMenu(menu);

		// 菜单类型 1-文件夹2-叶节点 */
		menu.setType(2);

		menuJpaDao.save(menu);
	}
}
