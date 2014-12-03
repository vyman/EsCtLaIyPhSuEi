package com.indi.stay.repo;

import com.indi.stay.domain.StayMenu;

public interface StayMenuDao {

	void persist(StayMenu stayMenu);

	StayMenu merge(StayMenu stayMenu);

	StayMenu findByStayId(int stayId);

}
