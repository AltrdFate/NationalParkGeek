package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;



@Component
public class JdbcParkDao implements ParkListDao{

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcParkDao(DataSource dataSource){
		this.jdbcTemplate= new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Park> getAllParks() {
		List<Park> parks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT parkcode, parkname, state, parkdescription FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		
		while(results.next()) {
			Park park = new Park();
			park.setParkCode(results.getString("parkcode"));
			park.setParkImageName(results.getString("parkcode").toLowerCase());
			park.setParkName(results.getString("parkname"));
			park.setState(results.getString("state"));
			park.setParkDescription(results.getString("parkdescription"));
			
			parks.add(park);
		}
		return parks;
	}

	@Override
	public Park getParkByParkCode(String parkcode) {
		Park park = new Park();
		String sqlSelectParkByCode = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectParkByCode, parkcode);
		while(results.next()){
			park.setAcerage(results.getInt("acreage"));
			park.setAnnualvisitorcount(results.getInt("annualvisitorcount"));
			park.setClimate(results.getString("climate"));
			park.setElevation(results.getInt("elevationinfeet"));
			park.setInspirationalquote(results.getString("inspirationalquote"));
			park.setMilesoftrail(results.getFloat("milesoftrail"));
			park.setNumberofcampsites(results.getInt("numberofcampsites"));
			park.setParkCode(results.getString("parkcode"));
			park.setParkDescription(results.getString("parkdescription"));
			park.setParkImageName(results.getString("parkcode").toLowerCase());
			park.setParkName(results.getString("parkname"));
			park.setState(results.getString("state"));
			park.setYearfounded(results.getInt("yearfounded"));
			park.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));
			park.setEntryfee(results.getInt("entryfee"));
		}
		return park;
	}

	
}