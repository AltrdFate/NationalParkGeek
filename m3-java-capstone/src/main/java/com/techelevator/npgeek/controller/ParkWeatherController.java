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
		if(model.containsAttribute("weather")) {
			weather = (List<ParkWeather>) model.get("weather");
		} else {
			weather = weatherDao.getParkWeatherByCode(parkcode);
		}
		model.put("weather", weather);
		
		return "viewWeather";
	}
	
	@RequestMapping(path="/viewWeather", method=RequestMethod.POST)
	public String displayConvertedWeather(@RequestParam String parkcode,
										@RequestParam String isFahrenheit,
										ModelMap model){
		
		List<ParkWeather> weather = (List<ParkWeather>) model.get("weather");
		weather = weatherDao.getParkWeatherByCode(parkcode);
		User userChoice = new User();
		userChoice.setUserPreference("true");
		if(isFahrenheit.equals("true")) {
			for(ParkWeather w: weather) {
				w.convertToCelsius();
				userChoice.setUserPreference(w.getIsFahrenheit());
			}
		} else {
			for(ParkWeather w: weather) {
				w.convertToFahrenheit();
				userChoice.setUserPreference(w.getIsFahrenheit());
			}
		}
		
		model.addAttribute("userChoice", userChoice);
		model.put("weather", weather);

		return "viewWeather";
	}
	
	
	
	
	
}
