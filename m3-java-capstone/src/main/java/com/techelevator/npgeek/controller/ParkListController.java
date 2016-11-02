package com.techelevator.npgeek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkListDao;

@Controller
public class ParkListController {

	private ParkListDao parkDao ;
	
	@Autowired
	public ParkListController(ParkListDao parkDao){
		this.parkDao = parkDao; 
	}
	
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String displayParkList(ModelMap map) {
		
		List<Park> parks = parkDao.getAllParks();
		map.addAttribute("parks", parks);
		
		return "parkList";
	}
	
}
