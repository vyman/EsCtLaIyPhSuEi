package com.indi.stay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indi.stay.domain.StayNearbyPlaces;
import com.indi.stay.repo.StayNearByPlaceDao;
import com.indi.stay.service.StayNearByPlaceService;

@Service
public class StayNearByPlaceServiceImpl implements StayNearByPlaceService {

	@Autowired
	private StayNearByPlaceDao stayNearByPlaceDao;
	
	@Override
	public void persist(StayNearbyPlaces transientInstance){
		stayNearByPlaceDao.persist(transientInstance);
	}

	@Override
	public List<StayNearbyPlaces> stayFindNearByPlacesByStayId(int stayId) {
		return stayNearByPlaceDao.stayFindNearByPlacesByStayId(stayId);
	}
}
