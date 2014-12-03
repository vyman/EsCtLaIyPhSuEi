package com.indi.stay.test;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.indi.stay.domain.Facility;
import com.indi.stay.repo.FacilityDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml",
"classpath:/META-INF/spring/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class FacilityDaoTest {
	
	@Autowired
    private FacilityDao facilityDao;
	
	 @Test
	    public void testRegister()
	    {
		Facility facility=new Facility();
		facility.setEquipment("TV");
		 facilityDao.persist(facility);
		 int id = facility.getId();
	        Assert.assertNotNull(id);
	    }

}
