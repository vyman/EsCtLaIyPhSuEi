package com.indi.stay.test;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.indi.stay.domain.Role;
import com.indi.stay.repo.RoleDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml",
"classpath:/META-INF/spring/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class RoleDaoTest {

	@Autowired
	private RoleDao roleDao;

	@Test
	public void testFindById()
	{
		Role role = roleDao.findById(1);

		Assert.assertEquals("USER", role.getRole());
		return;
	}

	@Test
	public void testRegister()
	{
		Role role= new Role();
		role.setRole("ADMIN");
		roleDao.register(role);
		int id = role.getId();
		Assert.assertNotNull(id);
	}

	@Test
	public void testFindRole()
	{
		Role role= new Role();
		role.setRole("ADMIN");
		roleDao.register(role);
		int id = role.getId();
		Assert.assertNotNull(id);
		
		role=roleDao.findRole(role.getRole());
		Assert.assertNotNull(role);
		
		role=roleDao.findRole("test");
		Assert.assertNull(role);
	}

}
