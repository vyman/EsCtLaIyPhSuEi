package com.indi.stay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indi.stay.domain.Role;
import com.indi.stay.repo.RoleDao;
import com.indi.stay.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Override
	public Role findRole(String role) {
		return roleDao.findRole(role);
	}

	@Override
	public Role findById(Integer id) {
		// TODO Auto-generated method stub
		return roleDao.findById(id);
	}

	@Override
	public void register(Role role) {
		// TODO Auto-generated method stub
		roleDao.register(role);
	}
}
