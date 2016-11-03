package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

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

	//need to make it take more than one day
	@Override
	public List<ParkWeather> getParkWeatherByCode(String parkCode) {
		ParkWeather weather = new ParkWeather();
		String sqlSelectWeatherByCode = "SELECT * FROM weather WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectWeatherByCode, parkCode);
		List<ParkWeather> weatherList = new ArrayList<>();
		while(results.next()) {
			weather.se
		}
		return null;
	}

}
