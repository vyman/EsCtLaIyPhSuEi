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
import com.indi.stay.domain.StaySuite;
import com.indi.stay.domain.SuiteType;
import com.indi.stay.repo.StayDao;
import com.indi.stay.repo.StaySuiteDao;
import com.indi.stay.repo.SuiteTypeDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml",
"classpath:/META-INF/spring/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class StaySuiteDaoTest {

	@Autowired
	private StaySuiteDao staySuiteDao;

	@Autowired
	private StayDao stayDao;

	@Autowired
	private SuiteTypeDao suiteTypeDao;

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
		
		List<StaySuite> staySuites= staySuiteDao.findstaySuitesByStayId(stay.getId());
		Assert.assertNotNull(staySuites);
		
		StaySuite staySuite2= staySuiteDao.findById(staySuite.getId());
		Assert.assertNotNull(staySuite2);
	}

}
