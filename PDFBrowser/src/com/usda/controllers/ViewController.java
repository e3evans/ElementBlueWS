package com.usda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("VIEW")
public class ViewController {
	
	@RequestMapping
	public String renderView(){
		
		
		return "view";
	}

}
