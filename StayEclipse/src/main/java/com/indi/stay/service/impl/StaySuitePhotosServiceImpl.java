package com.indi.stay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public StaySuitePhotos merge(StaySuitePhotos detachedInstance) {
		// TODO Auto-generated method stub
		return staySuitePhotosDao.merge(detachedInstance);
	}

	@Override
	public void remove(StaySuitePhotos persistentInstance) {
		// TODO Auto-generated method stub
		staySuitePhotosDao.remove(persistentInstance);
	}

	@Override
	public StaySuitePhotos findById(int id) {
		// TODO Auto-generated method stub
		return staySuitePhotosDao.findById(id);
	}

	@Override
	@Transactional
	public void findAndDeleteById(int id) {
		// TODO Auto-generated method stub
		StaySuitePhotos staySuitePhotos=staySuitePhotosDao.findById(id);
		staySuitePhotosDao.remove(staySuitePhotos);
	}
	
	

}
