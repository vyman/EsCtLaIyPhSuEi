package com.indi.stay.repo;

import java.util.List;

import com.indi.stay.domain.Stay;

public interface SearchDao 
{
    public Stay findById(Long id);

    public Stay findByEmail(String email);

    public List<Stay> findAll();

    public void register(Stay SearchService);

	public void persist(Stay searchService);

 




}
