package com.indi.stay.mvc;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.indi.stay.domain.Facility;
import com.indi.stay.domain.StaySuite;
import com.indi.stay.domain.SuiteType;
import com.indi.stay.service.FacilityService;
import com.indi.stay.service.SuiteTypeService;

@Controller
@RequestMapping(value="/Room")
public class RoomController {

	@Autowired
	private SuiteTypeService suiteTypeService;

	@Autowired
	private FacilityService facilityService;

	@RequestMapping(method=RequestMethod.GET)
	public String displayBookingPage(Model model)
	{
		return "pr_roomview";
	}

	@RequestMapping(method=RequestMethod.POST,value="/booking")
	public String handleBooking(Model model)
	{
		return "pr_roomview";
	}

	@RequestMapping(method=RequestMethod.GET,value="/addRoom")
	public String getAddRoom(Model model)
	{
		List<SuiteType> suiteTypes= suiteTypeService.findAllOrderedByName();
		List<Facility> facilities= facilityService.findAllOrderedByName();
		model.addAttribute("newRoom", new StaySuite());
		model.addAttribute("facilities", facilities);
		model.addAttribute("suiteTypes", suiteTypes);
		return "pr_addroom";
	}

	@RequestMapping(method=RequestMethod.POST,value="/addRoom")
	public String handleAddRoomBooking(@Valid @ModelAttribute("newRoom") StaySuite staySuite, BindingResult result, Model model)
	{
		if (result.hasErrors()) {
			model.addAttribute("error", null);
			List<SuiteType> suiteTypes= suiteTypeService.findAllOrderedByName();
			List<Facility> facilities= facilityService.findAllOrderedByName();
			model.addAttribute("newRoom", new StaySuite());
			model.addAttribute("facilities", facilities);
			model.addAttribute("suiteTypes", suiteTypes);
			return "pr_addroom";
		}
		else {
			List<SuiteType> suiteTypes= suiteTypeService.findAllOrderedByName();
			List<Facility> facilities= facilityService.findAllOrderedByName();
			model.addAttribute("newRoom", new StaySuite());
			model.addAttribute("facilities", facilities);
			model.addAttribute("suiteTypes", suiteTypes);
			return "pr_addroom";
		}
	}


}
