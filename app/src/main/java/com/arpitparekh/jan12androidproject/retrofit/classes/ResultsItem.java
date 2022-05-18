package com.arpitparekh.jan12androidproject.retrofit.classes;

import com.google.gson.annotations.SerializedName;

public class ResultsItem{

	@SerializedName("date")
	private String date;

	@SerializedName("result")
	private String result;

	@SerializedName("venue")
	private String venue;

	@SerializedName("away")
	private Away away;

	@SerializedName("id")
	private int id;

	@SerializedName("match_subtitle")
	private String matchSubtitle;

	@SerializedName("match_title")
	private String matchTitle;

	@SerializedName("series_id")
	private int seriesId;

	@SerializedName("status")
	private String status;

	@SerializedName("home")
	private Home home;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setResult(String result){
		this.result = result;
	}

	public String getResult(){
		return result;
	}

	public void setVenue(String venue){
		this.venue = venue;
	}

	public String getVenue(){
		return venue;
	}

	public void setAway(Away away){
		this.away = away;
	}

	public Away getAway(){
		return away;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setMatchSubtitle(String matchSubtitle){
		this.matchSubtitle = matchSubtitle;
	}

	public String getMatchSubtitle(){
		return matchSubtitle;
	}

	public void setMatchTitle(String matchTitle){
		this.matchTitle = matchTitle;
	}

	public String getMatchTitle(){
		return matchTitle;
	}

	public void setSeriesId(int seriesId){
		this.seriesId = seriesId;
	}

	public int getSeriesId(){
		return seriesId;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setHome(Home home){
		this.home = home;
	}

	public Home getHome(){
		return home;
	}

	@Override
 	public String toString(){
		return "date = " + date.substring(0,10) +
			"\nresult = " + result +
			"\nmatch_title = " + matchTitle +
			"\nstatus = " + status;
		}
}