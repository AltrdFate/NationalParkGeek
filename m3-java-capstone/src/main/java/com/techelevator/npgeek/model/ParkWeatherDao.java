package com.techelevator.npgeek.model;

import java.util.List;
import java.util.Map;

public interface ParkWeatherDao {
	public List<ParkWeather> getParkWeatherByCode(String parkCode);
	//public ParkWeather getParkWeatherByDay(String parkcode, int day);
}
