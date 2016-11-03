package com.techelevator.npgeek.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.ParkListDao;
import com.techelevator.npgeek.model.ParkWeather;
import com.techelevator.npgeek.model.ParkWeatherDao;

@Controller
public class ParkWeatherController {

private ParkWeatherDao weatherDao ;
	
	@Autowired
	public ParkWeatherController(ParkWeatherDao weatherDao){
		this.weatherDao = weatherDao; 
	}
	
	@RequestMapping("/viewWeather")
	public String displayWeather(@RequestParam String parkcode,
								ModelMap model){
		
		List<ParkWeather> weather = weatherDao.getParkWeatherByCode(parkcode);
		
		model.put("weather", weather);
		
		return "viewWeather";
	}
	
}
