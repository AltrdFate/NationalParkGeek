package com.techelevator.npgeek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		map.put("parks", parks);
		
		return "parkList";
	}
	
	@RequestMapping(path="/parkDetail", method=RequestMethod.GET)
	public String displayParkDetail(@RequestParam String parkcode,
									ModelMap map){
		
		Park park = parkDao.getParkByParkCode(parkcode);
		map.put("park", park);
		
		return "parkDetail";
	}
}
