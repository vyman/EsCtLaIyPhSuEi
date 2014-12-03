package com.indi.stay.service;

import java.util.List;

import com.indi.stay.domain.StaySuite;

public interface StaySuiteService {

	public void persist(StaySuite transientInstance);
	
	List<StaySuite> findstaySuitesByStayId(int stayId);
	
	StaySuite findById(int id);
	
}
