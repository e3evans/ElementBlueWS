package com.usda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("VIEW")
public class ViewController {
	public static String PREF_WEBSERVER = "com.usda.pref.webserver";
	public static String PREF_DIRECTORY = "com.usda.pref.directory";
	
	
	@RequestMapping
	public String renderView(){
		
		
		return "view";
	}

}
