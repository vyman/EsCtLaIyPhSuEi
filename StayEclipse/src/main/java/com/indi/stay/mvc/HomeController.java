package com.indi.stay.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.indi.stay.service.StayService;

@Controller
@RequestMapping(value="/Home")
public class HomeController {

	@Autowired
	private StayService stayService;
	
	 @RequestMapping(method=RequestMethod.GET)
	    public String displayFacilityPage(Model model)
	    {
	        model.addAttribute("staysByRating", stayService.findAllOrderedByRating());
	        return "pr_search-result";
	    }
	 
	 @RequestMapping(method=RequestMethod.GET,value="/blueimp")
	    public String getStaySuitesAndMenu(Model model)
	    {
		 
	        
	            return "blueimp/basic-plus";
	    }
}
