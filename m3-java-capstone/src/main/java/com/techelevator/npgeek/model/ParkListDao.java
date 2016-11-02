package com.techelevator.npgeek.model;

import java.util.List;

public interface ParkListDao {

	public List<Park> getAllParks();
	public Park getParkByParkCode(String parkcode);
}
