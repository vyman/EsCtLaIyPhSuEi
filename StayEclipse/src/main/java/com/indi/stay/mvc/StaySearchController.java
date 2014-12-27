package com.indi.stay.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/Search")
public class StaySearchController {

	@RequestMapping(method=RequestMethod.GET)
	public String displayFacilityPage(Model model)
	{
		return "pr_search-result";
	}

}
