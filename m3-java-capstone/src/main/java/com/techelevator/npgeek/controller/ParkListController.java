package com.techelevator.npgeek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParkListController {

	public ParkListController(){
		
	}
	
	@RequestMapping("/")
	public String displayParkList() {
		return "parkList";
	}
	
}
