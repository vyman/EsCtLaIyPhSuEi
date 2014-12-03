package com.indi.stay.repo;

import java.util.List;

import com.indi.stay.domain.StayNearbyPlaces;

public interface StayNearByPlaceDao {

	void persist(StayNearbyPlaces stayNearbyPlaces);

	List<StayNearbyPlaces> stayFindNearByPlacesByStayId(int stayId);

}
