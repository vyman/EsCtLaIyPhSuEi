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

import com.indi.stay.domain.SuiteType;
import com.indi.stay.repo.SuiteTypeDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml",
"classpath:/META-INF/spring/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class SuiteTypeDaoTest {

	@Autowired
	private SuiteTypeDao suiteTypeDao;

	@Test
	public void testFindAllOrderedByName()
	{
		SuiteType suiteType=new SuiteType();
		suiteType.setType("Single");
		suiteTypeDao.persist(suiteType);

		SuiteType suiteType2=new SuiteType();
		suiteType2.setType("Double");
		suiteTypeDao.persist(suiteType2);

		List<SuiteType> suiteTypes= suiteTypeDao.findAllOrderedByName();
		Assert.assertEquals(2, suiteTypes.size());

		suiteType = suiteTypes.get(0);

		Assert.assertEquals("Double", suiteType.getType());
		return;
	}
}
