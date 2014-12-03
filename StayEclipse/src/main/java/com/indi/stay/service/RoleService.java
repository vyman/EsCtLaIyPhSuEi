package com.indi.stay.service;

import com.indi.stay.domain.Role;

public interface RoleService {
	
	Role findRole(String role);

	public Role findById(Integer id);
	
	public void register(Role role);
}
