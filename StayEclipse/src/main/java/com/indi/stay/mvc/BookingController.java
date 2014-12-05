package com.indi.stay.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/Booking")
public class BookingController {

	
	 @RequestMapping(method=RequestMethod.GET)
	    public String displayBookingPage(Model model)
	    {
	        return "pr_search-result";
	    }
	 
	 @RequestMapping(method=RequestMethod.POST,value="/booking")
	    public String handleBooking(Model model)
	    {
		  return "pr_thankupage";
	    }


}
