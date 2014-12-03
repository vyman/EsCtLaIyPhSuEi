package com.indi.stay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indi.stay.domain.UserRole;
import com.indi.stay.repo.UserRoleDao;
import com.indi.stay.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService{

	@Autowired
	private UserRoleDao userRoleDao;

	@Override
	public void persist(UserRole transientInstance) {
		userRoleDao.persist(transientInstance);
	}
	
	
}
