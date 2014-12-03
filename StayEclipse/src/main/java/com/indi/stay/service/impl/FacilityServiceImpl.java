package com.indi.stay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indi.stay.domain.Facility;
import com.indi.stay.repo.FacilityDao;
import com.indi.stay.service.FacilityService;

@Service
public class FacilityServiceImpl implements FacilityService {

	@Autowired
	private FacilityDao facilityDao;
	
	public void persist(Facility facility){
		facilityDao.persist(facility);
	}
	
	@Override
	public List<Facility> findAllOrderedByName(){
		return facilityDao.findAllOrderedByName();
	}
}
