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
import com.indi.stay.domain.StayPhotos;
import com.indi.stay.repo.StayDao;
import com.indi.stay.repo.StayPhotoDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml",
"classpath:/META-INF/spring/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class StayPhotoDaoTest {
	
	 @Autowired
	    private StayPhotoDao stayPhotoDao;
	
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
		 stayDao.persist(stay);
		 
		 
		 StayPhotos stayPhotos=new StayPhotos();
		 stayPhotos.setPhoto("photopath");
		 stayPhotos.setDiscription("test photo");
		 stayPhotos.setStay(stay);
		 stayPhotoDao.persist(stayPhotos);
		 int id = stayPhotos.getId();
	        Assert.assertNotNull(id);
	    }

}
