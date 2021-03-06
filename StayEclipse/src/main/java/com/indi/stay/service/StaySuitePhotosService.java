package com.indi.stay.service;

import com.indi.stay.domain.StaySuitePhotos;

public interface StaySuitePhotosService {
	
	void persist(StaySuitePhotos staySuitePhotos);
	
	StaySuitePhotos merge(StaySuitePhotos detachedInstance);
	
	void remove(StaySuitePhotos persistentInstance);
	
	StaySuitePhotos findById(int id);
	
	void findAndDeleteById(int id);

}
