package com.indi.stay.repo.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.indi.stay.domain.Stay;
import com.indi.stay.repo.SearchDao;

@Repository
@Transactional
public  class SearchDaoImpl implements SearchDao {


	@Override
	public Stay findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stay findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Stay> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void register(Stay SearchService) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void persist(Stay transientInstance) {
		// TODO Auto-generated method stub
		
	}


}
