package com.indi.stay.test;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.indi.stay.domain.Stay;
import com.indi.stay.domain.StayMenu;
import com.indi.stay.repo.StayDao;
import com.indi.stay.repo.StayMenuDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml",
"classpath:/META-INF/spring/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class StayMenuDaoTest {

	@Autowired
	private StayDao stayDao;
	
	@Autowired
	private StayMenuDao stayMenuDao;
	
	@Test
	public void testRegister()
	{

		Stay stay=new Stay();
		stay.setAddress("test address");
		stay.setEmailid("test@test.com");
		stay.setPhoneno("7899653947");
		stay.setStayname("vymanStay");
		stay.setWebsitelink("www.test.com");
		stayDao.persist(stay);

		StayMenu stayMenu=new StayMenu();
		stayMenu.setStay(stay);
		stayMenu.setMenuphoto("TestPhoto");
		stayMenuDao.persist(stayMenu);
		int id = stayMenu.getId();
		Assert.assertNotNull(id);
		
		stayMenu.setMenuphoto("updatedpho");
		StayMenu mergedStayMenu= stayMenuDao.merge(stayMenu);
		Assert.assertEquals("updatedpho", mergedStayMenu.getMenuphoto());
		
		mergedStayMenu= stayMenuDao.findByStayId(stayMenu.getId());
		
		mergedStayMenu= stayMenuDao.findByStayId(2);
//		assertTrue("optforpaper matches", updatedStudentData.getForm1098tPaperOptOut().isOptForPaper() == true);
		
	}

}
