package com.indi.stay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indi.stay.domain.StaySuite;
import com.indi.stay.repo.StaySuiteDao;
import com.indi.stay.service.StaySuiteService;

@Service
public class StaySuiteServiceImpl implements StaySuiteService {

	@Autowired
	private StaySuiteDao staySuiteDao;
	
	public void persist(StaySuite transientInstance){
		staySuiteDao.persist(transientInstance);
	}

	@Override
	public List<StaySuite> findstaySuitesByStayId(int stayId) {
		return staySuiteDao.findstaySuitesByStayId(stayId);
	}

	@Override
	public StaySuite findById(int id) {
		return staySuiteDao.findById(id);
	}
}
