package com.indi.stay.repo;

import java.util.List;

import com.indi.stay.domain.User;

public interface UserDao {

	public User findById(Long id);

	public User findByEmail(String email);

	public List<User> findAllOrderedByName();

	public void register(User user);

	User merge(User detachedInstance);

	User findById(int id);

}
