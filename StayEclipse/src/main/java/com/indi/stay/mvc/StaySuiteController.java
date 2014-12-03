package com.indi.stay.mvc;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.indi.stay.domain.StaySuite;
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
	
	 @RequestMapping(method=RequestMethod.GET)
	    public String displayStaySuitePage(Model model)
	    {
	        model.addAttribute("newStaySuite", new StaySuite());
	        return "staySuite";
	    }
	
	 @RequestMapping(method=RequestMethod.POST)
	    public String registerNewStaySuite(@Valid @ModelAttribute("newStaySuite") StaySuite newStaySuite, BindingResult result, Model model)
	    {
	        if (!result.hasErrors()) {
	        	
	        	staySuiteService.persist(newStaySuite);
	        	model.addAttribute("stay", newStaySuite.getStay());
	        	model.addAttribute("suite", new StaySuite());
	        	model.addAttribute("types", suiteTypeService.findAllOrderedByName());
	            return "addSuite";
	        }
	        else {
	        	model.addAttribute("error", "Addition of stay Suite Failed");
	        	model.addAttribute("stay", newStaySuite.getStay());
	        	model.addAttribute("suite", new StaySuite());
	        	model.addAttribute("types", suiteTypeService.findAllOrderedByName());
	            return "addSuite";
	        }
	    }
	 
	 @RequestMapping(method=RequestMethod.GET,value="/getSuiteDetailsBySuiteId")
	    public String getSuiteDetailsBySuiteId(Model model,@RequestParam("staySuiteId") int staySuiteId )
	    {
	        model.addAttribute("staySuite", staySuiteService.findById(staySuiteId));
	        return "suiteDetails";
	    }
	 
	 @RequestMapping(method=RequestMethod.GET,value="/add")
	    public String addSuiteOfStay(Model model )
	    {
	        return "pr_addroom";
	    }
}
