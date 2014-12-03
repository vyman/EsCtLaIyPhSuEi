package com.indi.stay.test;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.indi.stay.domain.Stay;
import com.indi.stay.domain.StayBookingDetails;
import com.indi.stay.domain.StaySuite;
import com.indi.stay.domain.SuiteType;
import com.indi.stay.repo.StayBookingDetailsDao;
import com.indi.stay.repo.StayDao;
import com.indi.stay.repo.StaySuiteDao;
import com.indi.stay.repo.SuiteTypeDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml",
"classpath:/META-INF/spring/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class StayBookingDetailsDaoTest {

	@Autowired
	private StaySuiteDao staySuiteDao;

	@Autowired
	private StayDao stayDao;

	@Autowired
	private SuiteTypeDao suiteTypeDao;
	
	@Autowired
	private StayBookingDetailsDao stayBookingDetailsDao;

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

		SuiteType suiteType=new SuiteType();
		suiteType.setType("Single");
		suiteTypeDao.persist(suiteType);

		StaySuite staySuite=new StaySuite();
		staySuite.setStay(stay);
		staySuite.setDiscription("test suite");
		staySuite.setSuiteCode("SAD001");
		staySuite.setSuiteType(suiteType);
		staySuiteDao.persist(staySuite);
		int id = staySuite.getId();
		Assert.assertNotNull(id);
		
		StayBookingDetails stayBookingDetails=new StayBookingDetails();
		stayBookingDetails.setStaysuite(staySuite);
		stayBookingDetails.setFromDate(new Date());
		stayBookingDetails.setToDate(new Date());
		
		stayBookingDetailsDao.persist(stayBookingDetails);
		id = stayBookingDetails.getId();
		Assert.assertNotNull(id);
	}
}
