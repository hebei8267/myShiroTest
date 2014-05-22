/**
 * 
 */
package test.com.tjhx.security;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import org.hibernate.annotations.ListIndexBase;
import org.hibernate.annotations.NaturalId;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.tjhx.entity.security.Menu;

/**
 * @author he_bei
 * 
 */
public class MenuTest extends SpringTransactionalTestCase {
	//MenuJpaDao
	@Test
	@Rollback(false)
	public void addMenu1() {
		Menu menu = new Menu();
		// 菜单资源编号
		menu.setId("00000001");

		// 菜单资源名称
		menu.setName("菜单001");

		// 菜单导航地址
		menu.setNavLink("Link001");

		// 菜单类型 1-文件夹2-叶节点 */
		menu.setType(2);

	}
}
