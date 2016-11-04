package com.techelevator.npgeek.model;

import java.util.List;



public interface SurveyDao {


	public List<SurveyPost> getAllPosts();
	public void save(SurveyPost post);
	List<Park> getSurveyResults();
}
