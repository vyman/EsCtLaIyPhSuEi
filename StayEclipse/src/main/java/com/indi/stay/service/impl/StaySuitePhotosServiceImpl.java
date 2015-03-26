package com.indi.stay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indi.stay.domain.StaySuitePhotos;
import com.indi.stay.repo.StaySuitePhotosDao;
import com.indi.stay.service.StaySuitePhotosService;

@Service
public class StaySuitePhotosServiceImpl implements StaySuitePhotosService {
	
	@Autowired
	private StaySuitePhotosDao staySuitePhotosDao;

	@Override
	public void persist(StaySuitePhotos staySuitePhotos) {
		// TODO Auto-generated method stub
		staySuitePhotosDao.persist(staySuitePhotos);
		
	}

}
