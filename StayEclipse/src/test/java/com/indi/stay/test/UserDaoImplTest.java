package com.indi.stay.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.indi.stay.domain.Role;
import com.indi.stay.domain.User;
import com.indi.stay.domain.UserRole;
import com.indi.stay.repo.RoleDao;
import com.indi.stay.repo.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml",
"classpath:/META-INF/spring/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class UserDaoImplTest {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Test
	public void testRegister()
	{
		User user=new User();
		user.setFirstname("Vyman");
		user.setLastname("HM");
		user.setEmail("vyman.huigere@gmail.com");
		user.setEnabled(true);
		user.setPassword("vymtest");
		user.setDateOfBirth(new Date());
		

//		user.getUserRoles().add(e)
		
		Role role= new Role();
		role.setRole("ADMIN");
		roleDao.register(role);
//		int id = role.getId();
		
		UserRole userRole=new UserRole();
		userRole.setUser(user);
		userRole.setRole(roleDao.findById(role.getId()));
		Set<UserRole> userRoles=new HashSet<UserRole>();
		user.setUserRoles(userRoles);
		
		userDao.register(user);
		int id = user.getId();
		Assert.assertNotNull(id);
		user.getUserRoles();
	}

}
