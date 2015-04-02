package com.indi.stay.repo;

import java.util.List;

import com.indi.stay.domain.Stay;

public interface SearchDao 
{
	public List<Stay> findAll();
}
