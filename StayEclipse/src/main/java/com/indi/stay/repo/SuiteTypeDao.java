package com.indi.stay.repo;

import java.util.List;

import com.indi.stay.domain.SuiteType;

public interface SuiteTypeDao {

	void persist(SuiteType suiteType);

	List<SuiteType> findAllOrderedByName();

}
