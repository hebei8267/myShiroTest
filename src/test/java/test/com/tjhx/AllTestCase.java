package test.com.tjhx;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.com.tjhx.security.MenuTest;
import test.com.tjhx.security.RoleTest;
import test.com.tjhx.security.UserTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ MenuTest.class, RoleTest.class, UserTest.class })
public class AllTestCase {

}
