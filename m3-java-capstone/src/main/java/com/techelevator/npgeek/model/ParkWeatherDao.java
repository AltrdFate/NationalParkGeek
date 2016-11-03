package com.techelevator.npgeek.model;

import java.util.List;

public interface ParkWeatherDao {
	public List<ParkWeather> getParkWeatherByCode(String parkCode);
}
