package com.indi.stay.repo;

import java.util.List;

import com.indi.stay.domain.Stay;

public interface StayDao {
	
	public void persist(Stay transientInstance);
	
	public void remove(Stay persistentInstance);
	
	public Stay merge(Stay detachedInstance);
	
	public Stay findById(int id);
	
	public List<Stay> findAllOrderedByName();

	List<Stay> findAllOrderedByRating();

}
