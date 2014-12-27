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

import com.indi.stay.domain.Stay;
import com.indi.stay.service.StayMenuService;
import com.indi.stay.service.StayNearByPlaceService;
import com.indi.stay.service.StayService;
import com.indi.stay.service.StaySuiteService;
import com.indi.stay.service.SuiteTypeService;

@Controller
@RequestMapping(value="/Stay")
public class StayController {

	@Autowired
	private StayService stayService;

	@Autowired
	private SuiteTypeService suiteTypeService;

	@Autowired
	private StayNearByPlaceService stayNearByPlaceService;

	@Autowired
	private StayMenuService stayMenuService;

	@Autowired
	private StaySuiteService staySuiteService;


	@RequestMapping(method=RequestMethod.GET , value="/Type")
	public String displayStayType(Model model)
	{
		return "pr_staytype";
	}

	@RequestMapping(method=RequestMethod.POST , value="/Type")
	public String handleStayType(Model model)
	{
		model.addAttribute("stayType", new Stay());
		return "stay";
	}


	@RequestMapping(method=RequestMethod.GET)
	public String displayStayPage(Model model)
	{
		model.addAttribute("newStay", new Stay());
		return "pr_stayinfo";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String registerNewFacility(@Valid @ModelAttribute("newStay") Stay newStay, BindingResult result, Model model)
	{
		if (result.hasErrors()) {
			model.addAttribute("error", null);
			return "pr_stayinfo";
		}
		else {
			stayService.persist(newStay);
			return "pr_stayinfo";
		}
	}
	
	//Method to display stay suites avilable,menu,nearby place based on stay ID
	
	@RequestMapping(method=RequestMethod.GET,value="/getStaySuitesAndMenu")
	public String getStaySuitesAndMenu(@RequestParam("stayId") Integer stayId,Model model)
	{

		if (stayId!=null) {
			model.addAttribute("staySuites", staySuiteService.findstaySuitesByStayId(stayId));
			model.addAttribute("stayMenu", stayMenuService.findByStayId(stayId));
			model.addAttribute("stayNearByPlaces", stayNearByPlaceService.stayFindNearByPlacesByStayId(stayId));
			return "pr_suiteavilable";
		}
		else {
			return "redirect:/home";
		}
	}
}
