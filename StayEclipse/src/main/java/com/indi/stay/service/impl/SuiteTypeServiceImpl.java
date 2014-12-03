package com.indi.stay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indi.stay.domain.SuiteType;
import com.indi.stay.repo.SuiteTypeDao;
import com.indi.stay.service.SuiteTypeService;

@Service
public class SuiteTypeServiceImpl implements SuiteTypeService {

	@Autowired
	private SuiteTypeDao suiteTypeDao;
	
	@Override
	public List<SuiteType> findAllOrderedByName(){
		return suiteTypeDao.findAllOrderedByName();
	}
	
}
