package com.indi.stay.service;

import java.util.List;

import com.indi.stay.domain.StayNearbyPlaces;

public interface StayNearByPlaceService {

	void persist(StayNearbyPlaces transientInstance);
	
	List<StayNearbyPlaces> stayFindNearByPlacesByStayId(int stayId);

}
