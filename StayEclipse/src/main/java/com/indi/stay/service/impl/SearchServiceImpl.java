package com.indi.stay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indi.stay.domain.Stay;
import com.indi.stay.repo.SearchDao;
import com.indi.stay.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchDao searchDao;
	
	@Override
	public List<Stay> findAll() {
		// TODO Auto-generated method stub
		return searchDao.findAll();
	}
	
	
}





