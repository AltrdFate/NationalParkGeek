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
			park.setParkName(results.getString("parkname"));
			park.setState(results.getString("state"));
			park.setParkDescription(results.getString("parkdescription"));
			parks.add(park);
		}
		return parks;
	}

}