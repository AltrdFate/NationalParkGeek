package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcSurveyDao implements SurveyDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcSurveyDao(DataSource dataSource){
		this.jdbcTemplate= new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<SurveyPost> getAllPosts() {
		List<SurveyPost> posts = new ArrayList<>();
		String sqlSelectAllSurveyPosts = "SELECT * FROM survey_result";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllSurveyPosts);
		
		while(results.next()) {
			SurveyPost post = new SurveyPost();
			post.setActivitylevel(results.getString("activitylevel"));
			post.setEmailaddress(results.getString("emailaddress"));
			post.setParkcode(results.getString("parkcode"));
			post.setState(results.getString("state"));
			post.setSurveyid(results.getLong("surveyid"));
			posts.add(post);
		}
		return posts;
	}
	
	@Override
	public List<Park> getSurveyResults(){
		List<Park> parks = new ArrayList<>();
		String sqlSelectSurveyResults = "SELECT p.parkname, COUNT(s.parkcode) FROM survey_result s JOIN park p ON"
				+ " p.parkcode=s.parkcode GROUP BY p.parkname; ";
		SqlRowSet results= jdbcTemplate.queryForRowSet(sqlSelectSurveyResults);
		while(results.next()){
			Park park = new Park();
			park.setParkName(results.getString("parkname"));
			park.setCount(results.getInt("count"));
			parks.add(park);
		}
		return parks;
	}

	@Override
	public void save(SurveyPost post) {
		Long id = getNextId();
		String sqlInsertIntoSurvey = "INSERT INTO survey_result(surveyid, parkcode, emailaddress, state, activitylevel) VALUES(?,?,?,?,?)";
		jdbcTemplate.update(sqlInsertIntoSurvey, id, post.getParkcode(), post.getEmailaddress(), post.getState(), post.getActivitylevel());
		 post.setSurveyid(id);
	}

	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_surveyid')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		Long id = null;
		if(results.next()) {
			id = results.getLong(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next forum post id from sequence");
		}
		return id;
	}
}
