package com.indi.stay.test;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.indi.stay.domain.Stay;
import com.indi.stay.repo.StayDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml",
"classpath:/META-INF/spring/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class StayDaoTest {
	
	@Autowired
    private StayDao stayDao;
	
	 @Test
	    public void testRegister()
	    {
		 Stay stay=new Stay();
		 stay.setAddress("test address");
		 stay.setEmailid("test@test.com");
		 stay.setPhoneno("7899653947");
		 stay.setStayname("vymanStay");
		 stay.setWebsitelink("www.test.com");
		 stay.setRating(4);
		 stayDao.persist(stay);
		 
		 Stay stay1=new Stay();
		 stay1.setAddress("test address");
		 stay1.setEmailid("test@test.com");
		 stay1.setPhoneno("7899653947");
		 stay1.setStayname("vymanStay");
		 stay1.setWebsitelink("www.test.com");
		 stay1.setRating(5);
		 stayDao.persist(stay1);
		 
		 Stay stay2=new Stay();
		 stay2.setAddress("test address");
		 stay2.setEmailid("test@test.com");
		 stay2.setPhoneno("7899653947");
		 stay2.setStayname("vymanStay");
		 stay2.setWebsitelink("www.test.com");
		 stay2.setRating(1);
		 stayDao.persist(stay2);
		 int id = stay.getId();
	        Assert.assertNotNull(id);
	        
	    List<Stay> stays=   stayDao.findAllOrderedByRating();
	    Assert.assertNotNull(stays);
	    }

	 
}
