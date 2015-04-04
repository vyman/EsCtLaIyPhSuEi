package com.indi.stay.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.indi.stay.domain.Stay;
import com.indi.stay.service.SearchService;


@Controller
@RequestMapping(value="/Search")
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String displayBookingPage(Model model)
	{
		List<Stay> stays= searchService.findAll();
		model.addAttribute("stayList", stays) ;
		return "search";
	}

}
