package com.indi.stay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indi.stay.domain.StayMenu;
import com.indi.stay.repo.StayMenuDao;
import com.indi.stay.service.StayMenuService;

@Service
public class StayMenuServiceImpl implements StayMenuService {

	@Autowired
	private StayMenuDao stayMenuDao;
	
	@Override
	public StayMenu findByStayId(int stayId) {
		return stayMenuDao.findByStayId(stayId);
	}

}
