package com.indi.stay.repo;

import java.util.List;

import com.indi.stay.domain.Facility;

public interface FacilityDao {

	void persist(Facility facility);

	List<Facility> findAllOrderedByName();

}
