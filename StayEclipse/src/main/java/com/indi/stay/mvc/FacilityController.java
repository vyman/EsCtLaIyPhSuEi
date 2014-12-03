package com.indi.stay.mvc;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.indi.stay.domain.Facility;
import com.indi.stay.service.FacilityService;

@Controller
@RequestMapping(value="/Facility")
public class FacilityController {
	
	@Autowired
	private FacilityService facilityService;
	
	 @RequestMapping(method=RequestMethod.GET)
	    public String displayFacilityPage(Model model)
	    {
	        model.addAttribute("newFacility", new Facility());
	        return "facility";
	    }
	
	 @RequestMapping(method=RequestMethod.POST)
	    public String registerNewFacility(@Valid @ModelAttribute("newFacility") Facility newFacility, BindingResult result, Model model)
	    {
	        if (!result.hasErrors()) {
	        	facilityService.persist(newFacility);
	            return "redirect:/";
	        }
	        else {
	            return "redirect:/Facility";
	        }
	    }

}
