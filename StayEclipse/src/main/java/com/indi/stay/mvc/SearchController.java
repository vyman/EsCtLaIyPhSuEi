package com.indi.stay.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/Search")
public class SearchController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String displayBookingPage(Model model)
	{
		return "search";
	}

}
