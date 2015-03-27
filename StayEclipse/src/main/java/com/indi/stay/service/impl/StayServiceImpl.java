package com.indi.stay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indi.stay.domain.Stay;
import com.indi.stay.repo.StayDao;
import com.indi.stay.service.NuxeoServerService;
import com.indi.stay.service.StayService;

@Service
public class StayServiceImpl implements StayService {

	@Autowired
	private StayDao stayDao;
	
	@Autowired
	private NuxeoServerService nuxeoServerService;
	
	@Override
	public void persist(Stay transientInstance){
		String profileImgPath=nuxeoServerService.persistImageAndReturnPath(transientInstance.getProfileImagePic());
		transientInstance.setProfileImgPath(profileImgPath);
		transientInstance.setProfileImagePic(null);
		stayDao.persist(transientInstance);
	}

	@Override
	public List<Stay> findAllOrderedByRating() {
		// TODO Auto-generated method stub
		return stayDao.findAllOrderedByRating();
	}

	@Override
	public Stay findById(int id) {
		// TODO Auto-generated method stub
		return stayDao.findById(id);
	}

	@Override
	public Stay merge(Stay detachedInstance) {
		// TODO Auto-generated method stub
		String profileImgPath=nuxeoServerService.persistImageAndReturnPath(detachedInstance.getProfileImagePic());
		detachedInstance.setProfileImgPath(profileImgPath);
		detachedInstance.setProfileImagePic(null);
		return stayDao.merge(detachedInstance);
	}
	
	
}
