package com.indi.stay.service;

import java.util.List;

import com.indi.stay.domain.Facility;

public interface FacilityService {

	void persist(Facility facility);

	List<Facility> findAllOrderedByName();
	
	Facility findById(int id);
}
