package com.techelevator.npgeek.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.model.ParkListDao;
import com.techelevator.npgeek.model.ParkWeather;
import com.techelevator.npgeek.model.ParkWeatherDao;
import com.techelevator.npgeek.model.User;


@Controller
@SessionAttributes("userChoice")
public class ParkWeatherController {

private ParkWeatherDao weatherDao ;
	
	@Autowired
	public ParkWeatherController(ParkWeatherDao weatherDao){
		this.weatherDao = weatherDao; 
	}
	
	@RequestMapping(path="/viewWeather", method=RequestMethod.GET)
	public String displayWeather(@RequestParam String parkcode,
								ModelMap model){
		List<ParkWeather> weather = null;
			weather = weatherDao.getParkWeatherByCode(parkcode);
			String isFahrenheit = (String) model.get("userChoice");
			if(isFahrenheit == null ) {
				isFahrenheit = "true";
			}
			if(isFahrenheit.equals("true")) {
				for(ParkWeather w: weather) {
					//w.convertToCelsius();
					w.convertToFahrenheit();
				}
			} else {
				for(ParkWeather w: weather) {
					//w.convertToFahrenheit();
					w.convertToCelsius();
				}
			}
		model.put("weather", weather);
		
		return "viewWeather";
	}
	
	@RequestMapping(path="/viewWeather", method=RequestMethod.POST)
	public String displayConvertedWeather(@RequestParam String parkcode,
										@RequestParam String isFahrenheit,
										ModelMap model){
		if(isFahrenheit.equals("true")) {
			isFahrenheit = "false";
		} else {
			isFahrenheit = "true";
		}
		model.addAttribute("userChoice", isFahrenheit);
		model.put("parkcode", parkcode);
		return "redirect:/viewWeather";
	}
	
	
	
	
	
}
