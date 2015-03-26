package com.indi.stay.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.indi.stay.domain.Facility;
import com.indi.stay.domain.Stay;
import com.indi.stay.domain.StaySuite;
import com.indi.stay.domain.SuiteType;
import com.indi.stay.service.FacilityService;
import com.indi.stay.service.StayService;
import com.indi.stay.service.StaySuiteService;
import com.indi.stay.service.SuiteTypeService;

@Controller
@RequestMapping(value="/StaySuite")
public class StaySuiteController {

	@Autowired
	private StayService stayService;
	
	@Autowired
	private StaySuiteService staySuiteService;
	
	@Autowired
	private SuiteTypeService suiteTypeService;
	
	@Autowired
	private FacilityService facilityService;
	
	 @RequestMapping(method=RequestMethod.GET)
	    public String displayStaySuitePage(Model model)
	    {
	        model.addAttribute("newStaySuite", new StaySuite());
	        return "pr_suiteavilable";
	    }
	
	 @RequestMapping(method=RequestMethod.GET ,value="/getSuiteDetailsByStayId")
	    public String displayStaySuitesForStay(Model model)
	    {
	        model.addAttribute("newStaySuite", new StaySuite());
	        return "pr_suiteavilable";
	    }
	 
	 @RequestMapping(method=RequestMethod.GET ,value="/addSuiteToStay")
	    public String displayAddSuiteToStay(Model model)
	    {
	        
		 	Stay stay= stayService.findById(1000);
	        List<SuiteType> suiteTypes= suiteTypeService.findAllOrderedByName();
			List<Facility> facilities= facilityService.findAllOrderedByName();
			model.addAttribute("newStaySuite", new StaySuite());
			model.addAttribute("stayId", stay.getId());
			model.addAttribute("facilities", facilities);
			model.addAttribute("suiteTypes", suiteTypes);
	        return "addSuite";
	    }
	 
	 
	 @RequestMapping(method=RequestMethod.POST)
	    public String registerNewStaySuite(@Valid @ModelAttribute("newStaySuite") StaySuite newStaySuite, BindingResult result, Model model ,@RequestParam("stayId") Integer stayId)
	    {
	        if (!result.hasErrors()) {
	        	
	        	
	        	List<Facility> facilities=new ArrayList<Facility>();
	        	for(Facility faclity:newStaySuite.getFacilities() )
	        	{
	        		if(faclity.getId()!=null){
	        			facilities.add(facilityService.findById(faclity.getId()));
	        		}
	        	}
	        	newStaySuite.setFacilities(null);
	        	newStaySuite.setFacilities(facilities);
	        	Stay stay= stayService.findById(stayId);
	        	newStaySuite.setStay(stay);
	        	StaySuite staySuite= staySuiteService.merge(newStaySuite);
	        	model.addAttribute("staySuiteId", staySuite.getId());
	        	return "bimp";
	        }
	        else {
	        	model.addAttribute("error", "Addition of stay Suite Failed");
	        	model.addAttribute("newStaySuite", new StaySuite());
				model.addAttribute("facilities", facilityService.findAllOrderedByName());
				model.addAttribute("suiteTypes", suiteTypeService.findAllOrderedByName());
	            return "addSuite";
	        }
	    }
	 
	 @RequestMapping(method=RequestMethod.GET,value="/getSuiteDetailsBySuiteId")
	    public String getSuiteDetailsBySuiteId(Model model,@RequestParam("staySuiteId") int staySuiteId )
	    {
	        model.addAttribute("staySuite", staySuiteService.findById(staySuiteId));
	        return "suiteDetails";
	    }
}
