package com.indi.stay.repo;

import java.util.List;

import com.indi.stay.domain.Role;

public interface RoleDao {

	public Role findById(Integer id);

    public List<Role> findAllOrderedByName();

    public void register(Role role);

	Role findRole(String role);
}
