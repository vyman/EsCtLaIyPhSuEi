package com.indi.stay.service;

import com.indi.stay.domain.StayMenu;

public interface StayMenuService {
	
	StayMenu findByStayId(int stayId);

}
