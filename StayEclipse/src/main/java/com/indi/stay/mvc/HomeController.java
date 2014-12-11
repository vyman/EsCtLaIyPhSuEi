package com.indi.stay.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.indi.stay.domain.Facility;
import com.indi.stay.domain.StaySuite;
import com.indi.stay.domain.SuiteType;
import com.indi.stay.service.FacilityService;
import com.indi.stay.service.StayService;
import com.indi.stay.service.SuiteTypeService;

@Controller
@RequestMapping(value="/Home")
public class HomeController {

	@Autowired
	private StayService stayService;
	
	@Autowired
	private SuiteTypeService suiteTypeService;

	@Autowired
	private FacilityService facilityService;
	
	 @RequestMapping(method=RequestMethod.GET)
	    public String displayFacilityPage(Model model)
	    {
//	        model.addAttribute("staysByRating", stayService.findAllOrderedByRating());
//	        return "pr_search-result";
		 
		 List<SuiteType> suiteTypes= suiteTypeService.findAllOrderedByName();
			List<Facility> facilities= facilityService.findAllOrderedByName();
			model.addAttribute("newRoom", new StaySuite());
			model.addAttribute("facilities", facilities);
			model.addAttribute("suiteTypes", suiteTypes);
			return "pr_addroom";
	    }
	 
	 @RequestMapping(method=RequestMethod.GET,value="/blueimp")
	    public String getStaySuitesAndMenu(Model model)
	    {
		 
	        
	            return "blueimp/basic-plus";
	    }
}
