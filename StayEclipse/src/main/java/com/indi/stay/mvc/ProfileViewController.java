package com.indi.stay.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.indi.stay.domain.StayNearbyPlaces;
import com.indi.stay.service.GalleryViewServices;
import com.indi.stay.service.ProfileViewServices;
import com.indi.stay.service.StayNearByPlaceService;
import com.indi.stay.service.StayService;
import com.indi.stay.service.StaySuiteService;

@Controller
@RequestMapping(value="/ProfileView")
public class ProfileViewController {
	
	@Autowired
	private ProfileViewServices profileViewServices;
	
	@Autowired
	private StayService stayService;
	
	@Autowired
	private StaySuiteService staySuiteService;
	
	@Autowired 
	private StayNearByPlaceService stayNearByPlaceService;
	
	@Autowired
	private GalleryViewServices galleryViewServices;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String displayBookingPage(Model model)
	{
		List<StayNearbyPlaces> stayNearbyPlaces= stayNearByPlaceService.stayFindNearByPlacesByStayId(1000);
		model.addAttribute("stayNearbyPlaces", stayNearbyPlaces) ;
		return "pr_profileview";
	}

}
