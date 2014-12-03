package com.indi.stay.service;

import java.util.List;

import com.indi.stay.domain.SuiteType;

public interface SuiteTypeService {

	List<SuiteType> findAllOrderedByName();

}
