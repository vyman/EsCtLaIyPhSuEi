package com.indi.stay.repo;

import com.indi.stay.domain.StaySuitePhotos;

public interface StaySuitePhotosDao {

	void persist(StaySuitePhotos staySuitePhotos);
	
	StaySuitePhotos merge(StaySuitePhotos detachedInstance);

}
