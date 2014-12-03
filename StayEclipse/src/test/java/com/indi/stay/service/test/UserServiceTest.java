package com.indi.stay.service.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
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
import com.indi.stay.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml",
"classpath:/META-INF/spring/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleDao roleDao;
	
	/*@Before
	public void register()
	{
		User user=new User();
		user.setFirstname("Vyman");
		user.setLastname("HM");
		user.setEmail("vyman.huigere@gmail.com");
		user.setEnabled(true);
		user.setPassword("vymtest");
		user.setDateOfBirth(new Date());
		
		Role role= new Role();
		role.setRole("ADMIN");
		
		UserRole userRole=new UserRole();
		userRole.setUser(user);
		userRole.setRole(roleDao.findById(role.getId()));
		Set<UserRole> userRoles=new HashSet<UserRole>();
		user.setUserRoles(userRoles);
		
		userService.register(user);
	}*/

	@Test
	public void sendActivationMail()
	{
		userService.sendActivationMail("vyman.hm@gmail.com","vyman.hm@gmail.com",  "/test/link");
	}
	
	/*@Test
	public void activateUser()
	{
		userService.activateUser("/test/link", 1);
	}*/
}
