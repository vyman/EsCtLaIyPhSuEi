package com.indi.stay.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		model.addAttribute("stays", stayService.findAllOrderedByRating());
		return "pr_home";
	}	 
}
