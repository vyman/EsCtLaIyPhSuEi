package com.indi.stay.service;

import java.util.List;

import com.indi.stay.domain.Stay;

public interface StayService {

	void persist(Stay transientInstance);

	List<Stay> findAllOrderedByRating();
}
