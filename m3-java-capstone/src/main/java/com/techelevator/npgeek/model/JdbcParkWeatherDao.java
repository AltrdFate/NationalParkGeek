package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcParkWeatherDao implements ParkWeatherDao {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcParkWeatherDao(DataSource dataSource){
		this.jdbcTemplate= new JdbcTemplate(dataSource);
	}


	@Override
	public List<ParkWeather> getParkWeatherByCode(String parkcode) {
		
		String sqlSelectWeatherByCode = "SELECT * FROM weather WHERE parkcode = ? ;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectWeatherByCode, parkcode);
		List<ParkWeather> weatherList = new ArrayList<>();
		while(results.next()) {
			ParkWeather weather = new ParkWeather();
			weather.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
			weather.setForecast(results.getString("forecast"));
			weather.setHigh(results.getInt("high"));
			weather.setLow(results.getInt("low"));
			weather.setParkCode(results.getString("parkcode"));
			weatherList.add(weather);
		}
		return weatherList;
	}

	/*@Override
	public ParkWeather getParkWeatherByDay(String parkcode, int day) {
		ParkWeather weather = new ParkWeather();
		String sqlSelectWeatherByDay = "SELECT * FROM weather WHERE parkcode = ? && fivedayforecastvalue = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectWeatherByDay, parkcode, day);
		while()
		return weather;
	}*/
	
	

}
