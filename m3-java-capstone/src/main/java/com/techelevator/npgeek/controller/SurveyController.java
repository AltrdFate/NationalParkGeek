package com.techelevator.npgeek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.model.SurveyDao;
import com.techelevator.npgeek.model.SurveyPost;

@Controller
public class SurveyController {

	private SurveyDao surveyDao;

	@Autowired
	public SurveyController(SurveyDao surveyDao){
		this.surveyDao = surveyDao;
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String displaySurvey(){
		return "survey";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String postSurvey(SurveyPost post){
		surveyDao.save(post);
		return "redirect:surveyResults";
	}
	
	@RequestMapping("/surveyResults")
	public String displayResults(ModelMap map){
		
		List<SurveyPost> posts = surveyDao.getAllPosts();
		map.put("posts", posts);
		
		return "surveyResults";
	}
}
