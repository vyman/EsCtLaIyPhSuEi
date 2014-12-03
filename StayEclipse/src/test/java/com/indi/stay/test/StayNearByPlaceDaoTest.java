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
import com.indi.stay.domain.StayNearbyPlaces;
import com.indi.stay.repo.StayDao;
import com.indi.stay.repo.StayNearByPlaceDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml",
"classpath:/META-INF/spring/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class StayNearByPlaceDaoTest {

	@Autowired
	private StayNearByPlaceDao stayNearByPlaceDao;

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


		StayNearbyPlaces stayNearbyPlaces=new StayNearbyPlaces();
		stayNearbyPlaces.setDiscription("JPNager");
		stayNearbyPlaces.setDistance("25 KM");
		stayNearbyPlaces.setPhoto("//http:5022");
		stayNearbyPlaces.setPlaceName("test Place");
		stayNearbyPlaces.setStay(stay);
		stayNearByPlaceDao.persist(stayNearbyPlaces);
		int id = stayNearbyPlaces.getId();
		Assert.assertNotNull(id);

	List<StayNearbyPlaces> stNearbyPlaces2	=stayNearByPlaceDao.stayFindNearByPlacesByStayId(stay.getId());
	Assert.assertNotNull(stNearbyPlaces2);
	}

}
