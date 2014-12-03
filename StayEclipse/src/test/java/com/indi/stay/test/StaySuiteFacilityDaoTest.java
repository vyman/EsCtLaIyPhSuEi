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
import com.indi.stay.domain.Stay;
import com.indi.stay.domain.StaySuite;
import com.indi.stay.domain.SuiteType;
import com.indi.stay.repo.FacilityDao;
import com.indi.stay.repo.StayDao;
import com.indi.stay.repo.StaySuiteDao;
import com.indi.stay.repo.SuiteTypeDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml",
"classpath:/META-INF/spring/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class StaySuiteFacilityDaoTest {

	@Autowired
	private StaySuiteDao staySuiteDao;

	@Autowired
	private StayDao stayDao;

	@Autowired
	private SuiteTypeDao suiteTypeDao;

	@Autowired
	private FacilityDao facilityDao;
	

	@Test
	public void testRegister()
	{

		Facility facility=new Facility();
		facility.setEquipment("TV");
		facilityDao.persist(facility);
		
		Facility facility2=new Facility();
		facility2.setEquipment("News Paper");
		facilityDao.persist(facility2);
		
		Stay stay=new Stay();
		stay.setAddress("test address");
		stay.setEmailid("test@test.com");
		stay.setPhoneno("7899653947");
		stay.setStayname("vymanStay");
		stay.setWebsitelink("www.test.com");
		stayDao.persist(stay);

		SuiteType suiteType=new SuiteType();
		suiteType.setType("Single");
		suiteTypeDao.persist(suiteType);

		

		StaySuite staySuite=new StaySuite();
		staySuite.setStay(stay);
		staySuite.setDiscription("test suite");
		staySuite.setSuiteCode("SAD001");
		staySuite.setSuiteType(suiteType);
		staySuite.getFacilities().add(facility);
		staySuite.getFacilities().add(facility2);
		staySuiteDao.persist(staySuite);
		
		Assert.assertEquals(1, staySuite.getFacilities().size());
				
	}



}
