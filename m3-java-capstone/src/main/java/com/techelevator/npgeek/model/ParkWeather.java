package com.techelevator.npgeek.model;

public class ParkWeather {
	
	private String parkcode;
	private int fivedayforecastvalue;
	private int low;
	private int high;
	private String forecast;
	private String forecastRecomendation;
	private String tempRecomendation;
	private String tempDifference;
	private int celciusTemp;
	private String isFahrenheit = "true";
	private int highC;
	private int lowC;
	
	public String getParkCode() {
		return parkcode;
	}
	public void setParkCode(String parkcode) {
		this.parkcode = parkcode;
	}
	public int getFiveDayForecastValue() {
		return fivedayforecastvalue;
	}
	public void setFiveDayForecastValue(int fivedayforecastvalue) {
		this.fivedayforecastvalue = fivedayforecastvalue;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	
	/*public void setHighC(){
		this.highC = convertToCelcius(this.high);
	}
	public int getHighC(){
		highC = convertToCelcius(high);
		return highC;
	}
	
	public void setLowC(){
		this.lowC = convertToCelcius(this.low);
	}
	public int getLowC(){
		return convertToCelcius(this.low);
	}*/

	public String getForecastRecomendation(){
	
		if(forecast.equals("rain")){
			forecastRecomendation = "Don't Forget Your Umbrella";
		}
		else if(forecast.equals("snow")){
			forecastRecomendation ="Don't Forget Your Snow Shoes";
		}
		else if(forecast.equals("thunderstorms")){
			forecastRecomendation ="Don't Get Struck By Lightening";
		}
		else {
			forecastRecomendation ="Don't Forget Your Sun Screen";
		}
		return forecastRecomendation;
	}
	
	/*private int convertToCelcius(int num){
		
			num = (int)((high - 32) * 1.8);	
			return num;
	}*/
	
	public void convertToCelsius() {
		if(isFahrenheit.equals("true")) {
			high = (int)((high - 32) / 1.8);	
			low = (int)((low - 32) / 1.8);
			isFahrenheit = "false";
		}
	}
	
	public void convertToFahrenheit() {
		if(isFahrenheit.equals("false")) {
			high = (int)((high + 32) * 1.8);	
			low = (int)((low + 32) *1.8);
			isFahrenheit = "true";
		}
	}
	
	public String getTempRecomendation(){
		if(high >= 75){
			tempRecomendation= "Be sure to bring an extra gallon of water";
		}
		if(low <= 20){
			tempRecomendation ="Be ware the dangers of exposure to frigid temperatures";
		}
		return tempRecomendation;
	}
	
	public String getTempDifference(){
		if((high-low) >= 20){
			tempDifference= "Be sure to wear breathable layers";
		}
		
		return tempDifference;
	}
	
	public String getIsFahrenheit() {
		return isFahrenheit;
	}
	public void setFahrenheit(String isFahrenheit) {
		this.isFahrenheit = isFahrenheit;
	}
}
