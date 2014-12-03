package com.indi.stay.repo;

import java.util.List;

import com.indi.stay.domain.StaySuite;

public interface StaySuiteDao {

	void persist(StaySuite staySuite);

	List<StaySuite> findstaySuitesByStayId(int stayId);

	StaySuite findById(int id);

}
