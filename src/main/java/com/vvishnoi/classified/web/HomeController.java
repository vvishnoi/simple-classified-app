package com.vvishnoi.classified.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value ="/")
public class HomeController {

	@RequestMapping(method=RequestMethod.GET)
	public String homePage() {
		return "/index.html";
		
	}
}
