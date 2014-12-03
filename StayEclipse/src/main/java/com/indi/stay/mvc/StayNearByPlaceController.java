package com.indi.stay.mvc;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.indi.stay.domain.StayNearbyPlaces;
import com.indi.stay.service.StayNearByPlaceService;

@Controller
@RequestMapping(value="/StayNearByPlace")
public class StayNearByPlaceController {

	@Autowired
	private StayNearByPlaceService stayNearByPlaceService;
	
	@RequestMapping(method=RequestMethod.GET)
    public String displayStayNearByPlacePage(Model model)
    {
        model.addAttribute("newStayNearByPlace", new StayNearbyPlaces());
        return "staySuite";
    }

 @RequestMapping(method=RequestMethod.POST)
    public String registerNewStayNearByPlace(@Valid @ModelAttribute("newStayNearByPlace") StayNearbyPlaces newStayNearByPlace, BindingResult result, Model model)
    {
        if (!result.hasErrors()) {
        	
        	stayNearByPlaceService.persist(newStayNearByPlace);
        	model.addAttribute("stay", newStayNearByPlace.getStay());
        	model.addAttribute("newStayNearByPlace", new StayNearbyPlaces());
            return "addNewStayNearByPlace";
        }
        else {
        	model.addAttribute("error", "Addition of stay Suite Failed");
        	stayNearByPlaceService.persist(newStayNearByPlace);
        	model.addAttribute("stay", newStayNearByPlace.getStay());
        	model.addAttribute("newStayNearByPlace", new StayNearbyPlaces());
            return "addNewStayNearByPlace";
        }
    }
	
}
